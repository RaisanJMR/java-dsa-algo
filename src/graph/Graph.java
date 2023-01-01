// Java program to print connected components in
// an undirected graph
import java.util.ArrayList;
class Graph {
	
	int V;
	ArrayList<ArrayList<Integer> > adjListArray;

	
	Graph(int V)
	{
		this.V = V;
		
		adjListArray = new ArrayList<>();

		// Create a new list for each vertex
		

		for (int i = 0; i < V; i++) {
			adjListArray.add(i, new ArrayList<>());
		}
	}

	
	void addEdge(int src, int dest)
	{
		
		adjListArray.get(src).add(dest);

		
		adjListArray.get(dest).add(src);
	}

	void DFSUtil(int v, boolean[] visited)
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");
		// Recur for all the vertices
		// adjacent to this vertex
		for (int x : adjListArray.get(v)) {
			if (!visited[x])
				DFSUtil(x, visited);
		}
	}
	void connectedComponents()
	{
	
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				DFSUtil(v, visited);
				System.out.println();
			}
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		// Create a graph given in the above diagram
		Graph g = new Graph(5);

		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(3, 4);
		System.out.println(
			"Following are connected components");
		g.connectedComponents();
	}
}

