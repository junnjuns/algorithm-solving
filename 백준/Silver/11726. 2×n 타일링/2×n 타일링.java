import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        if(n < 3){
            bw.write(n+"");
        }
        else{
            int[] dp = new int[n + 1];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;

            for(int idx = 4; idx < n + 1; idx++){
                dp[idx] = (dp[idx -1] + dp[idx - 2]) % 10007;
            }

            bw.write(dp[n]+"");
        }



        bw.flush();
        bw.close();
    }
}
