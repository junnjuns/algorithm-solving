//스크린은 N 개
// M 칸 바구니


import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int bucketSize;
    static int cnt;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    
	    n = Integer.parseInt(st.nextToken());
	    bucketSize = Integer.parseInt(st.nextToken());
	    
	    cnt = Integer.parseInt(br.readLine());
	    
	    
	    int answer = 0;
	    int left = 1;
	    int right = bucketSize;
	    
	    for(int idx = 0; idx < cnt; idx++){
	        int drop = Integer.parseInt(br.readLine());
	        
	        if(right < drop){
	            answer += drop - right; 
	            left = drop - bucketSize + 1;
	            right = drop;
	        }
	        else if(left > drop){
	            answer += left - drop;
	            left = drop;
	            right = left + bucketSize - 1;
	        }
	        
	    }
	    
	    
	    bw.write(answer+"");
        	    
	    bw.flush();
	    bw.close();
	}
}
