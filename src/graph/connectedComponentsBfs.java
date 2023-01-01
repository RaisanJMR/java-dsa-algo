// @BFS for connected components
import java.util.*;

public class connectedComponentsBfs {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));


        System.out.println("graph created");
    }

    public static void bfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();

        q.add(curr); // source 0

        while (!q.isEmpty()) {
            curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    // TODO: think of pass the current
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, i, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
