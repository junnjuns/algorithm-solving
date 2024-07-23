import java.util.*;
import java.io.*;


public class Main
{   
    static int n,m;
    static int[][] board;
    static int[][][] vis;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static ArrayDeque<int[]> wall = new ArrayDeque<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = -1;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    start[0] = Integer.parseInt(st.nextToken()) - 1;
	    start[1] = Integer.parseInt(st.nextToken()) - 1;
	    
	    st = new StringTokenizer(br.readLine());
	    end[0] = Integer.parseInt(st.nextToken()) - 1;
	    end[1] = Integer.parseInt(st.nextToken()) - 1;
	    
	    board = new int[n][m];
	    
	    for(int col = 0; col < n; col++){
	        st = new StringTokenizer(br.readLine());
	        for(int row = 0; row < m; row++){
	            board[col][row] = Integer.parseInt(st.nextToken());
	            if(board[col][row] == 1){
	                wall.add(new int[] {col, row});
	            }
	        }
	    } 
	    //입력 끝
	    vis = new int[n][m][2];
	    
	    bfs(start[0], start[1]);
	    
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int i, int j){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i, j, 0});
	    vis[i][j][0] = 1;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        if(now[0] == end[0] && now[1] == end[1]){
	            answer = vis[now[0]][now[1]][now[2]] - 1;
	            return;
	        }
	        
	        for(int k = 0; k < 4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x >= 0 && y >= 0 && x < n && y < m){
	                if(board[x][y] == 0 && vis[x][y][now[2]] == 0){
	                    dq.add(new int[] {x, y, now[2]});
	                    vis[x][y][now[2]] = vis[now[0]][now[1]][now[2]] + 1;
	                }
	                
	                else if(board[x][y] == 1 && vis[x][y][now[2]] == 0 && now[2] == 0){
	                    dq.add(new int[] {x, y, now[2] + 1});
	                    vis[x][y][1] = vis[now[0]][now[1]][now[2]] + 1;
	                }
	            }
	        }
	    }
	}
}
