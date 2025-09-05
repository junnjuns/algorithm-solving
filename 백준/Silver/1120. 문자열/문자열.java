
import java.util.*;
import java.io.*;

public class Main
{   
    
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    String strA = st.nextToken();
	    String strB = st.nextToken();
	       
	    int answer = Integer.MAX_VALUE;
	    
	    for(int idx = 0; idx <= (strB.length() - strA.length()); idx++){
	        int cnt = 0;
	        
	        for(int j = 0; j < strA.length(); j++){
	            if(strA.charAt(j) != strB.charAt(idx + j)){
	                cnt += 1;
	            }
	        }
	        answer = Math.min(answer, cnt);
	    }
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
}
