import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int answer = Integer.MAX_VALUE;
    static String num;
    static StringBuilder sb;
    static char[] elementArr;
    static char[] selectArr;
    static boolean[] vis;
    static boolean check;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    num = br.readLine();
	    n = Integer.parseInt(num);
	    elementArr = new char[num.length()];
	    selectArr = new char[num.length()];
	    vis = new boolean[num.length()];
	    
	    for(int i = 0; i < num.length(); i++){
	        elementArr[i] = num.charAt(i);
	    }
	    
	    
	    func(0);
	    
	    answer = answer == Integer.MAX_VALUE ? 0 : answer;
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep){
	    if(dep == num.length()){
	        
	        sb = new StringBuilder();
	        for(char ch : selectArr){
	            sb.append(ch);
	        }
	        
	        if(n < Integer.parseInt(sb.toString())){
	            answer = Math.min(answer, Integer.parseInt(sb.toString()));
	        }
	        
	        return;
	    }
	    
	   	    
	    for(int i = 0; i < num.length(); i++){
	        if(vis[i]) continue;
	        
	        vis[i] = true;
	        selectArr[dep] = elementArr[i];
	        func(dep + 1);
	        vis[i] = false;
	    }
	}
	
}
