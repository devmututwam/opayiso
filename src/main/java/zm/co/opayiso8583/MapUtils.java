/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.co.opayiso8583;

/**
 *
 * @author Mambwe Mwansa
 */
import java.util.HashMap;
import java.util.Map;

// Program to Increment a Map value in Java 8 and above
public class MapUtils {

    public static String STAN;
    public static String RRN;
    static Map<String, String> hashMap = new HashMap();

    public static <K> void makeStan(Map<K, String> map, K key) {
        map.putIfAbsent(key, "000001");
        int num = Integer.parseInt(map.get(key));
        if (map.get(key).equals("999999")) {
            map.put(key, "000001");
            num = 0;
            map.clear();
        }
        String stan = String.format("%06d", num + 1);
        map.put(key, stan);

    }

    public static <K> void makeRRN(Map<K, String> map, K key) {
        map.putIfAbsent(key, "000000000001");
        int num = Integer.parseInt(map.get(key));
        if (map.get(key).equals("999999999999")) {
            map.put(key, "000000000001");
            num = 0;
            map.clear();

        }
        String stan = String.format("%012d", num + 1);
        map.put(key, stan);

    }

    public static String getSTAN() {
        makeStan(hashMap, "STAN");
        return hashMap.get("STAN");
    }

    public static String getSIGN_ON_STAN() {
        makeStan(hashMap, "SIGN_ON_STAN");
        return hashMap.get("SIGN_ON_STAN");
    }

    public static String getRRN() {

        makeStan(hashMap, "RRN");
        return hashMap.get("RRN");
    }

    public static String SIGN_ON() {
        hashMap.putIfAbsent("SIGN_ON", "NOT_CONNECTED");
        return hashMap.get("SIGN_ON");
    }

    static void SIGN_ON(String connected) {
        hashMap.put("SIGN_ON", connected);
    }

}
