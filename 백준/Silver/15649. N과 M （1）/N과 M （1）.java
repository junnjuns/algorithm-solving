import java.util.*;
import java.io.*;

public class Main
{
    static int n, m;
    static int[] selectArr;
    static int[] elementArr;
    static boolean[] vis;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
	    
	    permut(0);
	    
	    
	    bw.flush();
	    bw.close();
	    
    }
    
    static void permut(int depth){
        if(depth == m){
            for(int value : selectArr){
                System.out.print(value+" ");
            }
            System.out.println();
            return;
        }

        for(int idx = 0; idx < n; idx++){
            if(vis[idx]) continue;
            
            vis[idx] = true;
            selectArr[depth] = elementArr[idx];
            permut(depth + 1);
            vis[idx] = false;
            
        }

    }
    

    
}