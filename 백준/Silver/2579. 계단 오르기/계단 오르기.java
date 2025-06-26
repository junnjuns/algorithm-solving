// 계단은 한 번에 한 계단 or 두 계단 가능
    //재귀적으로 한 계단 가는 경우, 두 계단 가는 경우 구현
// 연속된 세 개의 계단 밟지 못함
    // 현재 몇번 재 연속인지 확인할 수 있는 상태 관리가 필요하다.
// 마지막 계단 반드시 밟아야 함
// 최댓값 구하기
// 계단 개수 300이하 and 점수 10000이하

import java.util.*;
import java.io.*;

public class Main
{   
    static int stairsCnt;
    static int[][] dp;
    static int[] score;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		stairsCnt = Integer.parseInt(br.readLine());
		score = new int[stairsCnt + 1];
		dp = new int[stairsCnt + 1][3];
		
		for(int[] row : dp){
		    Arrays.fill(row, -1);
		}
		
		for(int idx = 0; idx < stairsCnt; idx++){
		    score[idx + 1] = Integer.parseInt(br.readLine() );
		}
		
		dp[0][0] = 0;
		if(stairsCnt >= 1){
		    dp[1][1] = score[1];    
		}
		if(stairsCnt >= 2){
		    dp[2][1] = score[2];
		    dp[2][2] = score[1] + score[2];    
		}
		
		
		for(int idx = 3 ; idx < stairsCnt + 1; idx++){
		    
		    //2 연속 으로 될 때
		    if(dp[idx - 1][1] != -1){
		        dp[idx][2] = dp[idx - 1][1] + score[idx];
		    }
		    
		    //1 연속으로 될 때
		    int value = Math.max(dp[idx - 2][1], dp[idx - 2][2]);
		    if(value != -1){
		        dp[idx][1] = value + score[idx];
		    }
		    
		}
		
		
		bw.write(Math.max(dp[stairsCnt][1], dp[stairsCnt][2])+"");
		bw.flush();
	    bw.close();
	}
	
}
