import java.util.*;
import java.io.*;




public class Main {
	
	static int digit;
	static int[] arr;
	static BufferedWriter bw;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
        digit = Integer.parseInt(br.readLine());
        arr = new int[digit];
        
        decimal(0, 0);
        
        
        bw.flush();
        bw.close();
    }
    static void decimal(int select, int now) throws Exception {
    
    	if(select == digit){
            
            for(int idx = 2; idx <= Math.sqrt(now); idx++){
        	    if(now % idx == 0){
        	       return;
        	    }
    	    }
            
    	    for(int i : arr){
    	        bw.write(i+"");
    	    }
    	    bw.newLine();
    	    return;
    	}
    	
        for(int idx = 2; idx <= Math.sqrt(now); idx++){
    	    if(now % idx == 0){
    	       return;
    	    }
    	}
    	
    	for(int idx = 0; idx < 10; idx++){
    	    if(select == 0){
    	        if(idx == 0 ||idx == 1 ||idx == 4 ||idx == 6 ||idx == 8 || idx == 9){
    	            continue;
    	        }
    	    }
    	    
    	        arr[select] = idx;
    	        decimal(select + 1, now*10 + idx);
    	}
    }
}
