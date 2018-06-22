package problem1;

import java.util.HashSet;
import java.util.Random;

/**
 * @author huylv
 */
public class Solve {

    private static Random random = new Random();

    public static void main(String[] args) {
        // Create 2 HashSet Integer
        HashSet<Integer> hashSetInteger1 = new HashSet<>();
        HashSet<Integer> hashSetInteger2 = new HashSet<>();

        // add element to 2 HashSet
        while (hashSetInteger1.size() != 2000000) {
            hashSetInteger1.add(random.nextInt(3900000)); // 2*10^6 * 2 - %5
        }
        while (hashSetInteger2.size() != 2000000) {
            hashSetInteger2.add(random.nextInt(3900000));
        }
        HashSet<Integer> setSum = new HashSet<>(hashSetInteger1);
        HashSet<Integer> setSub = new HashSet<>(hashSetInteger1);

        // show 2 HashSet
//        System.out.println("Các phần tử của hashSetInteger1: " + hashSetInteger1);
//        System.out.println("Các phần tử của hashSetInteger2: " + hashSetInteger2);

        //start
        long lStartTime = System.nanoTime();

        // Union 2 hashset
        setSum.addAll(hashSetInteger2);

        // Intersection 2  Hashset()
        setSub.retainAll(hashSetInteger2);

        //end
        long lEndTime = System.nanoTime();

        System.out.println("Estimates time in milliseconds: " + (lEndTime - lStartTime) / 1000000);

//        System.out.print("Các phần tử giao là: " + setSub);
//        System.out.println("Các phần tử của hợp" + hashSetInteger1);

    }
}
