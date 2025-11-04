import java.util.*;
import java.io.*;

public class Main
{   
    
    static int h, w;
    static char[][] board;
    static int[][] answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    h = Integer.parseInt(st.nextToken());
	    w = Integer.parseInt(st.nextToken());
	    
	    board = new char[h][w];
	    answer = new int[h][w];
	    
	    for(int row = 0; row < h; row++){
	        String str = br.readLine();
	        boolean check = false;
	        int index = 0;
	        
	        for(int col = 0; col < w; col++){
	            board[row][col] = str.charAt(col);
	            
	            if(board[row][col] == 'c'){
	                check = true;
	                index = col;
	            }
	            
	            if(!check){
	                answer[row][col] = -1;
	            }
	            else{
	                answer[row][col] = col - index;
	            }
	        }
	    }
	    
	    for(int[] arr : answer){
	        for(int n : arr){
	            bw.write(n+" ");
	        }
	        bw.newLine();
	    }
	    
	    
	    bw.flush();
	    bw.close();
	}
	
}
