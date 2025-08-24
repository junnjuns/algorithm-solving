import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static char[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        vis = new int[n][m];
        
        
        for(int row = 0; row < n; row++){
            String str = br.readLine();
            for(int col = 0; col < m; col++){
                board[row][col] = str.charAt(col);
            }
        }
        
        int answer = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(board[row][col] == '#' && vis[row][col] == 0){
                    bfs(row, col);
                    answer += 1;
                }
            }
        }
        
        bw.write(answer+"");
        
	    bw.flush();
	    bw.close();
	}
    
    static void bfs(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = 1;
        
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(check(nx, ny) && board[nx][ny] == '#' && vis[nx][ny] == 0){
                    dq.add(new int[] {nx, ny});
                    vis[nx][ny] = 1;
                }
            }
            
        }
    }
    
    static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
