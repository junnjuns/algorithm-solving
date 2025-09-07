import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int num = 0;
	    int max = 0;
	    
	    for(int idx = 1; idx <= 5; idx++){
	        st = new StringTokenizer(br.readLine());
	        int sum = 0;
	        
	        for(int i = 0; i < 4; i++){
	            sum += Integer.parseInt(st.nextToken());
	        }
	        
	        if(max < sum){
	            num = idx;
	            max = sum;
	        }
	    }
	    bw.write(num+" "+max);
	    bw.flush();
	    bw.close();
	    
	}
}
