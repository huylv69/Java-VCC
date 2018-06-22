import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws InterruptedException, MalformedURLException, UnsupportedEncodingException {
//        Random random  = new Random();
//        HashSet<Integer> hashSetInteger1 = new HashSet<>();
//        while(hashSetInteger1.size() != 20) {
//            hashSetInteger1.add(random.nextInt(3900000));
//        }
//        System.out.println(hashSetInteger1);
//
//        //start
//        long lStartTime = System.nanoTime();
//
//        //task
//        try {
//            calculation();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //end
//        long lEndTime = System.nanoTime();
//
//        //time elapsed
//        long output = lEndTime - lStartTime;
//
//        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
//        URL url = new URL(" https://www.google.com.vn/search?q=string+java+practice&rlz=1C1CHZL_viVN741VN741&oq=string&aqs=chrome.2.69i57j69i60j69i59j69i60.2342j0j1&sourceid=chrome&ie=UTF-8");
//
//        Map<String, LinkedList<String>> queryParser = new HashMap<String, LinkedList<String>>();
//        final String[] pairs = url.getQuery().split("&");
////        System.out.println(pairs[1]); //rlz=1C1CHZL_viVN741VN741
//        for (String pair : pairs) {
//            final int idx = pair.indexOf("=");
//            final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
//            if (!queryParser.containsKey(key)) {
//                queryParser.put(key, new LinkedList<String>());
//            }
//            final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
//            queryParser.get(key).add(value);
////        }
//
//        }
//        String s = "abcd";
//        System.out.println(s.substring(0,2));
//        System.out.println(s.substring(2,s.length()));

        ConcurrentMap<String, Integer> wordCount =
        new ConcurrentHashMap<String, Integer>();
        String s = "q";
        Integer oldVal, newVal;
        Integer cnt = wordCount.get(s);
        // first case: there was nothing in the table yet
        if (cnt == null) {
            // attempt to put 1 in the table.  If the old
            // value was null, then we are OK.  If not, then
            // some other thread put a value into the table
            // instead, so we fall through
            oldVal = wordCount.put(s, 1);
            if (oldVal == null) return;
        }
        // general case: there was something in the table
        // already, so we have increment that old value

        // only replace the value if the old one currently there is the same as the one passed in.
        do {
            oldVal = wordCount.get(s);
            newVal = (oldVal == null) ? 1 : (oldVal + 1);
        } while (!wordCount.replace(s, oldVal, newVal));

    }
    private static void calculation() throws InterruptedException {

        //Sleep 2 seconds
        TimeUnit.SECONDS.sleep(2);

    }
}
