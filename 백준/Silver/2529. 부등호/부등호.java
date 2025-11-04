import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int[] selectArr;
    static boolean[] vis;
    static String[] arr;
    static String max;
    static String min;
    static boolean first;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    
	    selectArr = new int[n + 1];
	    vis = new boolean[10];
	    
	    String str = br.readLine();
        arr = str.split(" ");
	    
	    func(0);
	    
	    bw.write(max+"\n"+min);
	    
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep){
	    if(dep == n + 1){
	        int res = 0;
	        
	        for(int i = 0; i < n; i++){
	            if(arr[i].equals(">")){
	                if(selectArr[i] < selectArr[i + 1]) return; //조건 충족 안되기에 종료
	            }
	            else{
	                if(selectArr[i] > selectArr[i + 1]) return; //조건 충족 안되기에 종료
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < n + 1; i++){
	            sb.append(selectArr[i]);
	        }
	        
	        if(!first){
	            first = true;
	            min = sb.toString();
	        }
	        
	        max = sb.toString();
	        return;
	    }
	    
	    
	    for(int i = 0; i < 10; i++){
	        if(vis[i]) continue;
	        
	        vis[i] = true;
	        selectArr[dep] = i;
	        func(dep + 1);
	        vis[i] = false;
	    }
	    
	}
}
