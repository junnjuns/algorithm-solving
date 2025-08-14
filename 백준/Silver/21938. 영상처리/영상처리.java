

import java.util.*;
import java.io.*;

public class Main
{
    static int n, m;
    static int[][] board;
    static int[][] vis;
    static int avg;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    board = new int[n][m];
	    vis = new int[n][m];
	    
	    
	    for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) { // m = 픽셀 열 개수
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[row][col] = (r + g + b) / 3;
            }
        }
	    
	    avg = Integer.parseInt(br.readLine());
	    
	    int answer = 0;
	    for(int row = 0; row < n; row++){
	        for(int col = 0; col < m; col++){
	            if(vis[row][col] == 0 && board[row][col] >= avg){
	                bfs(row, col);
	                answer += 1;
	            }
	        }
	    }
	    
	    System.out.print(answer);
	}
	
	static void bfs(int x, int y){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {x, y});
	    vis[x][y] = 1;
	    
	    while(!dq.isEmpty()){
	        int[] now = dq.poll();
	        
	        for(int dir = 0 ; dir < 4; dir++){
	            int nx = now[0] + dx[dir];
	            int ny = now[1] + dy[dir];
	            if(checkRange(nx, ny) && vis[nx][ny] == 0 && board[nx][ny] >= avg){
	                vis[nx][ny] = 1;
	                dq.add(new int[] {nx , ny});
	            }
	            
	        }
	    }
	}
	
	static boolean checkRange(int x, int y){
	    return x >= 0 && x < n && y >= 0 && y < m;
	}
	
}
