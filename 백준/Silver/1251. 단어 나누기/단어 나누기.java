// 임의의 두 부분을 골라서 쪼갠다 -> 3개의 단어가 나옴
    // 3개의 단어는 길이가 1 이상인 단어
// 3개의 단어들을 reverse 하고 다시 3개의 단어를 합침.
// 사전 순으로 가장 앞서는 단어 출력
// 최악의 경우 49 C 2 이기 때문에 완탐



import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String str = br.readLine();
	    
	    String answer = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
	    
	    for(int i = 0; i <  str.length() - 2; i++){ // 첫 번째 커트 포인트
	        for(int j = i + 1 ; j < str.length() - 1; j++){ //두 번째 커트 포인트
	            
	            // 세 단어로 나누기
	            StringBuilder strA = new StringBuilder(str.substring(0, i + 1));
	            StringBuilder strB = new StringBuilder(str.substring(i + 1, j + 1));
	            StringBuilder strC = new StringBuilder(str.substring(j + 1));
	            
	            String result = strA.reverse().toString() + strB.reverse().toString() + strC.reverse().toString();
	            
	            if(answer.compareTo(result) > 0){
	                answer = result;
	            }
	            
	        }
	    }
	     
	    bw.write(answer);   
	    
	    bw.flush();
	    bw.close();
	}
	
	
}
