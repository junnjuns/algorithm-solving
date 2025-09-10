import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    String str = br.readLine();
	    
	    int[] arr = new int[str.length()];
	    
	    boolean check = false;
	    for(int idx = 0; idx < arr.length; idx++){
	        arr[idx] = str.charAt(idx) - '0';
	        if(arr[idx] == 0){
	            check = true;
	        }
	    }
	    
	    if(check){
	        int sum = 0;
	        for(int n : arr){
	            sum += n;
	        }
	        if(sum % 3 == 0){
	            Arrays.sort(arr);
	            for(int idx = arr.length - 1; idx >=0; idx--){
	                bw.write(arr[idx]+"");
	            }
	        }
	        else{
	            bw.write("-1");
	        }
	    }
	    else{
	        bw.write("-1");
	    }
	    
	    
	    bw.flush();
	    bw.close();
	}
}

