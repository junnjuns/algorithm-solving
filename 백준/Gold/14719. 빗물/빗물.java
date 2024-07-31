import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		
		int[]arr = new int[w];
		for(int i = 0; i < w; i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}

	    for(int i = 1; i < w-1; i++){
	        int left = 0;
	        int right = 0;
	        
	        for(int j = 0; j< i; j++){
	            left = Math.max(left , arr[j]);
	        }
	        
	        for(int j = i+1; j < w; j++){
	            right = Math.max(right, arr[j]);
	        }
	        
	        if(arr[i] < left && arr[i] < right){
	            answer += Math.min(left, right) - arr[i];
	        }
	    }
	    
	    bw.write(answer+"");
	    
		bw.flush();
		bw.close();
	}
}
