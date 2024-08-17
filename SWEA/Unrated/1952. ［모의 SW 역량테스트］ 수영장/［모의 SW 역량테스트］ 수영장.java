import java.util.*;
import java.io.*;

public class Solution
{   
    static int[] monthArr;
    static int[] priceArr;
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t = 0; t < test; t++){ 
	        bw.write("#"+(t+1)+" ");
	        
	        priceArr = new int[4];
	        st = new StringTokenizer(br.readLine());
	        for(int idx = 0; idx < 4; idx++){
	            priceArr[idx] = Integer.parseInt(st.nextToken());
	        } //이용권 가격 입력
	        
            monthArr = new int[13];
	        st = new StringTokenizer(br.readLine());
	        for(int idx = 1; idx <= 12; idx++){
	            monthArr[idx] = Integer.parseInt(st.nextToken());
	        } //12개월 이용 계획 입력
	        
	         answer = priceArr[3]; //1년 회원권으로 시작
	        
	        func(1, 0); //1월 달부터 시작
	        
	        
	        
            bw.write(answer+"\n");
	    }// 테스트 케이스 끝
	    
	    
	    bw.flush();
	    bw.close();
	}
	
	static void func(int month, int total){
	    if(month >= 13){
	        answer = Math.min(answer, total);
	        return;
	    }
        	    
	    func(month + 1, total + monthArr[month] * priceArr[0]);
	    func(month + 1, total + priceArr[1]);
	    func(month + 3, total + priceArr[2]);
	}
}
