import java.io.*;
import java.util.*;

public class Main
{
    static int n,m;
    static boolean[][] vis;
    static char[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int w,b;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    m = Integer.parseInt(st.nextToken());
	    n = Integer.parseInt(st.nextToken());
	    
	    board = new char[n][m];
        vis = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = s.charAt(j);
            }
        }	    
        int white = 0;
        int blue = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                w = 0;
                b = 0;
                if(vis[i][j] == false && board[i][j] == 'W'){
                    BFSw(i,j);
                    white += w*w;
                }
                else if(vis[i][j] == false && board[i][j] == 'B'){
                    BFSb(i,j);
                    blue += b*b;
                }
            }
        }	    
        
        bw.write(white+" "+blue);    
	    bw.flush();
	    bw.close();
}

    static void BFSw(int i, int j){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {i,j});
        vis[i][j] = true;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            w++;
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if(x >=0 && y>=0 && x<n && y<m){
                    if(board[x][y] == 'W' && !vis[x][y]){
                        dq.add(new int[] {x,y});
                        vis[x][y] = true;
                    }
                }
            }
        }
    }
    
    static void BFSb(int i, int j){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {i,j});
        vis[i][j] = true;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            b++;
            
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if(x >=0 && y>=0 && x<n && y<m){
                    if(board[x][y] == 'B' && !vis[x][y]){
                        dq.add(new int[] {x,y});
                        vis[x][y] = true;
                    }
                }
            }
        }
    }
}
