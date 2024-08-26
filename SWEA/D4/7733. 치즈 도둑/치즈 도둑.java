

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

//borad를 돌면서 8방향을 보았을 때 지뢰가 없는 부분을 먼저 찾는다.
	//해당 좌표가 있다면 해당 좌표를 기준으로 주변8곳 을 방문처리 한다.
	//주변 8곳을 확인하면서 해당 좌표 기준으로 주변 8곳을 추가적으로 확인하며 만약 해당 좌표의 주변에도 지뢰가 없다면 큐에 추가한다.
//다시 board의 처음부터 끝까지 확인하며 방문하지 않았고 '.' 인 부분을 확인하며 answer를 추가한다.

public class Solution {
	
	static int size;
	static int[][] board;
	static boolean[][] vis;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] cheese;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) { //test 케이스 실행 
			bw.write("#"+t+" ");
			
			size = Integer.parseInt(br.readLine());
			
			int day = 0;
			board = new int[size][size];
			
			for(int h = 0; h < size; h++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0; w < size; w++) {
					board[h][w] = Integer.parseInt(st.nextToken());
					day = Math.max(day, board[h][w]);
				}
			} // board 입력 끝
			
			
			int answer = 1;
			
			
			for(int idx = 1; idx <= day; idx++) { //날짜끝까지 확인
				
				int cnt = 0;
				vis = new boolean[size][size];
				
				for(int h = 0; h < size; h++) {
					for(int w = 0; w < size; w++) {
						if(board[h][w] > idx && vis[h][w] == false) {
							eatFunc(h, w, idx);
							cnt++;
						}
					}
				} //idx인 값들 모두 true로 초기화
				
				
				answer = Math.max(answer, cnt);
			}
			
			bw.write(answer+"\n");
		} //테스트 케이스 끝
		
		bw.flush();
		bw.close();
	}
	
	static void eatFunc(int sx, int sy, int num) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {sx, sy});
		vis[sx][sy] = true;
		
		while(dq.size() != 0) {
			int[] now = dq.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
				
				
				if(nx >= 0 && ny >= 0 && nx < size && ny < size) {
					if(vis[nx][ny] == false && board[nx][ny] > num) {
						dq.add(new int[] {nx, ny});
						vis[nx][ny] = true;
					}
				}
			}
		}
		
	}
}
