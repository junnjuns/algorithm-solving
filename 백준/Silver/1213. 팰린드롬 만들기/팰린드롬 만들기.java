import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    
	    String error = "I'm Sorry Hansoo";
	    
	    String input = br.readLine();
	    
	    int[] arr = new int[26];
	    
	    
	    for(int idx = 0; idx < input.length(); idx++){
	        arr[input.charAt(idx) - 65] += 1;
	    }
	    
	    int oddCnt = 0;
	    int oddIdx = -1;
	    boolean check = false;
	    
	    for(int idx = 0; idx < 26; idx++){
	        if(arr[idx] % 2 != 0){
	            oddCnt += 1;
	            oddIdx = idx;
	        }
	    }
	    
	    if(input.length() % 2 == 0 && oddCnt != 0 || input.length() % 2 != 0 && oddCnt > 1){
	        System.out.println(error);
	    }
	    else{
	        char[] answer = new char[input.length()];
	        
	        int nowIdx = 0;
	        for (int j = 0; j < 26; j++) {
                while (arr[j] >= 2) {                 
                    answer[nowIdx] = (char)('A' + j); // 왼쪽
                    answer[answer.length - nowIdx - 1] = (char)('A' + j); // 오른쪽
                    arr[j] -= 2;                      // 쌍을 소비
                    nowIdx++;                         
                }
            }

	        
	        if(oddCnt == 1){
	            answer[input.length() / 2] = (char)('A' + oddIdx);
	        }
	        
	        for(char c : answer){
	            System.out.print(c);
	        }
	    }
	    
	}
}
