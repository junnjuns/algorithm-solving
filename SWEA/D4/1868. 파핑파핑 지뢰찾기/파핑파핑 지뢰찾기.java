import java.util.*;
import java.io.*;

public class Solution
{   
    static int n;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,-1,1};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        int test = Integer.parseInt(br.readLine());
        
        for(int t=0; t<test; t++){
            bw.write("#"+(t+1)+" ");
            
            n = Integer.parseInt(br.readLine());
            board = new char[n][n];
            vis = new boolean[n][n];
            
            for(int i=0; i<n; i++){
                String s = br.readLine();
                for(int j=0; j<n; j++){
                    board[i][j] = s.charAt(j);
                }
            } //입력 끝
            
            int cnt = 0;
            
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] == '.' && vis[i][j] == false){
                        if(func(i,j)){
                            bfs(i,j);
                            cnt++;
                        }
                    }
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] == '.' && vis[i][j] == false){
                        cnt++;
                    }
                }
            }            
            
            bw.write(cnt+"\n");
        } //테스트 케이스 끝

        
        bw.flush();
        bw.close();
    }
    
    static void bfs(int i, int j){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {i,j});
        vis[i][j] = true;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            for(int k=0; k<8; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if(x>=0 && y>=0 && x<n && y<n){
                    if(board[x][y] == '.' && vis[x][y] == false){
                        vis[x][y] = true;
                        if(func(x,y)){
                            dq.add(new int[] {x,y});
                        }
                    }
                }
            }
            
        }
    }
    
    static boolean func(int i, int j){
        
        for(int k=0; k<8; k++){
                int x = i + dx[k];
                int y = j + dy[k];
                
                if(x>=0 && y>=0 && x<n && y<n){
                    if(board[x][y] == '*'){
                        return false;
                    }
                }
        }
        return true;
    }
}
