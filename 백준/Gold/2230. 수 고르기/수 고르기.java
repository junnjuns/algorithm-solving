import java.util.*;
import java.io.*;


public class Main
{   
    
    static int n; // 수열의 개수
    static int m; // 기준 값
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // m 보다 크면서, 최소인 값
        
        arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        } // 초기화
        
        Arrays.sort(arr);
        
        
        int left = 0;
        int right = 0;
        int now = 0;
        int answer = Integer.MAX_VALUE;
        
        while(left < n && right < n){
            now = arr[right] - arr[left];
                
            if(now < m){
                right += 1;
            }
            else if(now >= m){
                left += 1;
                answer = Math.min(answer, now);
            }
            
        }
        
        bw.write(answer + "");
		bw.flush();
		bw.close();
	}
	
	
}