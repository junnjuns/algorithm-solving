import java.util.*;
import java.io.*;

public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static int m;
    static int[] elementArr;
    static int[] selectArr;
    
    
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
	    st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    elementArr = new int[n];
	    selectArr = new int[m];
	    
	    for(int idx = 0; idx < n; idx++){
	        elementArr[idx] = idx + 1;
	    }
	    
        func(0);
        
        
	    
	    bw.flush();
	    bw.close();
	    
    }
    
    static void func(int depth) throws Exception {
        if(depth == m){
            for(int value : selectArr){
                bw.write(value+" ");
            }
            bw.newLine();
            return;
        }
        
        for(int idx = 0; idx < n; idx++){
            
            selectArr[depth] = elementArr[idx];
            func(depth + 1);
            
        }
    
    }
    
}