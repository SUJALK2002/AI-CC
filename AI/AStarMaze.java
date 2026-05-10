import java.util.*;

class Node {
    int x, y, g, h;

    Node(int x, int y, int g, int h) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
    }

    int f() {
        return g + h;
    }
}

public class AStarMaze {

    static int ROW = 4;
    static int COL = 4;

    // 0 = free path, 1 = obstacle
    static int[][] grid = {
        {0, 0, 0, 1},
        {1, 1, 0, 1},
        {0, 0, 0, 0},
        {0, 1, 1, 0}
    };

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // Heuristic (Manhattan Distance)
    static int heuristic(int x, int y, int gx, int gy) {
        return Math.abs(x - gx) + Math.abs(y - gy);
    }

    public static void aStar(int sx, int sy, int gx, int gy) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::f));
        boolean[][] visited = new boolean[ROW][COL];

        pq.add(new Node(sx, sy, 0, heuristic(sx, sy, gx, gy)));

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            // Goal reached
            if (curr.x == gx && curr.y == gy) {
                System.out.println("Goal Reached!");
                System.out.println("Minimum Cost = " + curr.g);
                return;
            }

            if (visited[curr.x][curr.y]) continue;
            visited[curr.x][curr.y] = true;

            // Explore 4 directions
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < ROW && ny < COL && grid[nx][ny] == 0) {

                    pq.add(new Node(
                            nx,
                            ny,
                            curr.g + 1,
                            heuristic(nx, ny, gx, gy)
                    ));
                }
            }
        }

        System.out.println("No Path Found!");
    }

    public static void main(String[] args) {

        int startX = 0, startY = 0;
        int goalX = 3, goalY = 3;

        aStar(startX, startY, goalX, goalY);
    }
}