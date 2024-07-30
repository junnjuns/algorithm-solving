
import java.util.*;
import java.io.*;

public class Solution {

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static char[][] board;
	static boolean[][] vis;
	static int n ,m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < test; t++) {
			bw.write("#"+(t+1)+" ");
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			board = new char[n][m];
			vis = new boolean[n][m];
			
			for(int col = 0; col < n; col++) {
				String s = br.readLine();
				for(int row = 0; row < m; row++) {
					board[col][row] = s.charAt(row);
				}
			} // 보드 입력 끝
			
			boolean check = true;
			
			for(int col = 0; col < n; col++) {
				for(int row = 0; row < m; row++) {
					if(board[col][row] != '?') {
						bfs(col, row);
						check = false;
					}
				}
			}//물음표 채우기
			
			boolean result = verify();
			if(result || check) {
				bw.write("possible\n");
			}
			else {
				bw.write("impossible\n");
			}
			
		}
		
		bw.flush();
		bw.close();
	}	
	
	static boolean verify() {
		
		for(int col = 0; col < n; col++) {
			for(int row = 0; row < m; row++) {
				for(int dir = 0; dir < 4; dir++) {
					int x = col + dx[dir];
					int y = row + dy[dir];
					
					if(x >= 0 && y >= 0 && x < n && y < m) {
						if(board[col][row] == board[x][y]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	static void bfs(int i, int j) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {i, j});
		vis[i][j] = true;
		
		while(dq.size() != 0) {
			int[] now = dq.poll();
			char value = board[now[0]][now[1]];
			
			if(value == '#') {
				
				for(int dir=0; dir<4; dir++) {
					int x = now[0] + dx[dir];
					int y = now[1] + dy[dir];
					
					if(x >= 0 && y >= 0 && x < n && y < m) {
						if(board[x][y] == '?' && !vis[x][y]) {
							dq.add(new int[] {x, y});
							vis[x][y] = true;
							board[x][y] = '.';
						}
					}
				}
				
			}
			else if(value == '.') {

				for(int dir=0; dir<4; dir++) {
					int x = now[0] + dx[dir];
					int y = now[1] + dy[dir];
					
					if(x >= 0 && y >= 0 && x < n && y < m) {
						if(board[x][y] == '?' && !vis[x][y]) {
							dq.add(new int[] {x, y});
							vis[x][y] = true;
							board[x][y] = '#';
						}
					}
				}
			}
			
		}
		
	}
}
