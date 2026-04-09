import java.util.*;
import java.io.*;

public class Main
{   
    static int width;
    static int height;
    static int[][] board;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		board = new int[height][width];
		
		for(int h = 0; h < height; h++){
		    st = new StringTokenizer(br.readLine());
		    for(int w = 0; w < width; w++){
		        board[h][w] = Integer.parseInt(st.nextToken());
		    }
		}
		
		bfs(0, 0);
		
		String answer = board[height - 1][width - 1] == 0 ? "Yes" : "No";
		
		bw.write(answer+"");
		
		bw.flush();
		bw.close();
	}
    static void bfs(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        board[sx][sy] = 0;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            for(int dir = 0; dir < 2; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(nx < height && ny < width){
                    if(board[nx][ny] == 1){
                        dq.add(new int[] {nx, ny});
                        board[nx][ny] = 0;
                    }
                }
            }
            
            
               
        }
    }
}
