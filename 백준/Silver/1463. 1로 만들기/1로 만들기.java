import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];


        //초기값 설정 : 1을 시작지점으로 설정
        dp[1] = 0;

        for(int idx = 2; idx < dp.length; idx++){
            //1씩 추가 연산
            dp[idx] = dp[idx - 1] + 1;

            //2로 나누는 연산 가능할 때
            if(idx % 2 == 0){
                //-1 연산과 했을 때 vs 2 나누기 연산 했을 때
                dp[idx] = Math.min(dp[idx], dp[idx / 2] + 1);
            }

            //3으로 나누는 연산 가능할 때
            if(idx % 3 == 0){
                //-1 연산과 했을 때 vs 3 나누기 연산 했을 때
                dp[idx] = Math.min(dp[idx], dp[idx / 3] + 1);
            }


        }

        bw.write(dp[num]+"");
        bw.flush();
        bw.close();
    }
}

