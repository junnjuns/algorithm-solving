import java.util.*;
import java.io.*;

public class Main
{   
    static int n,m;
    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cheese;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    cheese++;
                }
            }
        } //보드 입력 끝
        
        int time = 0;
        
        while(cheese > 0){
            vis = new boolean[n][m];
            bfs(0,0);
            time++;
        }
        
        bw.write(time+"");
        bw.flush();
        bw.close();
    }
    
    static void bfs(int i, int j){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {i, j});
        vis[i][j] = true;
        ArrayList<int[]> list = new ArrayList<>();
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if(x>=0 && y>=0 && x<n && y<m){
                    if(board[x][y] == 0 && vis[x][y] == false){ //공기일 때
                        dq.add(new int[] {x, y});
                        vis[x][y] = true;
                    }
                    else if(board[x][y] == 1 && vis[x][y] == false){ //치즈일 때
                        
                        int air = 0;
                        
                        for(int q=0; q<4; q++){ //치즈 주변 공기 확인
                            int nx = x + dx[q];
                            int ny = y + dy[q];
                            
                            if(nx>=0 && ny>=0 && nx<n && ny<m){
                                if(board[nx][ny] == 0 && vis[nx][ny] == true){
                                    air += 1;
                                }
                            }
                        }
                        
                        if(air >= 2){
                            list.add(new int[] {x, y});
                            vis[x][y] = true;
                        }
                    }
                }
            }
        }
        
        for(int idx = 0; idx < list.size(); idx++){
            int[] now = list.get(idx);
            board[now[0]][now[1]] = 0;
            cheese -= 1;
        }
 }
}