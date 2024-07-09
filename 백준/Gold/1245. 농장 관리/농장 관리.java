import java.util.*;
import java.io.*;

public class Main
{   
    static int n,m;
    static int[][] board;
    static int[][] top;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] qx = {1,-1,0,0,1,1,-1,-1};
    static int[] qy = {0,0,1,-1,1,-1,1,-1};
    static int cnt = 0;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
        top = new int[n][m];
        
		for(int i=0; i<n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<m; j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		    }
		} //입력 끝
		
		
		for(int i=0; i<n; i++){
		    for(int j=0; j<m; j++){
		        if(board[i][j] != 0 && top[i][j] == 0){
		            bfs(i,j);
		        }
		    }
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
	
	static void bfs(int i, int j){
	    vis = new int[n][m];
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i,j});
	    vis[i][j] = 1;
	    ArrayDeque<int[]> topDq = new ArrayDeque<>();
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        for(int k=0; k<8; k++){
	            int x = now[0] + qx[k];
	            int y = now[1] + qy[k];
	            
	            if(x>=0 && y>=0 && x<n && y<m){
	                if(vis[x][y] == 0){
	                    if(board[x][y] > board[now[0]][now[1]]){
	                        return;
	                    }
	                    else if(board[x][y] == board[now[0]][now[1]]){
	                        topDq.add(new int[] {x,y});
	                        dq.add(new int[] {x,y});
	                    }
	                    vis[x][y] = 1;
	                }
	            }
	        }
	    }
	    while(topDq.size() != 0){
	            int[] idx = topDq.poll();
	            top[idx[0]][idx[1]] = 1;
	        }
	        cnt++;
	}
}
