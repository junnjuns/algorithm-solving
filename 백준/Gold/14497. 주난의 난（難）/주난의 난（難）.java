import java.util.*;
import java.io.*;

public class Main {
	
	static int h,w;
	static char[][] board;
	static int[][] vis;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] person = new int[2];
	static int[] target = new int[2];
 	static boolean check = false;
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		person[0] = Integer.parseInt(st.nextToken()) - 1;
		person[1] = Integer.parseInt(st.nextToken()) - 1;
		
		target[0] = Integer.parseInt(st.nextToken()) - 1;
		target[1] = Integer.parseInt(st.nextToken()) - 1;
		
		
		board = new char[h][w];
		
		
		for(int col = 0; col < h; col++) {
			String s = br.readLine();
			for(int row = 0; row < w; row++) {
				board[col][row] = s.charAt(row);
			}
		} //보드 입력 끝
		
		int answer = 0;
		while(true){
		    vis = new int[h][w];
		    bfs(person[0], person[1]);
		    answer += 1;
		    if(check) break;
		}
		
		bw.write(answer-1+"");
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int i, int j) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {i, j});
		vis[i][j] = 1;
		
		while(dq.size() != 0) {
			int[] now = dq.poll();
			
			if(now[0] == target[0] && now[1] == target[1]) {
			    check = true;
				return;
			}
			
			for(int dir = 0; dir < 4; dir ++) {
				int x = now[0] + dx[dir];
				int y = now[1] + dy[dir];
				
				if(x >= 0 && y >= 0 && x < h && y < w) {
					if(board[x][y] == '0' && vis[x][y] == 0) {
						dq.add(new int[] {x, y});
						vis[x][y] = 1;
					}
					else if(board[x][y] != '0' && vis[x][y] == 0) {
						vis[x][y] = 1;
						board[x][y] = '0';
					}
				}
			}
			
		}
	}
	
	
}
