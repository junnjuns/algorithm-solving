import java.util.*;
import java.io.*;


public class Main {
	
	static char[][] board;
	static int size;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		
		board = new char[size][size];
		
		for(int row = 0; row < size; row++) {
			String str = br.readLine();
			for(int col = 0; col < size; col++) {
				board[row][col] = str.charAt(col);
			}
		}
		
		answer = getMax();
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				
				//세로 위치 바꾸기
				if(row < size - 1) {
					swap(row, col, row + 1, col);
					answer = Math.max(answer, getMax());
					swap(row, col, row + 1, col);
				}
				
				//가로 위치 바꾸기
				if(col < size - 1) {
					swap(row, col, row, col + 1);
					answer = Math.max(answer, getMax());
					swap(row, col, row, col + 1);				
				}
				
			}
		}
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
		
	}
	
	//최대 개수 구하기
	static int getMax() {
		
		
		int max = 0;
		
		for(int row = 0; row < size; row++) {
			
			int Rmax = 1;
			int Cmax = 1;	
			
			for(int col = 0; col < size - 1; col++) {
				
				//가로 비교
				if(board[row][col] == board[row][col + 1]) {
					Cmax += 1;
				}
				else {
					max = Math.max(max, Cmax);
					Cmax = 1;
				}
				
				//세로 비교
				if(board[col][row] == board[col + 1][row]) {
					Rmax += 1;
				}	
				else {
					max = Math.max(max, Rmax);
					Rmax = 1;
				}
			}
			max = Math.max(max, Cmax);
			max = Math.max(max, Rmax);
		}	
		
		return max;
	}
	
	static void swap(int x1, int y1, int x2, int y2) {
		
		char temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
		
	}
	
	
	
	
}
