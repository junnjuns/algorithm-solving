import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;
	static int row, col;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] vis;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		board = new int[row][col];
		
		for(int h = 0; h < row; h++){
		    st = new StringTokenizer(br.readLine());
		    for(int w = 0; w < col; w++){
		        board[h][w] = Integer.parseInt(st.nextToken());
		    }
		}
		
		int time = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while(true){
		    
		    boolean check = true;
		    vis = new int[row][col];
		    int cnt = 0;
		    for(int h = 0; h < row; h++){
    		    for(int w = 0; w < col; w++){
    		        if(board[h][w] == 1){
    		            check = false;
    		            cnt += 1;
    		        }
    		    }
		    }
		    list.add(cnt);
		    if(check) break;
		    
		    time += 1;
		    fill(0, 0);
		}
		
		bw.write(time+"\n");
		bw.write(list.get(list.size() - 2)+"");
		bw.flush();
		bw.close();
	}
	
	static void fill(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = 1;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(nx >= 0 && ny >= 0 && nx < row && ny < col){
                    if(vis[nx][ny] == 0 && board[nx][ny] == 0){
                        dq.add(new int[] {nx, ny});
                        vis[nx][ny] = 1;
                    }
                    else if(board[nx][ny] == 1){
                        board[nx][ny] = 0;
                        vis[nx][ny] = 1;
                    }
                }
            }
            
        }
	}
}
