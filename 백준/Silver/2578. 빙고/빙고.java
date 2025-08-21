import java.util.*;
import java.io.*;

public class Main
{
    
    static int[][] board;
    static int count;
    static Map<Integer, int[]> map;
    static int[] rowCnt;
    static int[] colCnt;
    static int[] diagCnt;
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    board = new int[5][5];
	    map = new HashMap<>();
	    rowCnt = new int[5];
	    colCnt = new int[5];
	    diagCnt = new int[2]; //대각선
	    
	    for(int row = 0; row < 5; row++){
	        st = new StringTokenizer(br.readLine());
	        for(int col = 0; col < 5; col++){
	            board[row][col] = Integer.parseInt(st.nextToken());
	            
	            map.put(board[row][col], new int[] {row, col});
	        }
	    } // board 초기화 끝
	    
	    outer:
	    for(int row = 0; row < 5; row++){
	        st = new StringTokenizer(br.readLine());
	        for(int col = 0; col < 5; col++){
	            count += 1;
	            
	            int call = Integer.parseInt(st.nextToken());
	            
	            int[] pos = map.get(call);
	            
	            rowCnt[pos[0]] += 1;
	            colCnt[pos[1]] += 1;
	            if(pos[0] == pos[1]){
	                diagCnt[0] += 1;
	            }
	            if(pos[0] + pos[1] == 4){
	                diagCnt[1] += 1;
	            }
	            
	            if(rowCnt[pos[0]] == 5){
	                answer += 1;
	            }
	            if(colCnt[pos[1]] == 5){
	                answer += 1;
	            }
	            if(diagCnt[0] == 5 && pos[0] == pos[1]){
	                answer += 1;
	            }
	            if(diagCnt[1] == 5 && pos[0] + pos[1] == 4){
	                answer += 1;
	            }
	            
	            if(answer >= 3){
	                bw.write(count+"\n");
	                break outer;
	            }
	        }
	        
	        
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	
}
