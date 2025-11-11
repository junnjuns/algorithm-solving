import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int k;
    static int[] elementArr;
    static String[] selectArr;
    static boolean[] vis;
    static ArrayList<Integer> list = new ArrayList<>();
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
	    
	    n = Integer.parseInt(br.readLine());
	    k = Integer.parseInt(br.readLine());
	    
	    elementArr = new int[n];
	    selectArr = new String[k];
	    vis = new boolean[n];
	    
	    for(int i = 0; i < n; i++){
	        elementArr[i] = Integer.parseInt(br.readLine());
	    }
	    
	    func(0);
	    
	    bw.write(list.size()+"");
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep){
	    if(dep == k){
	        
	        StringBuilder sb = new StringBuilder();
	        
	        for(String c : selectArr){
	            sb.append(c);
	        }
	        
	        int num = Integer.parseInt(sb.toString());
	        if(!list.contains(num)){
	            
	            list.add(num);
	        }
	        
	        return;
	    }
	    
	    for(int i = 0; i < n; i++){
	        if(vis[i]) continue;
	        
	        vis[i] = true;
	        selectArr[dep] = elementArr[i]+"";
	        func(dep + 1);
	        vis[i] = false;
	    }
	}
}
