import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main
{   
    static BufferedWriter bw;
    static int[][] board;
    static boolean[][] vis;
    static int n,m,k;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t=0; t<test; t++){
		    st = new StringTokenizer(br.readLine());
		    m = Integer.parseInt(st.nextToken());
		    n = Integer.parseInt(st.nextToken());
		    k = Integer.parseInt(st.nextToken());
		    
		    board = new int[n][m];
		    vis = new boolean[n][m];
		    
		    for(int i=0; i<k; i++){
		        st = new StringTokenizer(br.readLine());
		        int a = Integer.parseInt(st.nextToken());
		        int b = Integer.parseInt(st.nextToken());
		        board[b][a] = 1;
		    }
		    int cnt = 0;
		    for(int i=0; i<n; i++){
		        for(int j=0; j<m; j++){
		            if(vis[i][j] == false && board[i][j] == 1){
		                DFS(i,j);
		                cnt++;
		            }
		        }
		    }
		    bw.write(cnt+"");
		    bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	static void DFS(int i, int j){
	    vis[i][j] = true;
	    
	    for(int k=0; k<4; k++){
	        int x = i + dx[k];
	        int y = j + dy[k];
	        
	        if(x >=0 && y >=0 && x < n && y < m){
	            if(board[x][y] == 1 && vis[x][y] == false){
	                DFS(x,y);
	            }
	        }
	    }
	}
	
	
}
