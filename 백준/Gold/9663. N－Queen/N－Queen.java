

import java.util.*;
import java.io.*;

public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static boolean[] rowVis;
    static boolean[] downVis;
    static boolean[] upVis;
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    rowVis = new boolean[n];
	    downVis = new boolean[n * 2 - 1];
	    upVis  = new boolean[n * 2 - 1];
	    
	    
	    func(0);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	    
    }
    
    static void func(int depth){
        if(depth == n){
            answer += 1;
            return;
        }
        
        
        for(int idx = 0; idx < n; idx++){
            if(rowVis[idx] || downVis[depth - idx + n - 1] || upVis[depth + idx])
                continue;
            
            rowVis[idx] = true;
            downVis[depth - idx + n - 1] = true;
            upVis[depth + idx] = true;
            
            func(depth + 1);
            
            rowVis[idx] = false;
            downVis[depth - idx + n - 1] = false;
            upVis[depth + idx] = false;            
        }
        
    }
    
}