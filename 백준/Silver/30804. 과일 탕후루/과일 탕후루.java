// N 개의 과일
// 과일의 종류 : 1 ~ 9 까지의 번호
    // 2개만 존재하는 것을 확인하는 1 ~ 9 배열을 생성
    //만약 존재하면  + 1, 존재하지 않으면 0
// 과일을 2 종류 이하로 사용


import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int[] kinds;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    
	    kinds = new int[10];
	    arr = new int[n];
	    
	    
	    for(int idx = 0; idx < n; idx++){
	        
	        int num = Integer.parseInt(st.nextToken());
	        
	        //꼬치에 과일 종류 저장
	        arr[idx] = num;
	        
	    }// 초기화
	    
	    
	    
	    int left = 0;
	    int cnt = 0;
	    int answer = 0;
	    
	    for(int right = 0; right < n; right++){
	        int rightValue = arr[right];
	        if(kinds[rightValue] == 0){
	            cnt += 1;
	        }
            kinds[rightValue] += 1;	        
            
	        while(cnt > 2){
	            int leftValue = arr[left];
	            kinds[leftValue] -= 1;
	            if(kinds[leftValue] == 0){
	                cnt -= 1;
	            }
	            left += 1;
	        }
	        
	        answer = Math.max(answer, right - left + 1);
	        
	    }
	    
	    bw.write(answer+"");
		bw.flush();
	    bw.close();
	}
	
}
