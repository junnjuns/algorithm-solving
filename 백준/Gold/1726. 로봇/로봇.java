import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1}; // 동, 서, 남, 북
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][] vis; // 방문 여부 확인
    static int[] start = new int[3]; // 시작 좌표와 방향
    static int[] target = new int[3]; // 목표 좌표와 방향
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m][4];

        for (int col = 0; col < n; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 0; row < m; row++) {
                board[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < 3; idx++) {
            start[idx] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < 3; idx++) {
            target[idx] = Integer.parseInt(st.nextToken()) - 1;
        }

        bfs(start[0], start[1], start[2]);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int i, int j, int direction) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{i, j, direction, 0});
        vis[i][j][direction] = true;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();

            if (now[0] == target[0] && now[1] == target[1] && now[2] == target[2]) {
                answer = now[3];
                return;
            }

            // 현재 방향으로 최대 3칸 이동
            for (int go = 1; go <= 3; go++) {
                int x = now[0] + dx[now[2]] * go;
                int y = now[1] + dy[now[2]] * go;

                if (x >= 0 && y >= 0 && x < n && y < m && board[x][y] == 0) {
                    if (!vis[x][y][now[2]]) {
                        dq.add(new int[]{x, y, now[2], now[3] + 1});
                        vis[x][y][now[2]] = true;
                    }
                } else {
                    break; // 장애물이나 범위를 벗어나면 이동 중단
                }
            }

            // 방향 전환
            for (int dir = 0; dir < 4; dir++) {
                if (dir != now[2] && !vis[now[0]][now[1]][dir]) {
                    int turnCost = 1;
                    if ((now[2] == 0 && dir == 1) || (now[2] == 1 && dir == 0) ||
                        (now[2] == 2 && dir == 3) || (now[2] == 3 && dir == 2)) {
                        turnCost = 2; // 180도 회전
                    }
                    dq.add(new int[]{now[0], now[1], dir, now[3] + turnCost});
                    vis[now[0]][now[1]][dir] = true;
                }
            }
        }
    }
}
