import java.util.*;
import java.io.*;

public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static int m;
    static int[] selectArr;
    static int[] elementArr;
    static boolean[] vis;
    
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
	    st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    elementArr = new int[n];
	    selectArr = new int[m];
	    vis = new boolean[n];
	    
	    for(int idx = 0; idx < n; idx++){
	        elementArr[idx] = idx + 1;
	    }
	    
	    permut(0, 0);
	    
	    bw.flush();
	    bw.close();
	    
    }
    
    static void permut(int depth, int index) throws Exception{
        if(depth == m){
            for(int value : selectArr){
                bw.write(value+" ");
            }
            bw.newLine();
            return;
        }
        
        for(int idx = index; idx < n; idx++){
            if(vis[idx]) continue;
            
            vis[idx] = true;
            selectArr[depth] = elementArr[idx];
            permut(depth + 1, idx);
            vis[idx] = false;
        }
        
    }
    
}