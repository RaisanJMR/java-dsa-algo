import java.util.*;

public class ListInterface {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(0, 1);
        l1.add(1, 6);
        l1.add(2, 8);
        l1.add(3, 32);
        for (Integer str : l1)

            // Printing all the elements
            // which was inside object
            System.out.print(str + " ");

    }
}
