import java.util.*;
import java.io.*;


public class Main
{   
    
    static int[][] board;
    static int[][] vis;
    static int mX, mY, kX, kY;
    static int[] dx = {0,1,0,-1}; //동남서북
    static int[] dy = {1,0,-1,0};
    
    static int[] cx = {-1,1,1,-1};
    static int[] cy = {1,1,-1,-1};
    
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine()); //상 위치
	    mX = Integer.parseInt(st.nextToken());
	    mY = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine()); //왕 위치
	    kX = Integer.parseInt(st.nextToken());
	    kY = Integer.parseInt(st.nextToken());
	    
	    board = new int[10][9];
	    vis = new int[10][9];
	    
	    for(int idx = 0; idx < vis.length; idx++){
	        Arrays.fill(vis[idx], -1);    
	    }
        
        	    
	    bfs(mX, mY);
	    
	    bw.write(vis[kX][kY]+"");
	    
	    
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int x, int y){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {x, y});
	    vis[x][y] = 0;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        if(now[0] == kX && now[1] == kY){
	            return;
	        }
	        
	        for(int dir = 0; dir < 4; dir++){ //이동, 동남서북
	           int nx = now[0] + dx[dir];
	           int ny = now[1] + dy[dir];
	           
	           for(int c = 0; c < 2; c++){
	               int direction = (dir + c) % 4;
	               int mx = nx + cx[direction];
	               int my = ny + cy[direction];
	               
	               if(isPossible(mx, my)){
	                   mx += cx[direction];
	                   my += cy[direction];
	                   
	                   if(check(mx, my) && vis[mx][my] == -1){
	                       dq.add(new int[] {mx, my});
	                       vis[mx][my] = vis[now[0]][now[1]] + 1;
	                   }
	               }
	           }
	        }
	    }
	    
	}
	
	
	static boolean check(int x, int y){ //범위 체크
	    return x >= 0 && y >= 0 && x < 10 && y < 9;
	}
	
	static boolean isPossible(int x, int y){
	    if(x == kX && y == kY){
	        return false;
	    }
	    return true;
	}
}
