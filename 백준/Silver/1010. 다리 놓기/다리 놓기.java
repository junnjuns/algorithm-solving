import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int test = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < test; t++){
            
            st = new StringTokenizer(br.readLine());
            
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            int[][] dp = new int[right + 1][left + 1];
            
            for(int idx = 1; idx < right + 1; idx++){
                dp[idx][0] = 1;
                dp[idx][1] = idx;
            }
            
            for(int row = 2; row < right + 1; row++){
                for(int col = 2; col < left + 1; col++){
                    dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col];
                }
            }
            
            bw.write(dp[right][left]+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}