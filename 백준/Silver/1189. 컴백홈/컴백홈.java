import java.util.*;
import java.io.*;

public class Main
{
    
    static int row, col;
    static int dist;
    static char[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    row = Integer.parseInt(st.nextToken());
	    col = Integer.parseInt(st.nextToken());
	    dist = Integer.parseInt(st.nextToken());
	    
	    board = new char[row][col];
	    
	    for(int h = 0; h < row; h++){
	        String str = br.readLine();
	        for(int w = 0; w < col; w++){
	            board[h][w] = str.charAt(w);
	        }
	    }
	    
	    vis = new int[row][col];
	    vis[row - 1][0] = 1;
	    dfs(row - 1, 0);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void dfs(int sx, int sy){
	    
	    //도착지 도착
	    if(sx == 0 && sy == col - 1){
	        if(vis[sx][sy] == dist){
	            answer += 1;    
	        }
	        return;
	    }
	    
	    for(int idx = 0; idx < 4; idx++){
	        int nx = sx + dx[idx];
	        int ny = sy + dy[idx];
	        
	        if(check(nx, ny) && vis[nx][ny] == 0 && board[nx][ny] == '.'){
	            
	            vis[nx][ny] = vis[sx][sy] + 1;
	            dfs(nx, ny);
	            vis[nx][ny] = 0;
	        }
	    }
	    
	}
	static boolean check(int x, int y){
	    return x >= 0 && y >= 0 && x < row && y< col;
	}
}
