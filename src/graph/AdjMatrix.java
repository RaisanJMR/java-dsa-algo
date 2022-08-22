// Adjacency Matrix representation in Java
// https://www.programiz.com/dsa/graph-adjacency-matrix

public class AdjMatrix {
    private boolean adjMatrix[][];
    private int numVertices;

    // Initialize the matrix
    public AdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        
        AdjMatrix g = new AdjMatrix(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());
    }
}











// Adjecency matrix
// import java.util.Scanner;

// public class AdjMatrix {
//     int vertices;
//     int matrix[][];

//     // Constructor
//     AdjMatrix(int vertices) {
//         this.vertices = vertices;
//         matrix = new int[vertices][vertices];
//     }

//     // Adding Edge
//     void addEdge(int source, int destination) {
//         matrix[source][destination] = 1;
//         matrix[destination][source] = 1;
//     }

//     // Print graph
//     void printGraph() {
//         for (int i = 0; i < vertices; i++) {
//             for (int j = 0; j < vertices; j++) {
//                 System.out.print(matrix[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         System.out.println("Enter the number of vertices");
//         int V = s.nextInt();
//         AdjMatrix amg = new AdjMatrix(V);
//         System.out.println("Enter the number of edges");
//         int E = s.nextInt();

//         for (int i = 0; i < E; i++) {
//             System.out.println("Enter the source vertex");
//             int a = s.nextInt();
//             System.out.println("Enter the destination vertex");
//             int b = s.nextInt();

//             amg.addEdge(a, b);
//         }
//         amg.printGraph();
//     }
// }

