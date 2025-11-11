import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int[] elementArr;
    static int[] calArr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    elementArr = new int[n];
	    calArr = new int[4];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < n; i++){
	        elementArr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < 4; i++){
	        calArr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    func(1, elementArr[0]);
	    
	    bw.write(max+"\n"+min);
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep, int value){
	    if(dep == n){
	        max = Math.max(max, value);
	        min = Math.min(min, value);
	        
	        return;
	    }
	    
	    
	        for(int j = 0; j < 4; j++){
	            if(calArr[j] == 0) continue;
	            
	            calArr[j] -= 1;
	            
	            if(j == 0){
	                func(dep + 1, value + elementArr[dep]);
	            }
	            else if(j == 1){
	                func(dep + 1, value - elementArr[dep]);
	            }
	            else if(j == 2){
	                func(dep + 1, value * elementArr[dep]);
	            }
	            else if(j == 3){
	                func(dep + 1, value / elementArr[dep]);
	            }
	            
	            calArr[j] += 1;
	            
	        }
	    
	}
	
}
