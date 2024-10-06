import java.util.*;
import java.io.*;


public class Solution {

    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            bw.write("#"+t+" ");

            br.readLine();

            board = new int[16][16];

            int startX = 0;
            int startY = 0;


            for(int row = 0; row < 16; row++){
                String str = br.readLine();
                for(int col = 0; col < 16; col++){
                    board[row][col] = str.charAt(col) -'0';
                    if(board[row][col] == 2){
                        startX = row;
                        startY = col;
                    }
                }
            }

            vis = new boolean[16][16];
            check = false;
            bfs(startX, startY);

            int answer = check == false ? 0 : 1;

            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = true;

        while (dq.size() != 0){
            int[] now = dq.poll();
            int x = now[0];
            int y = now[1];

            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < 16 && ny < 16){
                    if(vis[nx][ny] == false && board[nx][ny] != 1){
                        if(board[nx][ny] == 3){
                            check = true;
                            return;
                        }

                        dq.add(new int[] {nx, ny});
                        vis[nx][ny] = true;

                    }
                }
            }

        }
    }

}
