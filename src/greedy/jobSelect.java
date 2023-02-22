import java.util.ArrayList;
import java.util.Collections;

// @select jobs

public class jobSelect {

    static class Job {

        int deadline;

        int profit;

        int id;

        public Job(int i, int d, int p) {

            this.id = i;

            this.deadline = d;

            this.profit = p;

        }

    }

    public static void main(String[] args) {
 
        int jobsInfo[][] = { { 2, 100 }, { 1, 19 }, { 2, 27 }, { 1, 25 }, { 3, 15 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {

            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));

        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit); // descending

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {

            Job curr = jobs.get(i);

            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
            
        }

        // print seq

        System.out.println("max jobs = " + seq.size());

        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }

        System.out.println();
    }
}
