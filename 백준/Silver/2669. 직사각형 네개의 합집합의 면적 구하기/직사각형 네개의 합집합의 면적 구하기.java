import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int[][] board = new int[101][101];
        
        int answer = 0;
        for(int idx = 0; idx < 4; idx++){
            st = new StringTokenizer(br.readLine());
            
            int leftY = Integer.parseInt(st.nextToken());
            int upX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            int downX = Integer.parseInt(st.nextToken());
            
            for(int row = upX; row < downX; row++){
                for(int col = leftY; col < rightY; col++){
                    if(board[row][col] == 0){
                        board[row][col] = 1;
                        answer += 1;
                    }
                }
            }
            
        }
        bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
    
}
