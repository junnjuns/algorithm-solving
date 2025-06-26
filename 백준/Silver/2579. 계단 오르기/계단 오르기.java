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
    static int[] stairsArr;
    static int[][] answerArr;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//계단의 개수
		stairsCnt = Integer.parseInt(br.readLine());
		//계단 배열
		stairsArr = new int[stairsCnt + 1];
		//최댓값 들어있는 배열
		answerArr = new int[stairsCnt + 1][3];
		
		//계단 값 초기화
		for(int idx = 1; idx < stairsCnt + 1; idx++){
		    stairsArr[idx] = Integer.parseInt(br.readLine());
		}
		
		for(int[] row : answerArr){
		    Arrays.fill(row, -1);
		}
		
		//재귀 시작
		// 현재 위치, 연속된 횟수
		run(0, 0, 0);
		
		int answer = Math.max(answerArr[stairsCnt][2], Math.max(answerArr[stairsCnt][0], answerArr[stairsCnt][1]));
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	
	static void run(int value, int pos, int cnt){
	    //같은 상태를 더 낮은 점수로 재방문하면 중단
        if (value <= answerArr[pos][cnt]) return;
        answerArr[pos][cnt] = value;

        if (pos == stairsCnt) return;               // 마지막 칸이면 끝
	    
	    
	    //3번 연속으로 계단 못 감
	    if(cnt < 2 && check(pos + 1)){
	        //현재 위치 + 한 계단
	        int next = value + stairsArr[pos + 1];
	        run(next, pos + 1, cnt + 1);
	    }
	    if(check(pos + 2)){
    	    //현재 위치 + 두 계단
    	    int next = value + stairsArr[pos + 2];
    	    run(next, pos + 2, 1);
	    }
	    
	    
	    
	}
	
	static boolean check(int pos){
	    return pos <= stairsCnt;
	}
	
}
