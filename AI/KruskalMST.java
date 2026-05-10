import java.util.*; // O(V + ELog e)

public class KruskalMST {

    static int V = 5;

    // Edge class
    static class Edge implements Comparable<Edge> {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    // Parent array for Union-Find
    static int parent[] = new int[V];

    // Find function
    public static int find(int x) {

        if (parent[x] == x)
            return x;

        return find(parent[x]);
    }

    // Union function
    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        parent[parB] = parA;
    }

    // Kruskal Algorithm
    public static void kruskal(ArrayList<Edge> edges) {

        Collections.sort(edges);

        // Initialize parents
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int mstCost = 0;

        System.out.println("Edges in MST:");

        for (int i = 0; i < edges.size(); i++) {

            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            // No cycle
            if (parA != parB) {

                union(e.src, e.dest);

                mstCost += e.wt;

                System.out.println(
                        e.src + " - " + e.dest +
                                " : " + e.wt);
            }
        }

        System.out.println("Total MST Cost = " + mstCost);
    }

    public static void main(String[] args) {

        ArrayList<Edge> edges = new ArrayList<>();

        // Graph edges

        // 0 ↔ 1 (2)
        edges.add(new Edge(0, 1, 2));

        // 0 ↔ 3 (6)
        edges.add(new Edge(0, 3, 6));

        // 1 ↔ 2 (3)
        edges.add(new Edge(1, 2, 3));

        // 1 ↔ 3 (8)
        edges.add(new Edge(1, 3, 8));

        // 1 ↔ 4 (5)
        edges.add(new Edge(1, 4, 5));

        // 2 ↔ 4 (7)
        edges.add(new Edge(2, 4, 7));

        // 3 ↔ 4 (9)
        edges.add(new Edge(3, 4, 9));

        kruskal(edges);
    }
}


//         2
//     0 ------- 1
//     |         | \
//    6|         |5 \3
//     |         |   \
//     3 ------- 4----2
//         9        7