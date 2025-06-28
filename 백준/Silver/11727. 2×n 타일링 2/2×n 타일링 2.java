import java.util.*;
import java.io.*;

public class Main
{   
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] dp = new int[n + 1];
	    
	    dp[1] = 1;
	    if(n >= 2)
	        dp[2] = 3; 
	    if(n >= 3)
    	    dp[3] = 5;
	        
	    for(int idx = 4; idx < n + 1; idx++){
	        dp[idx] = (dp[idx - 1] + dp[idx - 2] * 2) % 10007;
	    }
	    
	    bw.write(dp[n] + "");
	    
		bw.flush();
	    bw.close();
	}
	
}
