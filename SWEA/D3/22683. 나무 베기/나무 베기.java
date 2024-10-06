import java.util.*;
import java.io.*;


public class Solution {

    static char[][] board; //필드
    static int limit; //벨 수 있는 최대 나무의 수
    static int size; //필드의 크기
    static int[] dir = {0,1,2,3};
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][][][] vis;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine());

            size = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            board = new char[size][size];

            int startX = 0;
            int startY = 0;

            for(int h = 0; h < size; h++){
                String str = br.readLine();
                for(int w = 0; w < size; w++){
                    board[h][w] = str.charAt(w);
                    if(board[h][w] == 'X'){
                        startX = h;
                        startY = w;
                    }
                }
            }

            vis = new int[size][size][4][limit + 1];
            answer = -1;

            bfs(startX, startY, 0);

            bw.write(answer+"\n");
        }


        bw.flush();
        bw.close();
    }

    static void bfs(int sx, int sy, int direction){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy, direction, 0, 0});
        vis[sx][sy][direction][0] = 1;

        while (dq.size() != 0){
            int[] now = dq.poll();
            int x = now[0];
            int y = now[1];
            int nowDir = now[2];
            int cnt = now[3];
            int treaCnt = now[4];

            if(board[x][y] == 'Y'){
                answer = cnt;
                return;
            }

            int nx = x + dx[nowDir];
            int ny = y + dy[nowDir];

            if(possible(nx, ny)){
                int newTree = treaCnt;
                if(board[nx][ny] == 'G' || board[nx][ny] == 'Y'){

                }
                else{
                    if(treaCnt < limit){
                        newTree++;
                    }
                    else{
                        continue;
                    }
                }
                if(vis[nx][ny][nowDir][newTree] == 0){
                    dq.add(new int[] {nx, ny, nowDir, cnt + 1, newTree});
                    vis[nx][ny][nowDir][newTree] = 1;
                }
            }

            for(int d = 1; d <= 3; d += 2){
                int newDir = (nowDir + d) % 4;

                if(vis[x][y][newDir][treaCnt] == 0){
                    vis[x][y][newDir][treaCnt] = 1;
                    dq.add(new int[] {x, y, newDir, cnt + 1, treaCnt});
                }
            }

        }

    }

    static boolean possible(int x, int y){
        return x >= 0 && y >= 0 && x < size && y < size;
    }
}
