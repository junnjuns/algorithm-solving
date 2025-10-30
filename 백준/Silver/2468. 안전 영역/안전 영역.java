import java.util.*;
import java.io.*;

public class Main
{
    
    static int n;
    static int[][] board;
    static int[][] vis;
    static int max, min;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    board = new int[n][n];
	    
	    max = Integer.MIN_VALUE;
	    min = Integer.MAX_VALUE;
	    
	    for(int row = 0; row < n; row++){
	        st = new StringTokenizer(br.readLine());
	        
	        for(int col = 0; col < n; col++){
	            board[row][col] = Integer.parseInt(st.nextToken());
	            
	            max = Math.max(max, board[row][col]);
	            
	            min = Math.min(min, board[row][col]);
	            
	        }
	        
	    }
	    
	    int answer = 0;
	    for(int idx = min - 1; idx <= max; idx++){ //물 높이
	        
	        vis = new int[n][n];
	        int cnt = 0;
	        
    	    for(int row = 0; row < n; row++){ // 물 높이에 따른 BFS
    	        for(int col = 0; col < n; col++){
    	            if(board[row][col] > idx && vis[row][col] == 0){
    	                bfs(row, col, idx);
    	                cnt += 1;
    	            }
    	                
    	        }
    	    }
    	    
    	    answer = Math.max(answer, cnt);
    	    
	    }
	    
	    bw.write(answer+"");
	    
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int sx, int sy, int water){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {sx, sy});
	    vis[sx][sy] = 1;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        for(int dir = 0; dir < 4; dir++){
	            int nx = now[0] + dx[dir];
	            int ny = now[1] + dy[dir];
	            
	            if(check(nx, ny) && vis[nx][ny] == 0 && board[nx][ny] > water){
	                dq.add(new int[] {nx, ny});
	                vis[nx][ny] = 1;
	            }
	        }
	        
	    }
	}
	
	static boolean check(int x, int y){
	    return x >= 0 && y >= 0 && x < n && y < n;
	}
}
