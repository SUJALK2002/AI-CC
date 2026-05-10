import java.util.*;  // O(E LogE)

public class PrimsAdjList {

    // Edge class
    static class Edge {
        int dest;
        int wt;

        Edge(int d, int w) {
            dest = d;
            wt = w;
        }
    }

    // Pair class for Priority Queue
    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        Pair(int n, int c) {
            node = n;
            cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    // Prim's Algorithm
    public static void prims(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));

        int mstCost = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (!vis[curr.node]) {

                vis[curr.node] = true;

                mstCost += curr.cost;

                System.out.println("Visit Node: " + curr.node +
                        "  Cost: " + curr.cost);

                // Explore neighbors
                for (int i = 0; i < graph[curr.node].size(); i++) {

                    Edge e = graph[curr.node].get(i);

                    if (!vis[e.dest]) {

                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println("Total MST Cost = " + mstCost);
    }

    // Main Method
    public static void main(String[] args) {

        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected Graph

        graph[0].add(new Edge(1, 2));
        graph[1].add(new Edge(0, 2));

        graph[0].add(new Edge(3, 6));
        graph[3].add(new Edge(0, 6));

        graph[1].add(new Edge(2, 3));
        graph[2].add(new Edge(1, 3));

        graph[1].add(new Edge(3, 8));
        graph[3].add(new Edge(1, 8));

        graph[1].add(new Edge(4, 5));
        graph[4].add(new Edge(1, 5));

        graph[2].add(new Edge(4, 7));
        graph[4].add(new Edge(2, 7));

        graph[3].add(new Edge(4, 9));
        graph[4].add(new Edge(3, 9));

        prims(graph);
    }
}


/*

        2
    0 ------- 1
    |         | \
   6|         |5 \3
    |         |   \
    3 ------- 4----2
        9        7

*/