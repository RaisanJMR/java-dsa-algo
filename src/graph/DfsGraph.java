
/**
 * DfsGraph
 */
import java.util.*;

public class DfsGraph {
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
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
        // System.out.print("graph created");
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) { // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.destination]) {
                dfs(graph, e.destination, vis);
            }
        }
    }

    // * hasPath using DFS
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {// O(V+E)
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.destination] && hasPath(graph, e.destination, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        /*
         * 1--------3
         * / | \
         * 0 | 5----6
         * \ | /
         * 2---------4
         * 
         */
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // dfs(graph, 0, new boolean[V]);
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }

}