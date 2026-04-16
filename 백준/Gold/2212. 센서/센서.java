// n 개의 센서
// k 개의 집중국


import java.util.*;
import java.io.*;


public class Main
{   
    
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int[] dist = new int[n - 1];
        
        for(int i = 0; i < n - 1; i++){
            dist[i] = arr[i + 1] - arr[i];
        }
        
        Arrays.sort(dist);
        int answer = 0;
        for(int i = 0; i < n - 1 - (k - 1); i++){
            answer += dist[i];
        }
        
        bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}