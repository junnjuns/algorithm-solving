import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    static boolean[][] vis;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    board = new int[n][n];
	    vis = new boolean[n][n];
	    
	    
	    for(int row = 0; row < n; row++){
	        st = new StringTokenizer(br.readLine());
	        for(int col = 0; col < n; col++){
	            board[row][col] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    func(1, 1, 0, 0);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void func(int x, int y, int res, int cnt){
	    if(cnt == 3){
	        answer = Math.min(answer, res);
	        return;
	    }
	    
	    if(res >= answer){
	        return;
	    }
	    
	    for(int row = x; row < n - 1; row++){
	        for(int col = 1; col < n - 1; col++){
	            
	            boolean check = false;
                for(int dir = 0; dir < 4; dir++){
                    int nx = row + dx[dir];
	                int ny = col + dy[dir];
	                if(vis[nx][ny]){
	                    check = true;
	                }
                }	            
	            
	            if(vis[row][col] || check) continue;
	            
                int value = 0;
                	            
	            vis[row][col] = true;
	            for(int dir = 0; dir < 4; dir++){
	                int nx = row + dx[dir];
	                int ny = col + dy[dir];
	                
	                vis[nx][ny] = true;
	                value += board[nx][ny];
	            }
	            value += board[row][col];
	            
	            func(row, col, res + value, cnt + 1);
	            
	            vis[row][col] = false;
	            for(int dir = 0; dir < 4; dir++){
	                int nx = row + dx[dir];
	                int ny = col + dy[dir];
	                
	                vis[nx][ny] = false;
	                value -= board[nx][ny];
	            }	            
                value -= board[row][col];	            
	        }
	    }
	    
	}
}
