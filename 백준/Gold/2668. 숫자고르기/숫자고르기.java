import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int[] arr;
    static int[] vis;
    static ArrayList<Integer> list;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    n = Integer.parseInt(br.readLine());
	    
	    arr = new int[n + 1];
	    
	    for(int idx = 1; idx < n + 1; idx++){
	        arr[idx] = Integer.parseInt(br.readLine());
	    }
        
        vis = new int[n + 1];
        
        list = new ArrayList<>();
        
        for(int idx = 1; idx < n + 1; idx++){
            vis[idx] = 1;
            dfs(idx, idx);
            vis[idx] = 0;
            
        }        
	    
	    bw.write(list.size()+"");
	    
	    bw.newLine();
	    
	    Collections.sort(list);
	    for(int idx = 0; idx < list.size(); idx++){
	        bw.write(list.get(idx)+"\n");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static void dfs(int start , int pre){
	    
	    if(arr[start] == pre){
	        list.add(pre);
	    }
	    
	    if(vis[arr[start]] == 0){
            vis[arr[start]] = 1;
            dfs(arr[start], pre);
            vis[arr[start]] = 0;
	    }
	    
	}
}







