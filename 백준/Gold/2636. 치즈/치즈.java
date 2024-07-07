import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int cheese;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    board = new int[n][m];
	    
	    for(int i=0; i<n; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<m; j++){
	            board[i][j] = Integer.parseInt(st.nextToken());
	            if(board[i][j] == 1){
	                cheese++;
	            }
	        }
	    }
	    
	    int time = 0;
	    int res = 0;
	    while(cheese != 0){
	        res = cheese;
	        time++;
	        vis = new int[n][m];
	        bfs(0,0);
	    }
	    bw.write(time+"\n");
	    bw.write(res+"");
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
	            
	            if(x>=0 && y>=0 && x<n && y<m){
	                if(board[x][y] == 0 && vis[x][y] == 0){
	                    dq.add(new int[] {x,y});
	                    vis[x][y] = 1;
	                }
	                else if (board[x][y] == 1 && vis[x][y] == 0){
	                    board[x][y] = 0;
	                    vis[x][y] = 1;
	                    cheese -= 1;
	                }
	            }
	        }
	        
	    }
	}
}
