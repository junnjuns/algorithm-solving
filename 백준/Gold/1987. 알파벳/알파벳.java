import java.util.*;
import java.io.*;



public class Main {
    
    static char[][] board;  
    static int row, col;   // 행(row)과 열(col)의 크기
    static int[] dx = {1, -1, 0, 0};  // 이동 방향을 나타내는 배열 (상하좌우)
    static int[] dy = {0, 0, 1, -1};  
    static int[][] vis;  // 방문 여부를 기록하는 배열
    static Map<Character, Integer> map = new HashMap<>();
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 행과 열의 크기 입력
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        board = new char[row][col];
        vis = new int[row][col];
        
        //board판 입력
        for(int h = 0; h < row; h++){
            String str = br.readLine();
            for(int w = 0; w < col; w++){
                board[h][w] = str.charAt(w);
                if(!map.containsKey(board[h][w])){
                    map.put(board[h][w], -1);
                }
            }
        }
        
        move(0, 0, 1);
        bw.write(answer+"");
        
        bw.flush();
        bw.close();
    }
    
    static void move(int sx, int sy, int max){
        answer = Math.max(answer, max);
        vis[sx][sy] = 1;
        map.put(board[sx][sy], 1);
        
        for(int dir = 0; dir < 4; dir++){
            int nx = sx + dx[dir];
            int ny = sy + dy[dir];
            
            if(nx >= 0 && ny >= 0 && nx < row && ny < col){
                if(map.get(board[nx][ny]) == -1 && vis[nx][ny] == 0){
                    vis[nx][ny] = 1;
                    move(nx, ny, max + 1);
                }
            }
        }
        vis[sx][sy] = 0;          // 방문 표시 해제
        map.put(board[sx][sy], -1);
    }
}
