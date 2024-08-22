import java.util.*;
import java.io.*;

//가장 위의 열부터 가장 아래 열 순으로 시작
//3방향으로 탐색 시작
//	오른쪽 대각선 위
//	오른쪽
//	오른쪽 대각선 아래
//		위, 오, 아래 순서로 만약 가장 오른쪽에 도착했으면 방향 탐색  break;

class Main {

	static int height, width;
	static char[][] board;
	static int[] dx = { -1, 0, 1 }; // 방향
	static int[] dy = { 1, 1, 1 }; // 방향
	static boolean[][] vis; // 방문 배열
	static int answer;
    static boolean check;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		board = new char[height][width];
		vis = new boolean[height][width];
		
		for(int h = 0; h < height; h++) {
			String line = br.readLine();
			for(int w = 0; w < width; w++) {
				board[h][w] = line.charAt(w);
			}
		} //board 입력
		
		
		for(int h = 0; h < height; h++) {
			if(move(h, 0)){
			  answer++;  
			}
		}
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}

	static boolean move(int x, int y) {
		if(y == width - 1) { //만약 가장 오른쪽에 도달한다면
			return true;
		}
		
		if(x - 1 >= 0 && y + 1 >= 0 && x - 1 < height && y + 1 < width && board[x - 1][y + 1] == '.' && !vis[x - 1][y + 1]) {
			vis[x - 1][y + 1] = true;
			if(move(x - 1, y + 1))
			    return true;
		}
		
		if(x >= 0 && y + 1 >= 0 && x < height && y + 1 < width && board[x][y + 1] == '.' && !vis[x][y + 1]) {
			vis[x][y + 1] = true;
			if(move(x, y + 1))
			    return true;
		}
		
		if(x + 1 >= 0 && y + 1 >= 0 && x + 1 < height && y + 1 < width && board[x + 1][y + 1] == '.' && !vis[x + 1][y + 1]) {
			vis[x + 1][y + 1] = true;
			if(move(x + 1, y + 1))
			    return true;
		}
		
		return false;
	}	
	
}


