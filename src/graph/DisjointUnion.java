// @ Disjoint and union
public class DisjointUnion {

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    // @[ 0, 0, 0, 0, 0, 0, 0, 0 ] => rank array
    public static void init() {
        // @ [ 0, 1, 2, 3, 4, 5, 6, 7 ] => parent array
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    // @ recursive call to get final leader
    // TC 4K
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    // TC 4K
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parB] = parB;
        } else {
            par[parB] = parA;
        }
    }

    // @path compression optimization

    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
