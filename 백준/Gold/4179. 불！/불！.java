import java.io.*;
import java.util.*;

public class Main
{
    static int n,m;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayDeque<int[]> person = new ArrayDeque<>();
    static ArrayDeque<int[]> fire = new ArrayDeque<>();
    static int[][] vis;
    static int[][] burn;
    static int answer = -1;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    board = new char[n][m];
	    vis = new int[n][m];
	    burn = new int[n][m];
	    
	    
	    for(int col = 0; col < n; col++){
	        String s = br.readLine();
	        for(int row = 0; row < m; row++){
	            board[col][row] = s.charAt(row);
	            
	            if(board[col][row] == 'J'){
	                person.add(new int[] {col, row});
	                vis[col][row] = 1;
	            }
	            
	            else if(board[col][row] == 'F'){
	                fire.add(new int[] {col, row});
	                burn[col][row] = -1;
	            }
	        }
	    }
	    
	    bfs();
	    
	    if(answer == -1){
	        bw.write("IMPOSSIBLE");
	    }
	    else{
	        bw.write(answer+"");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(){
	    
	    while(person.size() != 0){
	        int size = fire.size();
	        
	        for(int i = 0; i < size; i++){
    	        int[] now = fire.poll();
    	        
    	        for(int dir = 0; dir < 4; dir++){
    	            int x = now[0] + dx[dir];
    	            int y = now[1] + dy[dir];
    	            
    	            if(x >= 0 && y >= 0 && x < n && y < m){
    	                if(board[x][y] != '#' && burn[x][y] == 0){
    	                    board[x][y] = '*';
    	                    fire.add(new int[] {x, y});
    	                    burn[x][y] = -1;
    	                }
    	            }
    	        }	            
	        }
	        
	        size = person.size();
	        
	        for(int i = 0; i < size; i++){
    	        int[] now = person.poll();
    	        
    	        for(int dir = 0; dir < 4; dir++){
    	            int x = now[0] + dx[dir];
    	            int y = now[1] + dy[dir];
    	            
    	            if(x >= 0 && y >= 0 && x < n && y < m){
    	                if(board[x][y] == '.' && vis[x][y] == 0){
    	                    board[x][y] = 'J';
    	                    person.add(new int[] {x, y});
    	                    vis[x][y] = vis[now[0]][now[1]] + 1;
    	                }
    	            }
    	            else{
    	                answer = vis[now[0]][now[1]];
    	                return;
    	            }
    	        }	            
	        }
	    }
	    
	}
}
