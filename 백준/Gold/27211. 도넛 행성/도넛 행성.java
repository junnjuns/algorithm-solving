
import java.util.*;
import java.io.*;

public class Main
{
    
    static int height, width;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    
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
        
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                if(board[row][col] == 0 && vis[row][col] == 0){
                    bfs(row, col);
                    answer += 1;
                }
                
            }
        }
        
        bw.write(answer+"");
        bw.flush();
        bw.close();
        
    }
    
    static void bfs(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = 1;
        
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(nx < 0){
                    nx = height - 1;
                }
                if(nx >= height){
                    nx = 0;
                }
                if(ny < 0){
                    ny = width - 1;
                }
                if(ny >= width){
                    ny = 0;
                }
                //다음 칸이 길이고 방문하지 않았을 경우
                if(board[nx][ny] == 0 && vis[nx][ny] == 0){
                    dq.add(new int[] {nx, ny});
                    vis[nx][ny] = 1;
                }
                
            }
        }
    }
    
    
}
