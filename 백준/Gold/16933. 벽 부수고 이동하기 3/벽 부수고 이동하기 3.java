import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;
        int brokenCnt;
        boolean sun;
        
        public Point(int x, int y, int brokenCnt, boolean sun) {
            this.x = x;
            this.y = y;
            this.brokenCnt = brokenCnt;
            this.sun = sun;
        }
    }

    static int row, col;
    static int k;
    static int[][] board;
    static int[][][][] vis;
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
        vis = new int[row][col][k + 1][2];

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
        dq.add(new Point(sx, sy, 0, true));
        vis[sx][sy][0][0] = 1;

        while (!dq.isEmpty()) {
            Point point = dq.poll();

            // 도착 지점 도달
            if (point.x == row - 1 && point.y == col - 1) {
                answer = vis[point.x][point.y][point.brokenCnt][point.sun ? 0 : 1];
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = point.x + dx[dir];
                int ny = point.y + dy[dir];

                if (checkRange(nx, ny)) { //범위 내 일때
                    
                    if (board[nx][ny] == 0 && vis[nx][ny][point.brokenCnt][point.sun ? 1 : 0] == 0) { //다음 이동할 곳이 벽이 아닐 때
                        dq.add(new Point(nx, ny, point.brokenCnt, !point.sun));
                        vis[nx][ny][point.brokenCnt][point.sun ? 1 : 0] = vis[point.x][point.y][point.brokenCnt][point.sun ? 0 : 1] + 1;
                        //System.out.println(nx+" ,"+ny+" :  "+point.brokenCnt+" || 벽 X: "+vis[nx][ny][point.brokenCnt][point.sun ? 0 : 1] +" "+point.sun);
                    }
                    
                    else if (board[nx][ny] == 1 && point.brokenCnt < k && vis[nx][ny][point.brokenCnt + 1][point.sun ? 0 : 1] == 0) { //다음 이동할 곳이 벽일 때
                        if(point.sun){ //현재 낮일 때 벽 부수고 이동
                            dq.add(new Point(nx, ny, point.brokenCnt + 1, !point.sun));
                            vis[nx][ny][point.brokenCnt + 1][1] = vis[point.x][point.y][point.brokenCnt][0] + 1;
                            //System.out.println(nx+" ,"+ny+" :  "+point.brokenCnt+" || 현재 낮, 다음 벽: "+vis[nx][ny][point.brokenCnt + 1][point.sun ? 0 : 1]);
                        }
                        else{ //현재 밤일 때 제자리에서 대기
                            if(vis[point.x][point.y][point.brokenCnt][0] == 0){
                                dq.add(new Point(point.x, point.y, point.brokenCnt, !point.sun));
                                vis[point.x][point.y][point.brokenCnt][0] = vis[point.x][point.y][point.brokenCnt][1] + 1;
                            }
                        }

                    }
                }
            }
        }
    }

    static boolean checkRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
