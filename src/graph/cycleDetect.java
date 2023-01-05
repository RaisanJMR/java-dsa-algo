
/**
 * cycleDetect
 */
// @ detect cycle in an undirected graph
import java.util.*;

public class cycleDetect {
    
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
        // graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));

        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 7, 1));

        graph[6].add(new Edge(6, 5, 1));
        graph[6].add(new Edge(6, 7, 1));

        graph[7].add(new Edge(7, 5, 1));
        graph[7].add(new Edge(7, 6, 1));

        System.out.println("graph created");
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }

            }
        }
        return false;
    }

    // * (V+E)
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // *case 3
            if (!vis[e.destination]) {
                if (detectCycleUtil(graph, vis, e.destination, curr)) {
                    return true;
                }
                // *case 1
            } else if (vis[e.destination] && e.destination != par) {
                return true;
            }
            // *case 2 -> continue
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 8;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}