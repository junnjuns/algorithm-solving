import java.util.*;
import java.io.*;

public class Main {

    static int boardSize;
    static int[][] board;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        boardSize = Integer.parseInt(br.readLine());
        
        board = new int[boardSize][boardSize];
        
        for(int h = 0 ; h < boardSize; h++){ //board 입력 받음
            String str = br.readLine();
            for(int w = 0; w < boardSize; w++){
                board[h][w] = str.charAt(w) - '0';
            }
        }
        
        divide(0, 0, boardSize); //압축 로직을 실행하는 메서드
        
        bw.flush();
        bw.close();
    }
    
    static void divide(int r, int c, int size) throws Exception {
        
		int first = board[r][c]; 
		boolean check = true;
		
		//해당 지역에서 압축 가능 여부를 확인한다.
		for(int h = r; h < r + size; h++){
		    for(int w = c; w < c + size; w++){
		        if(board[h][w] != first){ 
		            check = false;
		        }
		    }
		}
		
		
		if(check){ //해당 지역을 모두 확인했을 때 압축을 할 수 있다면 해당 지역 번호를 출력후 return;
		    bw.write(first+"");
		    return;
		}
		else{ //해당 지역을 모두 확인했을 때 압축을 하지 못한다면 4등분 재귀
		    bw.write("(");
		    int half = size / 2;
		
            divide(r, c, half);
            divide(r, c + half, half);
            divide(r + half, c, half);
            divide(r + half, c + half, half);
		    bw.write(")");
		}
	}
    
}
