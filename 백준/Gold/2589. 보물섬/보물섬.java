import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int m;
    static char[][] board;
    static int[][] vis;
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    static int ans;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    board = new char[n][m];
	    
	    for(int i=0; i<n; i++){ //입력값 배열 넣기
	        String s = br.readLine();
	        for(int j=0; j<m; j++){
	            board[i][j] = s.charAt(j);
	        }
	    }
	    
	    for(int i=0; i<n; i++){
	        for(int j=0; j<m; j++){
	            if(board[i][j] == 'L'){
                    vis = new int[n][m];
	                BFS(i,j);
	            }
	        }
	    }
	    bw.write(ans+"");
	    bw.flush();
	    bw.close();
	}
	
	static void BFS(int i, int j){
	    
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.offer(new int[] {i,j});
	    vis[i][j] = 1;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        for(int k=0; k<4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x>=0 && y>=0 && x<n && y<m){
	                if(vis[x][y] == 0 && board[x][y] == 'L'){
	                    dq.add(new int[] {x,y});
	                    vis[x][y] = vis[now[0]][now[1]]+1;
	                    ans = Math.max(ans, vis[x][y]-1);
	                }
	            }
	        }
	    }
	}
	
	
}
