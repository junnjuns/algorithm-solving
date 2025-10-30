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
    static boolean[] vis;
        
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
	    st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    elementArr = new int[n];
	    selectArr = new int[m];
	    
	    st = new StringTokenizer(br.readLine());
	    
	    for(int idx = 0; idx < n; idx++){
	        elementArr[idx] = Integer.parseInt(st.nextToken());
	        
	    }
	    vis = new boolean[n];
	    Arrays.sort(elementArr);
	    
        func(0, 0);
        
        
	    
	    bw.flush();
	    bw.close();
	    
    }
    
    static void func(int depth, int start) throws Exception {
        if(depth == m){
            for(int value : selectArr){
                bw.write(value+" ");
            }
            bw.newLine();
            return;
        }
        
        int before = -1;
        
        for(int idx = start; idx < n; idx++){
            if(before == elementArr[idx]) continue;
            
            before = elementArr[idx];
            vis[idx] = true;
            selectArr[depth] = elementArr[idx];
            func(depth + 1, idx + 1);
            vis[idx] = false;
        }
    
    }
    
}