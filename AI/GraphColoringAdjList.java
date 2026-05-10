import java.util.*;

public class GraphColoringAdjList {

    static int V = 4;

    // Check if color is safe
    public static boolean isSafe(ArrayList<Integer>[] graph,
                                 int colors[],
                                 int vertex,
                                 int color) {

        for (int i = 0; i < graph[vertex].size(); i++) {

            int neighbor = graph[vertex].get(i);

            if (colors[neighbor] == color) {
                return false;
            }
        }

        return true;
    }

    // Backtracking function
    public static boolean solve(ArrayList<Integer>[] graph,
                                int m,
                                int colors[],
                                int vertex) {

        // All vertices colored
        if (vertex == V) {
            return true;
        }

        // Try all colors
        for (int c = 1; c <= m; c++) {

            if (isSafe(graph, colors, vertex, c)) {

                colors[vertex] = c;

                // Recursive call
                if (solve(graph, m, colors, vertex + 1)) {
                    return true;
                }

                // Backtracking
                colors[vertex] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
              Graph

                  1
                / | \
               0--2--3
        */

        // Undirected graph

        graph[0].add(1);
        graph[1].add(0);

        graph[0].add(2);
        graph[2].add(0);

        graph[0].add(3);
        graph[3].add(0);

        graph[1].add(2);
        graph[2].add(1);

        graph[2].add(3);
        graph[3].add(2);

        int m = 3; // Number of colors

        int colors[] = new int[V];

        if (solve(graph, m, colors, 0)) {

            System.out.println("Solution Exists:");

            for (int i = 0; i < V; i++) {

                System.out.println(
                        "Vertex " + i +
                        " ---> Color " + colors[i]);
            }

        } else {

            System.out.println("No Solution");
        }
    }
}