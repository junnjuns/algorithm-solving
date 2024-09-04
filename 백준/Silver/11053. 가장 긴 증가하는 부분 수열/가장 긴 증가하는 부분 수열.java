import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < n; idx++){
            arr[idx] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        dp[0] = 1;
        for(int idx = 1; idx < n; idx++){
            dp[idx] = 1;

            for(int j = 0;  j < idx; j++){
                if(arr[idx] > arr[j]){
                    dp[idx] = Math.max(dp[idx], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        bw.write(dp[n-1]+"");
        bw.flush();
        bw.close();
    }
}
