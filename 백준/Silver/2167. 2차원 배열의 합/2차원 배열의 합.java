

import java.util.*;
import java.io.*;

public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n, m;
    static int[][] board;
    static int k;
    
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for(int row = 0; row < n; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < m; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
	    
	    k = Integer.parseInt(br.readLine());
	    
	    for(int idx = 0; idx < k; idx++){
	        st = new StringTokenizer(br.readLine());
	        int x1 = Integer.parseInt(st.nextToken()) - 1;
	        int y1 = Integer.parseInt(st.nextToken()) - 1;
	        int x2 = Integer.parseInt(st.nextToken()) - 1;
	        int y2 = Integer.parseInt(st.nextToken()) - 1;
	        
	        int sum = 0;
	        for(int row = x1; row <= x2; row++){
	            for(int col = y1; col <= y2; col++){
	                sum += board[row][col];
	            }
	        }
	        bw.write(sum+"\n");
	    }
	    
	    
	    bw.flush();
	    bw.close();
	    
    }
    
}