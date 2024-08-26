import java.util.*;
import java.io.*;



public class Main {
    
    static int[][] board;  
    static int row, col;   // 행(row)과 열(col)의 크기
    static int[] dx = {1, -1, 0, 0};  // 이동 방향을 나타내는 배열 (상하좌우)
    static int[] dy = {0, 0, 1, -1};  
    static boolean[] vis;  // 방문 여부를 기록하는 배열
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 행과 열의 크기 입력
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        board = new int[row][col];
        vis = new boolean[26];
        
        //board판 입력
        for(int h = 0; h < row; h++){
            String str = br.readLine();
            for(int w = 0; w < col; w++){
                board[h][w] = str.charAt(w) - 'A';
            }
        }
        
        vis = new boolean[26];
        move(0, 0, 1);
        bw.write(answer+"");
        
        bw.flush();
        bw.close();
    }
    
    static void move(int sx, int sy, int max){
        answer = Math.max(answer, max);
        vis[board[sx][sy]] = true;
        
        for(int dir = 0; dir < 4; dir++){
            int nx = sx + dx[dir];
            int ny = sy + dy[dir];
            
            if(nx >= 0 && ny >= 0 && nx < row && ny < col){
                if(vis[board[nx][ny]] == false){
                    vis[board[sx][sy]]= true;
                    move(nx, ny, max + 1);
                }
            }
        }
        vis[board[sx][sy]] = false; 
    }
}
