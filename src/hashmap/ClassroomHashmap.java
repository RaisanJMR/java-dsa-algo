import java.util.*;


// * hash map questions
public class ClassroomHashmap {
    // * 1 find majority occr of element greater than [n/3]
    public static void majorityElement(int nums[]) { // ! O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            // System.out.println(key);
            if (map.get(key) > (n / 3)) {
                System.out.println(key);
            }
        }
    }

    // * 2 Union of two array
    // ! Sort => O(n log n)
    // ! two for loop => O(n^2)
    public static int Union(int arr1[], int arr2[]) {// ! O(n)
        // ? dont allow duplicate elements
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            set.add(arr2[j]);
        }
        return set.size();
    }

    // *3 Intersection of two array

    public static int Intersection(int arr1[], int arr2[]) {
        // ? HashSet dont allow duplicate elements
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            if (set.contains(arr2[j])) {
                count++;
                set.remove(arr2[j]);
            }
        }
        return count;
    }

    // *4 find Itinerary from tickets
    public static String getStart(HashMap<String, String> tick) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tick.keySet()) {
            revMap.put(tick.get(key), key);
        }
        for (String key : tick.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // ? 1
        // int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // int nums[] = { 1, 2 };
        // majorityElement(nums);
        // ? 2
        // int arr1[] = { 7, 3, 9 };
        // int arr2[] = { 6, 3, 9, 2, 9, 4 };
        // System.out.println(Union(arr1, arr2));
        // ? 3
        // int arr1[] = { 7, 3, 9 };
        // int arr2[] = { 6, 3, 9, 2, 9, 4 };
        // System.out.println(Intersection(arr1, arr2));
        // ? 4
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);
    }

}
