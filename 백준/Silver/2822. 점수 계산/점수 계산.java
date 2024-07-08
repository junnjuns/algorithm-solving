import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int[] arr = new int[8];
	    int[] res = new int[8];
	    for(int i=0; i<8; i++){
	        int n = Integer.parseInt(br.readLine());
	        arr[i] = n;
	        res[i] = n;
	    }
	    
	    Arrays.sort(res);
	    
	    int sum = 0;
	    for(int i=0; i<5; i++){
	        sum += res[7-i];
	    }
	    
	    
	    bw.write(sum+"\n");
	    int[] ans = new int[5];
	    for(int i=0; i<5; i++){
	        for(int j=0; j<8; j++){
	            if(res[7-i] == arr[j]){
	                ans[i] = j+1;
	                break;
	            }
	        }
	    }
	    
	    Arrays.sort(ans);
	    
	    for(int i : ans){
	        bw.write(i+" ");
	    }
	    
	    bw.flush();
	    bw.close();
	}
}
