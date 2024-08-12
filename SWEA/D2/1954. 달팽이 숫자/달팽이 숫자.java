import java.util.*;
import java.io.*;


public class Solution
{   
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] board;
    static int boardSize;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    
	    int test  = Integer.parseInt(br.readLine());
	    
	    
	    
        for(int t = 0; t < test; t++){
            bw.write("#"+(t+1)+"\n");
            
            boardSize = Integer.parseInt(br.readLine());
            
            board = new int[boardSize][boardSize];
            
            fill(0, 0); //board 돌면서 내용 채우기
            
            
            for(int[] h : board){ //정답 코드 출력
                for(int w : h){
                    bw.write(w+" ");
                }
                bw.newLine();
            }
        }
        	    
	    
	    bw.flush();
	    bw.close();
	}
	
	static void fill(int startX, int startY){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {startX, startY});
	    
	    int num = 1; //채워야 할 숫자
	    board[startX][startY] = num; //0,0, 부터 1로 채우기 시작
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        int x = now[0];
	        int y = now[1];
	        
	        while(y+1 < boardSize && board[x][y+1] == 0){ // 가로로 커질 때 ->
	            dq.add(new int[] {x, y+1});
	            board[x][y+1] = ++num;
	            y++;
	        }
	        
	        while(x+1 < boardSize && board[x+1][y] == 0){ // 세로로 커질 때 v
	            dq.add(new int[] {x+1, y});
	            board[x+1][y] = ++num;
	            x++;
	        }
	        
	        while(y-1 >=0 && board[x][y-1] == 0){ // 가로로 작아질 떄 <-
	            dq.add(new int[] {x, y-1});
	            board[x][y-1] = ++num;
	            y--;
	        }
	        while(x-1 >=0 && board[x-1][y] == 0){ // 세로로 작아질 떄 ^
	            dq.add(new int[] {x-1, y});
	            board[x-1][y] = ++num;
	            x--;
	        }
	        
	    }
	    
	}
}
