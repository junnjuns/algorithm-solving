import java.util.*;
import java.io.*;

public class Main
{   
    static int n, m;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    static boolean check;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    board = new int[n][m];
	    vis = new int[n][m];
	    
	    for(int[] i : vis){
	        Arrays.fill(i, -1);
	    }
	   
	    
	    int x = 0;
	    int y = 0;
	    for(int i=0; i<n; i++){
	        String s = br.readLine();
	        for(int j=0; j<m; j++){
	            board[i][j] = s.charAt(j) -'0';
	            if(board[i][j] == 2){
	                x = i;
	                y = j;
	            }
	        }
	    }
	    
	    bfs(x, y);
	    String str = check ? "TAK\n"+answer : "NIE";
	    bw.write(str);
	    bw.flush();
	    bw.close();
	}
	static void bfs(int i, int j){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i, j});
	    vis[i][j] = 0;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        if(board[now[0]][now[1]] == 3 ||board[now[0]][now[1]] == 4 ||board[now[0]][now[1]] == 5 ){
	            answer = vis[now[0]][now[1]];
	            check = true;
	            return;
	        }
	        
	        for(int k=0; k<4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x >=0 && y >=0 && x <n && y <m){
	                if(board[x][y] != 1 && vis[x][y] == -1){
	                    dq.add(new int[] {x, y});
	                    vis[x][y] = vis[now[0]][now[1]] + 1;
	                }
	            }
	        }
	    }
	    
	}
}
