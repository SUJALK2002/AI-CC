import java.util.*;

public class DijkstraGraph {

    // Edge class
    static class Edge {
        int dest;
        int wt;

        Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }

    // Pair class for Priority Queue
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }

    // Dijkstra Function
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {

        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];

        // Initialize distances
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (!vis[curr.node]) {

                vis[curr.node] = true;

                // Explore neighbors
                for (int i = 0; i < graph[curr.node].size(); i++) {

                    Edge e = graph[curr.node].get(i);

                    int u = curr.node;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation
                    if (dist[u] + wt < dist[v]) {

                        dist[v] = dist[u] + wt;

                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + src);

        for (int i = 0; i < dist.length; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    // Main Method
    public static void main(String[] args) {

        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
              GRAPH USED

              0 --2--> 1
              0 --4--> 2
              1 --1--> 2
              1 --7--> 3
              2 --5--> 4
              4 --2--> 3
              3 --1--> 5
              4 --5--> 5
        */

        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(2, 4));

        graph[1].add(new Edge(2, 1));
        graph[1].add(new Edge(3, 7));

        graph[2].add(new Edge(4, 5));

        graph[4].add(new Edge(3, 2));
        graph[4].add(new Edge(5, 5));

        graph[3].add(new Edge(5, 1));

        // Source node = 0  , ans = 10
        dijkstra(graph, 0);
    }
}