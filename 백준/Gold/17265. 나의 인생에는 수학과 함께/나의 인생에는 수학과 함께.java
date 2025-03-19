import java.util.*;
import java.io.*;

public class Main
{   
    //if('0' <= board[h][w] && board[h][w] <= '5')
    
    static int n;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int cnt;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        for(int h = 0; h < n; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < n; w++){
                board[h][w] = st.nextToken().charAt(0);
            }
        }
    	
    	dfs(0, 0, board[0][0] - '0');
    	    
	    bw.write(max+" "+min);
	    bw.flush();
	    bw.close();
	}
	
	static void dfs(int sx, int sy, int value){
	    
	    
	    if(sx == n - 1 && sy == n - 1){
	        max = Math.max(max, value);
	        min = Math.min(min, value);
	        return;
	    }
	    
	    for(int dir = 0; dir < 2; dir++){
	        int nx = sx + dx[dir];
	        int ny = sy + dy[dir];
	        
	        if(check(nx, ny)){
    	        for(int d = 0; d < 2; d++){
    	            int tx = nx + dx[d];
    	            int ty = ny + dy[d];
    	            
        	        if(check(tx, ty)){
        	            char c = board[nx][ny];
        	            int num = board[tx][ty] - '0';
        	            
        	            int newValue = value;
        	            
            	        if(c == '+'){
        	                newValue += num;
        	            }
        	            else if(c == '-'){
        	                newValue -= num;
        	            }
        	            else if(c == '*'){
        	                newValue *= num;
        	            }
        	            
        	            
        	            dfs(tx, ty, newValue);
  
        	        }

    	        }	            
	        }

	    }
	}
	
	static boolean check(int x, int y){
	    return x >= 0 && y >= 0 && x < n && y < n;
	}
}
