import java.util.*;
import java.io.*;

public class Main
{   
    
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    String str = br.readLine();
	    
	    int answer = 0;
	    
	    int zero = 0;
	    int one = 0;
	    boolean flagA = false;
	    boolean flagB = false;
	    
	    for(int idx = 0; idx <str.length(); idx++){
	        char ch = str.charAt(idx);
	        
	        if(ch == '0'){
	            flagB = false;
	            if(!flagA){
    	            zero += 1;
    	            flagA = true;    
	            }
	            
	        }
	        else if(ch == '1'){
	            flagA = false;
	            if(!flagB){
	                one += 1;
	                flagB = true;
	            }
	        }
	    }
	    
	    answer = Math.min(zero, one);
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
}
