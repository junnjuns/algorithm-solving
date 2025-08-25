import java.util.*;
import java.io.*;

public class Main
{
    
    static int height;
    static int width;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        
        board = new int[height][width];
        vis = new int[height][width];
        
        for(int row = 0; row < height; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < width; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        bfs(0, 0);
        
        bw.write((vis[height - 1][width - 1] - 1)+"");
	    bw.flush();
	    bw.close();
	}
    
    static void bfs(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = 1;
        
        
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            
            int distance = board[now[0]][now[1]];
            for(int idx = 1; idx < distance + 1; idx++){
                for(int dir = 0; dir < 2; dir++){
                    int nx = now[0] + (dx[dir] * idx);
                    int ny = now[1] + (dy[dir] * idx);
                    
                    if(check(nx, ny) && vis[nx][ny] == 0){
                        dq.add(new int[] {nx, ny});
                        vis[nx][ny] = vis[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
    static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < height && y < width;
    }
}
