package problem3;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author huylv
 */
public class Solve {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedWriter writer = new BufferedWriter(new FileWriter("output3.txt")); // File Output
        ExecutorService pool = Executors.newFixedThreadPool(6);
        ConcurrentMap<String, Integer> wordCount = new ConcurrentHashMap<String, Integer>();
        // Read folder
        File folder = new File("input3");
        File[] listOfFiles = folder.listFiles();
        System.out.println("Total Input files: " + listOfFiles.length);

        for (int i = 0; i < listOfFiles.length; i++) {
            pool.submit(new ThreadCountOneFile(listOfFiles[i].getPath(), wordCount));
        }
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            System.out.println("Pool interrupted!");
            System.exit(1);
        }
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        int total = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            int count = entry.getValue();
            total += count;
            writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
        }
        System.out.println("Total words = " + total);
        System.out.println("Total time = " + elapsed + " ms");
        writer.close();

        System.out.println("\n Top 10 words with the highest frequency ");
        PriorityQueue<Map.Entry<String, Integer>> greatest = findGreatest(wordCount);
        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Integer> entry = greatest.poll();
            System.out.println(entry);
        }
        System.out.println("\n Top 10 words with the lowest frequency ");
        PriorityQueue<Map.Entry<String, Integer>> lowest = findLowest(wordCount);
        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Integer> entry = lowest.poll();
            System.out.println(entry);
        }
    }


    private static <K, V extends Comparable<? super V>> PriorityQueue<Map.Entry<K, V>> findGreatest(Map<K, V> map) {
        Comparator<? super Map.Entry<K, V>> comparator = new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e0, Map.Entry<K, V> e1) {
                V v0 = e0.getValue();
                V v1 = e1.getValue();
                return v1.compareTo(v0);
            }
        };
        PriorityQueue<Map.Entry<K, V>> highest = new PriorityQueue<>(map.size(), comparator);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            highest.offer(entry);
        }

        return highest;
    }

    private static <K, V extends Comparable<? super V>> PriorityQueue<Map.Entry<K, V>> findLowest(Map<K, V> map) {
        Comparator<? super Map.Entry<K, V>> comparator = new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e0, Map.Entry<K, V> e1) {
                V v0 = e0.getValue();
                V v1 = e1.getValue();
                return v0.compareTo(v1);
            }
        };
        PriorityQueue<Map.Entry<K, V>> lowest = new PriorityQueue<>(map.size(), comparator);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            lowest.offer(entry);
        }

        return lowest;
    }
}