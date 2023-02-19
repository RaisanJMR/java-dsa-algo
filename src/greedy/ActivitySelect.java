
/**
 * ActivitySelect without overlapping
//  * ending time sorted
 */
import java.util.*;

public class ActivitySelect {

    /**
     * @param start
     * @param end
     * @param s
     */
    public static void maxActivitySelect(
            int start[],
            int end[],
            int s) {

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        // @ start > lastend
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("max activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        // @end time basis sorted activity
        int s = start.length;
        maxActivitySelect(start, end, s);
    }

}