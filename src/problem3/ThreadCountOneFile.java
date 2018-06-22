package problem3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentMap;

/**
 * @author huylv
 */
public class ThreadCountOneFile implements Runnable {
    private String fileName;
    private ConcurrentMap<String, Integer> wordCount;
    private final static String DELIMS = " :;,.{}()\t\n";

    public ThreadCountOneFile(String fileName, ConcurrentMap<String, Integer> wordCount) {
        this.fileName = fileName;
        this.wordCount = wordCount;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, DELIMS);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    updateCount(token);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.print("Exception");
        } finally {
        }

    }

    private void updateCount(String key) {
        Integer oldVal, newVal;
        Integer count = wordCount.get(key);
        if (count == null) { // not contains key
            oldVal = wordCount.put(key, 1); //oldVal = null
            if (oldVal == null) return;
        }
        // only replace the value if the old one currently there is the same as the one passed in.
        do {
            oldVal = wordCount.get(key);
            newVal = (oldVal == null) ? 1 : (oldVal + 1);
        } while (!wordCount.replace(key, oldVal, newVal));
    }
}

