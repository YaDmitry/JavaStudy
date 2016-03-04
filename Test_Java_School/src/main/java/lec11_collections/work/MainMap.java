package lec11_collections.work;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dmya on 3/3/2016.
 */
public class MainMap {

    public static void main(String[] args) {

        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("1", 1);
        map.put("1", 1);
        map.put("2", 1);
        map.put("3", 1);
        map.put("4", 1);

        for (String key : map.keySet()) {
            System.out.println("key = " + key + ", value =  " + map.get(key));
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value =  " + entry.getValue());
        }
    }
}
