import java.util.*;
import java.io.*;

public class Main
{   
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, 5);
        
        int number  = (int)Math.sqrt(n);
        
        // 제곱 저장한 배열
        int[] squareArr = new int[number + 1];
        
        for(int idx = 1; idx < number + 1; idx++){
            squareArr[idx] = idx * idx;
        }
        
        dp[0] = 0;
        
        for(int idx = 1; idx < n + 1; idx++){
            for(int j = 1; j < number + 1; j++){
                if(idx < squareArr[j]){
                    break;
                }
                dp[idx] = Math.min(dp[idx], dp[idx - squareArr[j]] + 1);
            }
        }
        
        
        bw.write(dp[n]+"");
		bw.flush();
	    bw.close();
	}
	
}
