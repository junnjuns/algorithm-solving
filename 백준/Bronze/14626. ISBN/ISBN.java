import java.util.*;
import java.io.*;

public class Main
{   
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		int[] arr = new int[13];
		
		int pos = str.indexOf("*");
		
		for(int idx = 0; idx < 13; idx++){
		    if(idx == pos){
		        continue;
		    }
		    arr[idx] = str.charAt(idx) - '0';
		}
		
	    for(int idx = 0; idx < 10; idx++){
	        int result = 0;
	        arr[pos] = idx;
	        
	        for(int i = 0 ; i < 12; i++){
	            if(i % 2 == 0){
	                result += arr[i];
	            }
	            else{
	                result += 3 * arr[i];
	            }
	        }
	        int checkDigit = (10 - (result % 10)) % 10;
            if (checkDigit == arr[12]) {    // 체크디짓 일치?
                bw.write(arr[pos] + "");    // 찾은 숫자 출력
                break;
            }
	        
	    }
		
		bw.flush();
	    bw.close();
	}
	
}
