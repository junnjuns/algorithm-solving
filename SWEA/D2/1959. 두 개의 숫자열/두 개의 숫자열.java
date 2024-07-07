import java.util.*;
import java.io.*;

public class Solution
{   
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t=0; t<test; t++){
	        bw.write("#"+(t+1)+" ");
	        st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        int[] arrA = new int[n];
	        int[] arrB = new int[m];
	        st = new StringTokenizer(br.readLine());
	        for(int i=0; i<n; i++){
	            arrA[i] = Integer.parseInt(st.nextToken());
	        }
	        st = new StringTokenizer(br.readLine());
	        for(int i=0; i<m; i++){
	            arrB[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        if(n <= m){
	            int max = Integer.MIN_VALUE;
	            for(int i=0; i<=m-n; i++){
	                int sum = 0;
	                for(int j=0; j<n; j++){
	                    sum += arrA[j] * arrB[i+j];
	                }
	                max = Math.max(max, sum);
	            }
	            bw.write(max+"");
	        }
	        else{
	            int max = Integer.MIN_VALUE;
	            for(int i=0; i<=n-m; i++){
	                int sum = 0;
	                for(int j=0; j<m; j++){
	                    sum += arrA[i+j] * arrB[j];
	                }
	                max = Math.max(max, sum);
	            }
	            bw.write(max+"");
	            
	        }
	        
	        bw.newLine();
	    }
	    
	    bw.flush();
	    bw.close();
	}
}
