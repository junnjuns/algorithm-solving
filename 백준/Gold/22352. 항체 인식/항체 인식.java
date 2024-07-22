import java.util.*;
import java.io.*;

public class Main
{   
    static int n, m;
    static int[][] board;
    static int[][] nboard;
    static boolean[][] vis;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    board = new int[n][m];
	    nboard = new int[n][m];
	    vis = new boolean[n][m];
	    
	    for(int col = 0; col < n; col++){
	        st = new StringTokenizer(br.readLine());
	        for(int row = 0; row < m; row++){
	            board[col][row] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int col = 0; col < n; col++){
	        st = new StringTokenizer(br.readLine());
	        for(int row = 0; row < m; row++){
	            nboard[col][row] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    int[] arr = new int[2];
	    loop:
	    for(int col = 0; col < n; col++){
	        for(int row = 0; row < m; row++){
	            if(board[col][row] != nboard[col][row]){
	                arr[0] = col;
	                arr[1] = row;
	                break loop;
	            }
	        }
	    }
	    bfs(arr[0], arr[1]);
	    boolean check = compare();
	    
	    if(check) bw.write("YES");
	    else bw.write("NO");
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int i, int j){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i, j});
	    ArrayList<int[]> list = new ArrayList<>();
	    list.add(new int[] {i, j});
	    vis[i][j] = true;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        for(int k=0; k<4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x>=0 && y>=0 && x<n && y<m){
	                
	                if(board[x][y] == board[now[0]][now[1]] && !vis[x][y]){
	                    dq.add(new int[] {x, y});
	                    list.add(new int[] {x, y});
	                    vis[x][y] = true;
	                }
	                
	            }
	        }
	    }
	    int target = nboard[i][j];
	    for(int[] arr : list){
	        board[arr[0]][arr[1]] = target;
	    }
	}
	
	static boolean compare(){
	    for(int col = 0; col < n; col++){
	        for(int row = 0; row < m; row++){
	            if(board[col][row] != nboard[col][row]){
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
}
