import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// O(1)
// implemented array of LL
// Unordered map
public class Hashing {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("INDIA", 120);
        map.put("USA", 30);
        map.put("CHINA", 190);
        map.put("SPAIN", 20);
        map.put("UK", 70);
        map.put("CANADA", 15);
        // System.out.println(map);
        // SEARCH
        // map.containsKey()
        // map.get()
        // map.remove()
        // map.size()
        // for (int i = 0; i < args.length; i++) {

        // }
        // String car[] = { "ford", "benz" };
        // for (String val : car) {
        // System.out.println(val);
        // }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + "->" + entry.getValue());

        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "  " + map.get(key));
        }
    }
}
