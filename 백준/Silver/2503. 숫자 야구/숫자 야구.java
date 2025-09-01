import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static boolean[] check;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    check = new boolean[988];
	    
	    for(int idx = 123; idx < 988; idx++){
	        String str = idx+"";
	        
	        if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0'){
	            continue;
	        }
	        if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)){
	            continue;
	        }
	        
	        check[Integer.parseInt(str)] = true;
	        
	    }
	    
	    for(int idx = 0; idx < n; idx++){
	        st = new StringTokenizer(br.readLine());
	        
	        int num = Integer.parseInt(st.nextToken()); //질문한 숫자
	        int strike = Integer.parseInt(st.nextToken()); //스트라이크
	        int ball = Integer.parseInt(st.nextToken()); //볼
	        
	        
	        for(int m = 123; m < 988; m++){
	            if(check[m]){
	                //후보 숫자
	                int a1 = m / 100;
	                int a2 = (m / 10) % 10;
	                int a3 = m % 10;
	                //질문 숫자
	                int g1 = num / 100;
	                int g2 = (num / 10) % 10;
	                int g3 = num % 10;
	                
	                boolean[] present = new boolean[10];
	                present[a1] = true;
	                present[a2] = true;
	                present[a3] = true;
	                
	                
	                //자릿수와 숫자 같으면
	                int strikeCnt = 0;
	                if(a1 == g1) strikeCnt += 1;
	                if(a2 == g2) strikeCnt += 1;
	                if(a3 == g3) strikeCnt += 1;
	                
	                //존재 하면
	                int common = 0;
	                if(present[g1]) common += 1;
	                if(present[g2]) common += 1;
	                if(present[g3]) common += 1;
	                
	                int ballCnt = common - strikeCnt;
	                
	                if(strikeCnt != strike || ballCnt != ball){
	                    check[m] = false;
	                }
	                
	            }
	        }
	        
	    }
	    
	    int answer = 0;
	    for(int idx = 123; idx < 988; idx++){
	        if(check[idx]){
	            answer += 1;
	        }
	    }
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
}
