
// * BFS in graph
import java.util.*;

public class BfsGraph {
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

    public static void bfs(ArrayList<Edge> graph[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); // source 0

        // System.out.println(q.isEmpty());
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.println(curr + "");
                vis[curr] = true;
                // System.out.println("size"+graph[curr].size());
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 1--------3
        // / | \
        // 0 | 5----6
        // \ | /
        // 2---------4
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
