

import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
        int num = Integer.parseInt(br.readLine());
        
        int len = (num + "").length();

        long res = 0;
        int p = 1;
        long answer = 0;
	    for(int idx = 1; idx < len; idx++){
	        res = 9 * p;
	        answer += res * idx;
	        p *= 10;
	        
	    }
	    
	    answer += (num - p + 1) * len;
	    
	    System.out.println(answer);
	    
	    
	    
	}
	
}
