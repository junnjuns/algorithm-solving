import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    for(int test = 0; test < 10; test++){
	        br.readLine();
	        bw.write("#"+(test+1)+" ");
	        
	        ArrayDeque<Integer> dq = new ArrayDeque<>();
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int idx = 0; idx < 8; idx++){
	            int num = Integer.parseInt(st.nextToken());
	            dq.add(num);
	        }
	        
	        loop:
	        while(true){
	            
	            for(int idx = 1; idx <=5; idx++){
	                int curNum = dq.poll();
	                curNum -= idx;
	                if(curNum <= 0){
	                    dq.add(0);
	                    break loop;
	                }
	                else{
	                    dq.add(curNum);
	                }
	                
	            }
	        }
	        
	        while(dq.size() != 0){
	            bw.write(dq.poll()+" ");
	        }
	        bw.newLine();
	    }
	    bw.flush();
	    bw.close();
	}	
}
