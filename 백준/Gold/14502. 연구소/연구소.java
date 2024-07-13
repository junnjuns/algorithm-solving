import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static int[][] board;
	static int[][] tempBoard;
	static boolean[][] vis;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int max = Integer.MIN_VALUE;
	static int safe;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		tempBoard = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		} //초기 board 값 입력 끝
		
		wall(0);
		
		bw.write(max+"");
		
		bw.flush();
		bw.close();
	}
	
	static void wall(int dep) {
		if(dep == 3) {
			vis = new boolean[n][m]; //벽 세울때마다 방문 배열 초기화
			safe = 0; //안전 구역  개수
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					tempBoard[i][j] = board[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tempBoard[i][j] == 2 && vis[i][j] == false) {
						BFS(i, j);
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tempBoard[i][j] == 0) {
						safe++;
					}
				}
			}
			max = Math.max(max, safe);
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 0) {
					board[i][j] = 1;
					wall(dep+1);
					board[i][j] = 0;
				}
			}
		}
	}
	
	
	static void BFS(int i, int j) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {i,j});
		vis[i][j] = true;
		
		while(dq.size() != 0) {
			int[] now = dq.poll();
			
			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				
				if(x>=0 && y>=0 && x<n && y<m) {
					if(tempBoard[x][y] == 0 && vis[x][y] == false) {
						dq.add(new int[] {x,y});
						tempBoard[x][y] = 2;
						vis[x][y] = true;
					}
				}
				
			}
		}
	}
	
	
}
