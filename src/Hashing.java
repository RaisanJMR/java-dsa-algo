import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Unordered map
public class Hashing {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 120);
        map.put("Usa", 30);
        map.put("China", 200);
        map.put("China", 150);
        System.out.println(map);

        // Search
        // map.containsKey(key)

        // map.get("<key>");0

        // for(int val:arr)

        // for (Map.Entry<String, Integer> e : map.entrySet()) {
        // System.out.println(e.getKey());
        // System.out.println(e.getValue());
        // }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        // map.remove();
    }
}
