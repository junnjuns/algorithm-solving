import java.io.*;
import java.util.*;


public class Solution {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int test = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int t = 0; t < test; t++) { //테스트 시작
			bw.write("#"+(t+1)+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			char[][] board = new char[n][m];
			int x = 0;
			int y = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					board[i][j] = s.charAt(j);
					if (board[i][j] == '<' || board[i][j] == '>' || board[i][j] == '^' || board[i][j] == 'v') {
						x = i;
						y = j;
					} // 초기 전차 위치 확인
				}
			} // 초기 board 입력

			int cnt = Integer.parseInt(br.readLine()); // 명령어 개수
			String command = br.readLine(); // 명령어 모음

			for (int i = 0; i < cnt; i++) { // 명령 cnt번 반복
				char order = command.charAt(i);
				
				if (order == 'U') {
					board[x][y] = '^';
					if(x-1 >=0 && y>=0 && x-1<n && y<m) { //범위 확인
						if(board[x-1][y] == '.') { //갈수 있는 땅인지 확인
							char temp = board[x][y];
							board[x][y] = '.';
							board[x-1][y] = temp;
							x -= 1;
						}
					}
				} 
				else if (order == 'D') {
					board[x][y] = 'v';
					if(x+1 >=0 && y>=0 && x+1<n && y<m) { //범위 확인
						if(board[x+1][y] == '.') { //갈수 있는 땅인지 확인
							char temp = board[x][y];
							board[x][y] = '.';
							board[x+1][y] = temp;
							x += 1;
						}
					}
				} 
				else if (order == 'R') {
					board[x][y] = '>';
					if(x >=0 && y+1>=0 && x<n && y+1<m) { //범위 확인
						if(board[x][y+1] == '.') { //갈수 있는 땅인지 확인
							char temp = board[x][y];
							board[x][y] = '.';
							board[x][y+1] = temp;
							y += 1;
						}
					}
				} 
				else if (order == 'L') {
					board[x][y] = '<';
					if(x >=0 && y-1>=0 && x<n && y-1<m) { //범위 확인
						if(board[x][y-1] == '.') { //갈수 있는 땅인지 확인
							char temp = board[x][y];
							board[x][y] = '.';
							board[x][y-1] = temp;
							y -= 1;
						}
					}
				} 
				else if (order == 'S') { // 포탄 공격 명령어
					if(board[x][y] == '^') {
						for(int j=0; j<n; j++) { 
							if(x-j >=0 && y>=0 && x-j<n && y<m) { //범위 확인
								if(board[x-j][y] == '*') { //만약 벽돌이면
									board[x-j][y] = '.';
									break;
								}
								else if(board[x-j][y] == '#') { //만약 강철이면 종료.
									break;
								}
							}
						}
					}
					else if(board[x][y] == 'v') {
						for(int j=0; j<n; j++) { 
							if(x+j >=0 && y>=0 && x+j<n && y<m) { //범위 확인
								if(board[x+j][y] == '*') { //만약 벽돌이면
									board[x+j][y] = '.';
									break;
								}
								else if(board[x+j][y] == '#') { //만약 강철이면 종료.
									break;
								}
							}
						}
					}
					else if(board[x][y] == '>') {
						for(int j=0; j<m; j++) { 
							if(x >=0 && y+j>=0 && x<n && y+j<m) { //범위 확인
								if(board[x][y+j] == '*') { //만약 벽돌이면
									board[x][y+j] = '.';
									break;
								}
								else if(board[x][y+j] == '#') { //만약 강철이면 종료.
									break;
								}
							}
						}
					}
					else if(board[x][y] == '<') {
						for(int j=0; j<m; j++) { 
							if(x >=0 && y-j>=0 && x<n && y-j<m) { //범위 확인
								if(board[x][y-j] == '*') { //만약 벽돌이면
									board[x][y-j] = '.';
									break;
								}
								else if(board[x][y-j] == '#') { //만약 강철이면 종료.
									break;
								}
							}
						}
					}
				} 
			}
			
			for(char[] i : board) {
				for(char j : i) {
					bw.write(j+"");
				}
				bw.newLine();
			}
			
		}
		bw.flush();
		bw.close();
	}

}
