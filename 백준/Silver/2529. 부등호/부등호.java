import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int[] selectArr;
    static boolean[] vis;
    static String[] arr;
    static int[] max;
    static int[] min;
    static boolean first;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    
	    selectArr = new int[n + 1];
	    max = new int[n + 1];
	    min = new int[n + 1];
	    vis = new boolean[10];
	    
	    String str = br.readLine();
        arr = str.split(" ");
	    
	    func(0);
	    
	    for(int n : max){
	        bw.write(n+"");
	    }
	    bw.newLine();
	    for(int n : min){
	        bw.write(n+"");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep){
	    if(dep == n + 1){
	        
	        if(!first){
	            first = true;
    	        for(int i = 0; i < n + 1; i++){
    	            min[i] = selectArr[i];
    	        }	            
	        }
	        
	        for(int i = 0; i < n + 1; i++){
	            max[i] = selectArr[i];
	        }
	        
	        
	        return;
	    }
	    
	    
	    for(int i = 0; i < 10; i++){
	        if(vis[i]) continue;
	        
	        vis[i] = true;
	        selectArr[dep] = i;
	        
	        if(dep > 0){
	            if(arr[dep - 1].equals(">")){
	                if(selectArr[dep - 1] < selectArr[dep]){
	                    vis[i] = false;
	                    continue;
	                } 
	            }
	            else{
	                if(selectArr[dep - 1] > selectArr[dep]){
	                    vis[i] = false;
	                    continue;
	                }
	            }
	        }
	        
	        func(dep + 1);
	        vis[i] = false;
	    }
	    
	}
}
