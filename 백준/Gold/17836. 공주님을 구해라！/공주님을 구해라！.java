import java.util.*;
import java.io.*;

public class Main
{
    static int n,m,t;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
	static int ans;
	static boolean check = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    t = Integer.parseInt(st.nextToken());
	    
	    board = new int[n][m];
	    vis = new int[n][m];
	    
	    for(int i=0; i<n; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<m; j++){
	            board[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    BFS(0,0);
	    
	    if(ans > t || !check){
	        bw.write("Fail");
	    }
	    else{
	        bw.write(ans+"");
	    }
        bw.flush();
        bw.close();
        
	}
	static void BFS(int i, int j){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i,j});
	    vis[i][j] = 1;
	    
	    int minTime = 0;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        for(int k=0; k<4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x>=0 && y>=0 && x<n && y<m){
	                if(vis[x][y] == 0 && board[x][y] != 1){
	                    dq.add(new int[] {x,y});
	                    vis[x][y] = vis[now[0]][now[1]] + 1;
	                    
	                    if(board[x][y] == 2){
	                        check = true;
	                        minTime = vis[x][y] -1 + (n-1-x + m-1-y);
	                    }
	                }
	            }
	        }
	    }
	    if(vis[n-1][m-1] != 0){
	        ans = Math.min(minTime, vis[n-1][m-1]-1);
	    }
	    else{
	        ans = minTime;
	    }
	}
}

