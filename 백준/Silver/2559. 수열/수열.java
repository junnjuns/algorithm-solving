

import java.util.*;
import java.io.*;

public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n, m;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        arr = new int[n + 1];
        
        for(int idx = 1; idx < n + 1; idx++){
            arr[idx] = arr[idx - 1] + Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MIN_VALUE;
        for(int idx = 0; idx < n + 1 - m; idx++){
            answer = Math.max(answer, arr[n - idx] - arr[n - idx - m]);
        }
        bw.write(answer +"");
	    bw.flush();
	    bw.close();
	    
    }
    
}