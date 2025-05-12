import java.util.*;

class Solution {

    private final int[] dr = {-1, 0, 1, 0};
    private final int[] dc = {0, -1, 0, 1};

    static class Pair {
        int x, y, depth;
        Pair(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        
        Pair start = null, lever = null, exit = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') start = new Pair(i, j, 0);
                else if (c == 'L') lever = new Pair(i, j, 0);
                else if (c == 'E') exit = new Pair(i, j, 0);
            }
        }

        int toLever = bfs(maps, start, lever);
        if (toLever == -1) return -1;

        int toExit = bfs(maps, lever, exit);
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private int bfs(String[] maps, Pair start, Pair target) {
        int N = maps.length;
        int M = maps[0].length();
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if (now.x == target.x && now.y == target.y) return now.depth;

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dr[dir];
                int ny = now.y + dc[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                queue.offer(new Pair(nx, ny, now.depth + 1));
            }
        }

        return -1;
    }
}
