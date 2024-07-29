import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t=0; t < test; t++){
	        bw.write("#"+(t+1)+" ");
	        
	        String str = br.readLine();
	        
	        int bar = 0; // 막대기 개수
	        int sum = 0; //잘린 막대기 수
	        
	        for(int i=0; i<str.length(); i++){
	            if(str.charAt(i) == '('){
	                bar += 1;     
	            }
	            else{
	                bar -= 1; // 레이저 이기 때문에 이전의 '('' 된 것을 감소 시키거나 || 레이저가 아니면 막대기의 끝 부분 이기에 무조건 막대기 -1
	                if(str.charAt(i-1) == '('){ // ')' 일때 직전이 '(' 라면 막대기가 아니라 레이저다.
	                    sum += bar; //잘린 막대기 1개씩 추가 되기 때문에 sum에 추가
	                }
	                else{   // ')' 이고 레이저가 아니면 잘린 마지막 막대기 하나 sum에 추가
    	                sum += 1;
	                }
	            }
	            
	        }
	        bw.write(sum+"\n");
	    } //테스트케이스 끝
	    
	    bw.flush();
	    bw.close();
	}
}
