import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[][] arr = new int[n][m];
	    
	    for(int h = 0; h < n; h++){
	        st = new StringTokenizer(br.readLine());
	        for(int w = 0; w < m; w++){
	            arr[h][w] = Integer.parseInt(st.nextToken());
	        }
	    }
	    

	    int k = Integer.parseInt(br.readLine());
	    
	    for(int i = 0; i < k; i++){
	        st = new StringTokenizer(br.readLine());
	        int s1 = Integer.parseInt(st.nextToken())-1;
	        int s2 = Integer.parseInt(st.nextToken())-1;
	        
	        int e1 = Integer.parseInt(st.nextToken())-1;
	        int e2 = Integer.parseInt(st.nextToken())-1;
	        
	        int sum = 0;
	        if(s1 == e1){
	            for(int j = s2; j <= e2; j++){
	                sum += arr[s1][j];
	            }
	        }
	        else{
	                
	           for(int q = s2; q <= e2; q++){
	               sum += arr[s1][q];
	           }
	           
	           for(int q = s1+1; q < e1; q++){
	               
	               for(int p = s2; p <= e2; p++){
	                    sum += arr[q][p];    
	               }
	               
	           }
	           
	           for(int q = s2; q <= e2; q++){
	               sum += arr[e1][q];
	           }
	        }
	        
	        bw.write(sum+"\n");
	    }
	    
	    bw.flush();
	    bw.close();
	}
}
