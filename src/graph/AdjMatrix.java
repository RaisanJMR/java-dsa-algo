
// Adjecency matrix
import java.util.Scanner;

public class AdjMatrix {
    int vertices;
    int matrix[][];

    // Constructor
    AdjMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    // Adding Edge
    void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    // Print graph
    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int V = s.nextInt();
        AdjMatrix amg = new AdjMatrix(V);
        System.out.println("Enter the number of edges");
        int E = s.nextInt();

        for (int i = 0; i < E; i++) {
            System.out.println("Enter the source vertex");
            int a = s.nextInt();
            System.out.println("Enter the destination vertex");
            int b = s.nextInt();

            amg.addEdge(a, b);
        }
        amg.printGraph();
    }
}
