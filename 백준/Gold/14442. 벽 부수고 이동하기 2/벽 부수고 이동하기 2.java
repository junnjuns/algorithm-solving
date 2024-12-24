import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;
        int brokenCnt;

        public Point(int x, int y, int brokenCnt) {
            this.x = x;
            this.y = y;
            this.brokenCnt = brokenCnt;
        }
    }

    static int row, col;
    static int k;
    static int[][] board;
    static int[][][] vis;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        vis = new int[row][col][k + 1];

        for (int h = 0; h < row; h++) {
            String str = br.readLine();
            for (int w = 0; w < col; w++) {
                board[h][w] = str.charAt(w) - '0';
            }
        }

        answer = -1;
        bfs(0, 0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void bfs(int sx, int sy) {
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(sx, sy, 0));
        vis[sx][sy][0] = 1;

        while (!dq.isEmpty()) {
            Point point = dq.poll();

            // 도착 지점 도달
            if (point.x == row - 1 && point.y == col - 1) {
                answer = vis[point.x][point.y][point.brokenCnt];
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = point.x + dx[dir];
                int ny = point.y + dy[dir];

                if (checkRange(nx, ny)) {
                    
                    if (board[nx][ny] == 0 && vis[nx][ny][point.brokenCnt] == 0) {
                        dq.add(new Point(nx, ny, point.brokenCnt));
                        vis[nx][ny][point.brokenCnt] = vis[point.x][point.y][point.brokenCnt] + 1;
                    }
                    
                    else if (board[nx][ny] == 1 && point.brokenCnt < k && vis[nx][ny][point.brokenCnt + 1] == 0) {
                        dq.add(new Point(nx, ny, point.brokenCnt + 1));
                        vis[nx][ny][point.brokenCnt + 1] = vis[point.x][point.y][point.brokenCnt] + 1;
                    }
                }
            }
        }
    }

    static boolean checkRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
