import java.util.*;

public class DFSgraph {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // BFS FUNCTION (INSIDE CLASS)
    // public static void BFS(ArrayList<Edge>[] graph) {
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean[] vis = new boolean[graph.length];

    //     q.add(0);

    //     while (!q.isEmpty()) {
    //         int curr = q.remove();

    //         if (!vis[curr]) {
    //             System.out.print(curr + " ");
    //             vis[curr] = true;

    //             for (int i = 0; i < graph[curr].size(); i++) {
    //                 Edge e = graph[curr].get(i);
    //                 q.add(e.dest);
    //             }
    //         }
    //     }
    // }

    // DFS

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);
            }
        }
    }

    // MAIN FUNCTION (INSIDE CLASS)
    public static void main(String[] args) {
        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 0, 1));

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

        // BFS(graph);

        System.out.print("DFS: ");
        boolean vis[] = new boolean[graph.length];
        DFS(graph, 0, vis);
    }
}