import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int[] selectArr;
    static int[] elementArr;
    static boolean[] vis;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
	    
	    n = Integer.parseInt(br.readLine());
	    
	    elementArr = new int[n];
	    selectArr = new int[n];
	    vis = new boolean[n];
	    
	    for(int i = 0; i < n; i++){
	        elementArr[i] = i + 1;
	    }
	    
	    func(0);
	    
	    
	    
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep) throws Exception {
	    if(dep == n){
	        
	        for(int num : selectArr){
	            bw.write(num+" ");
	        }
	        bw.newLine();
	        return;
	    }
	    
	    
	    for(int i = 0; i < n; i++){
	        if(vis[i]) continue;
	        
	        vis[i] = true;
	        selectArr[dep] = elementArr[i];
	        func(dep + 1);
	        vis[i] = false;
	    }
	}
	
}
