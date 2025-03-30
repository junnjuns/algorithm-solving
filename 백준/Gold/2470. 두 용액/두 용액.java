import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int[] arr;
    static int bestLeft, bestRight, bestSum;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
	    st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < n ; idx++){
		    arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		Arrays.sort(arr);
		bestLeft = 0;
		bestRight = n - 1;
		bestSum = arr[bestLeft] + arr[bestRight];
		
    	binary(0, n - 1);
		
		bw.write(arr[bestLeft]+" "+arr[bestRight]);
		
		bw.flush();
		bw.close();
	}
	
	static void binary(int left, int right){
	    if(left >= right){
	        
	        return;
	    }
	    
	    int sum = arr[left] + arr[right];
	    if(Math.abs(sum) < Math.abs(bestSum)){
	        bestLeft = left;
	        bestRight = right;
	        bestSum = sum;
	    }
	    
	    if(sum < 0){
	        binary(left + 1, right);
	    }
	    else{
	        binary(left, right - 1);
	    }
	   
	}
	
}
