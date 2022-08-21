import java.util.HashSet;
import java.util.Iterator;

//HashSet
public class Hash {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(6);
        set.add(3);
        set.add(0);
        // search
        // if (set.contains(1)) {
        // System.out.println("set contains 1");
        // }
        // if (!set.contains(56)) {
        // System.out.println("does not contains 6");
        // }
        // Delete
        // set.remove(1);
        // if (!set.contains(1)) {
        // System.out.println("deleted 1");
        // }

        // Size
        // System.out.println(set.size());

        // Prints in ascending order
        // System.out.println(set);

        // Iterate
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
