import java.util.*;
import java.io.*;

public class Main
{
    static int size;
    static int[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] vis;
    static ArrayList<Integer> list;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    size = Integer.parseInt(br.readLine());
	    
	    board = new int[size][size];
	    vis = new int[size][size];
	    
	    for(int row = 0; row < size; row++){
	        String str = br.readLine();
	        for(int col = 0; col < size; col++){
	            board[row][col] = str.charAt(col) -'0';
	        }
	    }
	    
	    list = new ArrayList<>();
	    int cnt = 0;
	    
	    for(int row = 0; row < size; row++){
	        for(int col = 0; col < size; col++){
	            if(board[row][col] == 1 && vis[row][col] == 0){
	                bfs(row, col);
	                cnt += 1;
	            }
	        }
	    }
        
	    Collections.sort(list);
	    bw.write(cnt+"\n");
	    for(int n : list){
	        bw.write(n+"\n");
	    }
	    
	    
	    bw.flush();
	    bw.close();
	    
    }
    
    static void bfs(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = 1;
        int cnt = 1;
        
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(check(nx, ny) && board[nx][ny] == 1 && vis[nx][ny] == 0){
                    dq.add(new int[] {nx, ny});
                    vis[nx][ny] = 1;
                    cnt += 1;
                }
            }
            
        }
        
        list.add(cnt);
    }
    
    static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < size && y < size;
    }
    
}