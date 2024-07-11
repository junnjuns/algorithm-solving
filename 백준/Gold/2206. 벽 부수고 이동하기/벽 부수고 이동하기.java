import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static int[][] board;
    static int[][][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		vis = new int[n][m][2];
		
		for(int i=0; i<n; i++){
		    String s = br.readLine();
		    for(int j=0; j<m; j++){
		        board[i][j] = s.charAt(j) - '0';
		    }
		}
		
		bfs(0,0);
	    
	    if(answer != 0){
	        bw.write(answer+"");
	    }
	    else{
	        bw.write("-1");
	    }
	    
		bw.flush();
		bw.close();
	}
	
	static void bfs(int i, int j){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i, j, 0}); // x,y,벽 부순 여부 깼으면 1 안 깼으면 0
	    vis[i][j][0] = 1;
	    
	    while(dq.size() != 0){
	     int[] now = dq.poll();
	     if(now[0] == n-1 && now[1] == m-1){
	         answer = vis[now[0]][now[1]][now[2]];
	         break;
	     }
	     
	     for(int k=0; k<4; k++){
	         int x = now[0] + dx[k];
	         int y = now[1] + dy[k];
	         
	         if(x>=0 && y>=0 && x<n && y<m){
	             if(board[x][y] == 0 && vis[x][y][now[2]] == 0){
	                 dq.add(new int[] {x, y, now[2]});
	                 vis[x][y][now[2]] = vis[now[0]][now[1]][now[2]] + 1;
	             }
	             else if(board[x][y] == 1 && vis[x][y][1] == 0){
	                 if(now[2] == 0){
	                     dq.add(new int[] {x, y, now[2] + 1});
	                     vis[x][y][1] = vis[now[0]][now[1]][now[2]] + 1;
	                 }
	                 
	             }
	         }
	     }
	    
	}
	
  }
}
