import java.util.*;
import java.io.*;

public class Main {
    
    static int col, row;
    static int count;
    static int[][] board;
    static boolean[][] vis;
    static ArrayDeque<int[]> dq;
    static int dir; 
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        
        board = new int[col][row];
        
        for (int h = 0; h < col; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < row; w++) {
                board[h][w] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int idx = 0; idx < count; idx++) { // count번 회전
            rotation(); // 회전 메서드
        }
        
        for (int[] h : board) {
            for (int j : h) {
                bw.write(j + " ");
            }
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
    
    static void rotation() throws Exception {
        vis = new boolean[col][row];
        int cnt = Math.min(col, row) / 2; // board 내부적인 회전 횟수
        
        for (int idx = 0; idx < cnt; idx++) {
            dq = new ArrayDeque<>();
            dq.add(new int[] {idx, idx, board[idx][idx]}); // 회전 로직 시작 위치, 자신의 값
            
            dir = 0;
            while (!dq.isEmpty()) {
                int[] now = dq.poll();
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if (nx >= 0 && ny >= 0 && nx < col && ny < row && !vis[nx][ny]) {
                    dq.add(new int[] {nx, ny, board[nx][ny]});
                    vis[nx][ny] = true;
                    board[nx][ny] = now[2]; // board 값 회전(옮기기)
                } else { // 방향 전환이 필요할 때
                    dir = (dir + 1) % 4;
                    nx = now[0] + dx[dir];
                    ny = now[1] + dy[dir];

                    // 방향 전환 후에도 범위를 확인하고, 큐에 추가
                    if (nx >= 0 && ny >= 0 && nx < col && ny < row && !vis[nx][ny]) {
                        dq.add(new int[] {nx, ny, board[nx][ny]});
                        vis[nx][ny] = true;
                        board[nx][ny] = now[2];
                    }
                }
            } // while문 끝
        } // board 내부 회전 끝
    }
}
