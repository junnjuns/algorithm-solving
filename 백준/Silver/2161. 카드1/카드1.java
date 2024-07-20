import java.util.*;
import java.io.*;

public class Main
{   
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    
	    for(int i=0; i<n; i++){
	        dq.add(i+1);
	    }
	    
	    
	    while(dq.size() != 0){
	        bw.write(dq.poll()+" ");
	        if(dq.size() != 0){
	            int num = dq.poll();
	            dq.add(num);
	        }
	        
	    }
	    
	    bw.flush();
	    bw.close();
    }
}
