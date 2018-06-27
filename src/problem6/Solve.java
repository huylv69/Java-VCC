package problem6;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huylv
 */
public class Solve {
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        URL url = new URL(" https://www.google.com.vn/search?q=string+java+practice&rlz=1C1CHZL_viVN741VN741&oq=string&aqs=chrome.2.69i57j69i60j69i59j69i60.2342j0j1&sourceid=chrome&ie=UTF-8");
        Map<String, String> queryParser = new LinkedHashMap<>();
        final String[] pairs = url.getQuery().split("&");
//        System.out.println(pairs[1]); //rlz=1C1CHZL_viVN741VN741
        for (String pair : pairs) {
            final int idx = pair.indexOf("=");
            final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
            final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
            queryParser.put(key, value);
        }

        System.out.println("Parsing Origin URL");
        System.out.println("Domain: " + url.getHost());
        for (Map.Entry<String, String> entry : queryParser.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\n ---------- \n Build New URL");
        String newUrl = "";
        Iterator iterator = queryParser.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            if (iterator.hasNext()) {
                newUrl = newUrl.concat(element.getKey() + "=" + "newValue" + "&");
            } else {
                newUrl = newUrl.concat(element.getKey() + "=" + "newValue");
            }
        }
        System.out.println("URL: " + url.getProtocol() + "://" + url.getHost() + url.getPath() + "?" + newUrl);
    }
}