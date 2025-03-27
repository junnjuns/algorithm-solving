import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int m;
    static int[] arrA;
    static int[] arrB;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    arrA = new int[n];
	    for(int idx = 0; idx < n; idx++){
	        arrA[idx] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arrA);
	    
	    m = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    arrB = new int[m];
        for(int idx = 0; idx < m; idx++){
	        arrB[idx] = Integer.parseInt(st.nextToken());
	        
	        binary(0, n -1, arrB[idx]);
	    }
        
	}
	static void binary(int left, int right, int target){
	    if(left >= right){
	        
	        if(arrA[left] == target){
	            System.out.print("1 ");
	        }
	        else{
	            System.out.print("0 ");
	        }
	        return;
	    }
	    
	    
	    int mid = left + (right - left) / 2;
	    
	    if(target <= arrA[mid]){
	        binary(left , mid , target);
	    }
	    else{
	        binary(mid + 1 , right, target);
	    }
	    
	}
}
