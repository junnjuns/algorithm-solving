import java.util.*;
import java.io.*;

public class Main {

    static int row, col;
    static char[][] board;
    static boolean[][] vis;
    static int cntK, cntV;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        
        board = new char[row][col];
        vis = new boolean[row][col];
        
        for(int h = 0; h < row; h++){
            String str = br.readLine();
            for(int w = 0; w < col; w++){
                board[h][w] = str.charAt(w);
            }
        }
        
        for(int h = 0; h < row; h++){
            for(int w = 0; w < col; w++){
                if(board[h][w] != '#' && vis[h][w] == false){
                    bfs(h, w);
                }
            }
        }
        
        bw.write(cntK + " " + cntV);
        bw.flush();
        bw.close();
    }
    
    static void bfs(int h, int w){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {h, w});
        vis[h][w] = true;
        
        int nowK = 0;
        int nowV = 0;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            if(board[now[0]][now[1]] == 'k'){
                nowK += 1;
            }
            else if(board[now[0]][now[1]] == 'v'){
                nowV += 1;
            }
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(checkRange(nx, ny) && board[nx][ny] != '#' && vis[nx][ny] == false){
                    dq.add(new int[] {nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }
        
        if(nowK == 0 && nowV == 0){
            return;
        }
        else{
            if(nowK > nowV){
                cntK += nowK;
            }
            else{
                cntV += nowV;
            }
        }
    }
    
    static boolean checkRange(int x, int y){
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
