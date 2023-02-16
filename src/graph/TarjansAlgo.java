
// @ Tarjan's algo
// @ Bridge concept (undirected graph)
// @ O(V+2E)
import java.util.*;

public class TarjansAlgo {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 2));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));

    }

    /**
     * @param graph
     * @param curr
     * @param vis
     * @param dis_time
     * @param low_dis_time
     * @param time
     * @param parent
     */
    public static void dfs(
            ArrayList<Edge> graph[],
            int curr,
            boolean vis[],
            int dis_time[],
            int low_dis_time[],
            int time,
            int parent) {
        vis[curr] = true;
        dis_time[curr] = low_dis_time[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // @ if destination is parent
            if (e.dest == parent) {
                continue;
                // @ neighbour is unvisited
            } else if (!vis[e.dest]) {
                dfs(graph, e.dest, vis, dis_time, low_dis_time, time, curr);
                low_dis_time[curr] = Math.min(low_dis_time[curr], low_dis_time[e.dest]);
                if (dis_time[curr] < low_dis_time[e.dest]) {
                    System.out.println("bridge is : " + curr + " ---- " + e.dest);
                }
            } else {
                low_dis_time[curr] = Math.min(low_dis_time[curr], dis_time[e.dest]);
            }

        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int V) {
        int dis_time[] = new int[V];
        // @ store lowest dt of all neighbours except parent
        int low_dis_time[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, dis_time, low_dis_time, time, -1);
            }
        }
    }

    public static void main(String[] args) {
        // int V = 6;
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getBridge(graph, V);
    }

}
