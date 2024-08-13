import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
        st = new StringTokenizer(br.readLine());
        
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = board[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
      
        
        for (int k = 1; k <= m; k++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int i = x1; i <= x2; i++) {
                sum = sum + (board[i][y2] - board[i][y1-1]);
            }
            bw.write(sum + "\n");
        }
        
        bw.flush();
        bw.close();
    }
    
}
