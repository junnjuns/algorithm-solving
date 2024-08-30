import java.util.*;
import java.io.*;

// row와 col을 입력 받는다.
// board를 생성 후 입력 받는다.
// 방문 배열 vis 생성
//0,0 에서 BFS 탐색을 시작한다.
    //ArrayDeque 셍성 후 초기 값 add
    //초기값 방문처리
    //큐가 빌때까지 반복
        //큐에서 맨 앞 요소 꺼내기
            //만약 꺼낸 요소의 좌표가 row -1 , col -1 이면 종료
            //이 때의 vis[row-1][col-1] 값을 반환
        //4방 탐색하며 갈 수 있고 아직 방문하지 않았다면 큐에 추가 + 방문처리


public class Main {

    static int row;
    static int col;
    static int[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] vis;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // row와 col을 입력 받는다.
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        vis = new int[row][col];

        // board를 생성 후 입력 받는다.
        for(int height = 0; height < row; height++){
            String str = br.readLine();
            for(int width = 0; width < col; width++){
                board[height][width] = str.charAt(width) - '0';
            }
        }

        //0,0 에서 BFS 탐색을 시작한다.
        move(0, 0);

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    static void move(int startX, int startY){
        //ArrayDeque 셍성 후 초기 값 add
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {startX, startY});
        //초기값 방문처리
        vis[startX][startY] = 1;

        //큐가 빌때까지 반복
        while (dq.size() != 0){
            int[] now = dq.poll();
            
            //만약 꺼낸 요소의 좌표가 row -1 , col -1 이면 종료
            //이 때의 vis[row-1][col-1] 값을 반환
            if(now[0] == row - 1 && now[1] == col - 1){
                answer = vis[now[0]][now[1]];
                return;
            }
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < row && ny < col){
                    //4방 탐색하며 갈 수 있고 아직 방문하지 않았다면 큐에 추가 + 방문처리
                    if(vis[nx][ny] == 0 && board[nx][ny] == 1){
                        dq.add(new int[] {nx, ny});
                        vis[nx][ny] = vis[now[0]][now[1]] + 1;
                    }
                }
            }
        }

    }
}
