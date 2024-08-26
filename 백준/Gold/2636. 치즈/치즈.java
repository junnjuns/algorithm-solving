import java.util.*;
import java.io.*;

// 처음 보드를 입력받을 때 치즈의 개수를 count 한다.
// 이후 치즈가 모두 없어질 때 까지 반복문을 실행한다.
//     항상 0,0 좌표 부터 시작하여 탐색한다.
//         만약 0을 만나면 방문처리 하고 이어서 탐색한다.
//         만약 1(치즈)를 만나면 방문처리 하고 0으로 수정한다. 그리고 치즈의 개수를 -1 한다.
// 치즈가 모두 없어지면 걸린 시간 time과 마지막 bfs 실행 전 치즈가 저장되어 있던 res 변수를 출력한다.


public class Main {
    
    static int[][] board;  // 치즈 판을 나타내는 2차원 배열
    static int row, col;   // 행(row)과 열(col)의 크기
    static int[] dx = {1, -1, 0, 0};  // 이동 방향을 나타내는 배열 (상하좌우)
    static int[] dy = {0, 0, 1, -1};  
    static int[][] vis;  // 방문 여부를 기록하는 배열
    static int cheese;   // 남아있는 치즈의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 행과 열의 크기 입력
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        // 치즈 판 초기화
        board = new int[row][col];
        
        // 치즈 판 상태 입력 및 치즈 개수 카운트
        for(int h = 0; h < row; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < col; w++){
                board[h][w] = Integer.parseInt(st.nextToken());
                if(board[h][w] == 1){
                    cheese++;
                }
            }
        }
        
        int time = 0;  // 치즈가 모두 녹는데 걸리는 시간
        int res = 0;   // 마지막으로 남은 치즈 개수
        
        // 치즈가 모두 녹을 때까지 반복
        while(cheese != 0){
            res = cheese;  // 남은 치즈 개수 저장
            vis = new int[row][col];  // 방문 배열 초기화
            fill(0, 0);  // 외부 공기와 연결된 부분을 찾고 치즈를 녹임
            time++;  // 시간 증가
        }
        
        // 결과 출력
        bw.write(time + "\n");  
        bw.write(res + "");     
        bw.flush();
        bw.close();
    }
    
    // 외부 공기와 연결된 부분을 찾고 치즈를 녹이는 함수
    static void fill(int sx, int sy) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();  // BFS를 위한 큐
        dq.add(new int[] {sx, sy});  // 시작점 추가
        vis[sx][sy] = 1;  // 시작점 방문 처리
        
        while(dq.size() != 0){
            int[] now = dq.poll();  // 현재 위치를 큐에서 꺼냄
            
            // 상하좌우로 이동
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                // 범위 내에 있고 방문하지 않은 경우
                if(nx >= 0 && ny >= 0 && nx < row && ny < col){
                    if(vis[nx][ny] == 0 && board[nx][ny] == 0){
                        dq.add(new int[] {nx, ny});  // 다음 이동할 위치 큐에 추가
                        vis[nx][ny] = 1;  // 방문 처리
                    }
                    // 치즈를 만나면 녹이고 방문 처리
                    else if(board[nx][ny] == 1){
                        board[nx][ny] = 0;
                        vis[nx][ny] = 1;
                        cheese -= 1;  // 남은 치즈 개수 감소
                    }
                }
            }
        }
    }
}
