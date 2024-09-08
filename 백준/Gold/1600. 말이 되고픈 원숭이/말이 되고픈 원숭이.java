import java.util.*;
import java.io.*;


public class Main {

    static int cnt;
    static int height;
    static int width;
    static int[][] board;
    static boolean[][][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] jumX ={1,1,2,2,-1,-1,-2,-2};
    static int[] jumY = {2,-2,1,-1,2,-2,1,-1};
    static boolean possible;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //말 점프 가능한 횟수
        cnt = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        board = new int[height][width];
        vis = new boolean[height][width][cnt + 1];

        //board 초기화
        for(int row = 0; row < height; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < width; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        move(0, 0);

        //만약 끝까지 도착했으면 걸린 시간, 도착 못했다면 -1로 초기화
        answer = possible == false ? -1 : answer;

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    static void move(int startX, int startY){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {startX, startY, 0, 0}); //좌표, 현재 이동 횟수, 능력 사용 횟수
        vis[startX][startY][0] = true; //현재 위치에 능력을 0번 사용해서 도착함


        while (dq.size() != 0){
            int[] now = dq.poll();
            int x = now[0];
            int y = now[1];
            int nowTime = now[2];
            int nowUsed = now[3];

            if(x == height - 1 && y == width - 1){
                possible = true;
                answer = nowTime;
                return;
            }

            //아직 능력을 사용할 수 있다면
            if(nowUsed < cnt){

                for(int dir = 0; dir < 8; dir++){
                    int nx = x + jumX[dir];
                    int ny = y + jumY[dir];

                    if(check(nx, ny)){
                        if(vis[nx][ny][nowUsed + 1] == false  && board[nx][ny] == 0){
                            dq.add(new int[] {nx, ny, nowTime + 1, nowUsed + 1});
                            vis[nx][ny][nowUsed + 1] = true;
                        }
                    }
                }
            }

                for(int dir = 0; dir < 4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(check(nx, ny)){
                        if(vis[nx][ny][nowUsed] == false && board[nx][ny] == 0 ){
                            dq.add(new int[] {nx, ny, nowTime + 1, nowUsed});
                            vis[nx][ny][nowUsed] = true;
                        }
                    }
                }


        }

    }

    static boolean check(int x, int y){
        return (x >= 0 && y >= 0 && x < height && y < width);
    }
}
