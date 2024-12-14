import java.util.*;
import java.io.*;


//각 자리수 마다 -> 2^자리수 개의 숫자 가능
public class Main
{   
    static int rank;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    rank = Integer.parseInt(br.readLine());
	    
	    int len = 1; //초기 자릿수
	    int total = 0;
	    while(true){
	        
	        int cnt = (int)Math.pow(2, len);
	        
	        
	        if(rank <= cnt + total){
	            break;
	        }
	        
	        total += cnt;
	        len += 1;
	    }
	    
	    
        int target = rank - total - 1;//len 자릿수에서 target번째 수가 정답   
	    
        StringBuilder sb = new StringBuilder();
        
        for (int idx = len - 1; idx >= 0; idx--) {
            
            int cnt = (int)Math.pow(2, idx);
            
            if(target >= cnt){
                sb.append('7'); // '7'을 선택
                target -= cnt; // target을 갱신
            }
            else{
                sb.append('4'); // '4'를 선택
            }
        }
        
        bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	}
	
	
}
