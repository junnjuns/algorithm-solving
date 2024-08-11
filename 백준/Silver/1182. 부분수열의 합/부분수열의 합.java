import java.util.*;
import java.io.*;


public class Main
{   
    static int n,s,cnt;
    static int[] arr;
    static int[] ans;
    static boolean[] vis;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		
		if(s == 0){
		    bw.write(cnt-1+"");
		}
		else{
		    bw.write(cnt+"");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	static void DFS(int dep, int sum){
	    if(dep == n){
	        if(sum == s){
	            cnt++;
	        }
	        return;
	    }
	    
	    DFS(dep+1, sum);
	    DFS(dep+1, sum + arr[dep]);
	}
}
