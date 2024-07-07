import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    board = new int[n][n];
	    
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = s.charAt(j) - '0';
            }
        }
        
        int cnt = 0;
        while(true){
            vis = new int[n][n];
            bfs(0,0);
            if(vis[n-1][n-1] == 1){
                break;
            }
            cnt++;
        }
        
        bw.write(cnt+"");
        bw.flush();
        bw.close();
	}
	
	static void bfs(int i, int j){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i,j});
	    vis[i][j] = 1;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        for(int k=0; k<4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x>=0 && y>=0 && x<n && y<n){
	                if(board[x][y] == 1 && vis[x][y] == 0){
	                    dq.add(new int[] {x,y});
	                    vis[x][y] = 1;
	                }
	                else if(board[x][y] == 0 && vis[x][y] == 0){
	                    board[x][y] = 1;
	                    vis[x][y] = 1;
	                }
	            }
	        }
	    }
	}
}
