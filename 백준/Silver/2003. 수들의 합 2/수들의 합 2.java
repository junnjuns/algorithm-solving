

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
        m = Integer.parseInt(st.nextToken()); // 목표 하는 수
        
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int idx = 0; idx < n; idx++){
            arr[idx] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        
        while(true){
            if(left == n || right == n) break;
            int num = 0;
            for(int idx = left; idx <= right; idx++){
                num += arr[idx];
            }
            
            if(num == m){
                answer += 1;
                left += 1;
                right += 1;
            }
            else if(num < m){
                right += 1;
            }
            else if(num > m){
                left += 1;
            }
            else if(left == right && num > m){
                left += 1;
                right += 1;
            }
        }
        
        bw.write(answer+"");
	    bw.flush();
	    bw.close();
	    
    }
    
}