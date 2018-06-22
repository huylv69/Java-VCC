package problem2;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author huylv
 */
public class Solve {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("01.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        try {
            while ((line = bf.readLine()) != null) {
                StringTokenizer words = new StringTokenizer(line, " ");
                while (words.hasMoreTokens()) {
                    String token = words.nextToken();
//                    System.out.println("token"+ words.nextToken());
                    if (hashMap.containsKey(token)) {
                        hashMap.put(token, hashMap.get(token) + 1);
                    } else {
                        hashMap.put(token, 1);
                    }
                }
            }

            // create iterator for map
            Iterator<Map.Entry<String, Integer>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> pairs = it.next();
                writer.write(pairs.getKey() + " : " + pairs.getValue() + "\n");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            bf.close();
        }
    }
}
