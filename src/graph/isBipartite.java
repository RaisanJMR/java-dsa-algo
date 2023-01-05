
// @ Bipartite graph using bfs
import java.util.*;

public class isBipartite {

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

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

        // System.out.print("graph created");
    }

    public static boolean IsBipartite(ArrayList<Edge> graph[]) { 

        // * external logic

        int color[] = new int[graph.length];

        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < color.length; i++) {
            if (color[i] == -1) {

                // *BFS* //

                q.add(i);
                color[i] = 0;

                // * Yellow *//

                while (!q.isEmpty()) {

                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        // * e.Destination * //

                        if (color[e.destination] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.destination] = nextColor;
                            q.add(e.destination);
                          } else if (color[e.destination] == color[curr]) {
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(IsBipartite(graph));
    }
}
