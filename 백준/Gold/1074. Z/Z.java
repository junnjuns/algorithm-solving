import java.util.*;
import java.io.*;

//N, r, c 입력 받음
//크기가 2N x 2N인 board 생성함
//목표 위치가 어느 위치에 있는지 확인하고 재귀 실행
	//	목표 위치 좌상, 우상, 좌하, 우하 조건 확인
		


class Main {
	
	static int boardSize;
	static int x, y;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		//N, r, c 입력 받음
		boardSize = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
		fill(0, 0, boardSize); //목표 위치가 어느 위치에 있는지 확인하고 재귀 실행
		
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	
	static void fill(int r, int c, int size) {
		if(size == 1) { //종료 조건
			return;
		}
		
		int half = size / 2;
		
		//좌상
		if(x < r + half && y < c + half) {
			fill(r, c, half);
			
		}
		//우상
		else if(x < r + half && y >= c + half) {
			fill(r, c + half, half);
			answer += (size * size)/4*1;
		}
		//좌하
		else if(x >= r + half && y < c + half) {
			fill(r + half, c, half);
			answer += (size * size)/4*2;
		}
		//우하
		else {
			fill(r + half, c + half, half);
			answer += (size * size)/4*3;
		}
	}
}
