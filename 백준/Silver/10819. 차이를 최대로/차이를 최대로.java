import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int[] arr;
    static int[] selectArr;
    static int answer;
    static boolean[] vis;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    
	    vis = new boolean[n];
	    selectArr = new int[n];
	    arr = new int[n];
	    for(int i = 0; i < n; i++){
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    func(0);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep){
	    if(dep == n){
	        int res = 0;
            for(int idx = 0; idx < n - 1; idx++){
                res += Math.abs(selectArr[idx] - selectArr[idx + 1]);
            }	        
	        answer = Math.max(answer, res);
	        return;
	    }
	    
	    
	    for(int i = 0; i < n; i++){
	        if(vis[i]) continue;
	       
	        vis[i] = true;
	        selectArr[dep] = arr[i];
	        func(dep + 1);
	        vis[i] = false;
	    }
	    
	}
}
