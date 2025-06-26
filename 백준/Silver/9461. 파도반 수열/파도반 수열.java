import java.util.*;
import java.io.*;

public class Main
{   
    static long[] dp;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		dp = new long[101];
        dp[1] = 1;
    	dp[2] = 1;
    	dp[3] = 1;
    		
    	for(int idx = 4; idx < 101 ; idx++){
    	    dp[idx] = dp[idx - 2] + dp[idx - 3];   
    	}
		
		for(int t = 0; t < test; t++){
		    int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");    	
		}
		
		bw.flush();
	    bw.close();
	}
	
}
