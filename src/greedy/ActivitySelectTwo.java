
/**
 * ActivitySelect without overlapping
//  * ending time not sorted
 */
import java.util.*;

// @ TC N(logN)
public class ActivitySelectTwo {

    /**
     * @param start
     * @param end
     * @param s
     */
    public static void maxActivitySelect(
            int start[],
            int end[],
            int s) {

        int activities[][] = new int[s][3];
        for (int i = 0; i < s; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // lambda function -> short form
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        // @ start > lastend
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
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