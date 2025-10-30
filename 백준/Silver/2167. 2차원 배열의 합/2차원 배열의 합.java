

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
        
        board = new int[n + 1][m + 1];
        
        for(int row = 1; row <= n; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col <= m; col++){
                int num = Integer.parseInt(st.nextToken());
                
                board[row][col] += num + board[row - 1][col] + board[row][col - 1] - board[row - 1][col - 1];
                
            }
        }
	    
	    k = Integer.parseInt(br.readLine());
	    
	    for(int idx = 0; idx < k; idx++){
	        st = new StringTokenizer(br.readLine());
	        int x1 = Integer.parseInt(st.nextToken());
	        int y1 = Integer.parseInt(st.nextToken());
	        int x2 = Integer.parseInt(st.nextToken());
	        int y2 = Integer.parseInt(st.nextToken());
	        
	        int sum = board[x2][y2] - board[x2][y1 - 1] - board[x1 - 1][y2] + board[x1 - 1][y1 - 1];
	        bw.write(sum+"\n");
	        
	    }
	    
	    
	    bw.flush();
	    bw.close();
	    
    }
    
}