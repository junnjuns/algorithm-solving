import java.util.*;
import java.io.*;

public class Main
{
    static int n, res;
    static int[] elementArr;
    static boolean[] vis;
    static int answer;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    res = Integer.parseInt(st.nextToken());
	    
	    elementArr = new int[n];
	    vis = new boolean[n];
	    
	    st = new StringTokenizer(br.readLine());
	    
	    for(int idx = 0; idx < n; idx++){
	        elementArr[idx] = Integer.parseInt(st.nextToken());
	    }
	    
	    subset(0, 0);
	    
	    if(res == 0){
	        answer -= 1;
	    }
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	    
    }

    static void subset(int depth, int sum){
        if(depth == n){
            if(sum == res){
                answer += 1;
            }
            return;
        }
        
        subset(depth + 1, sum + elementArr[depth]);
        
        subset(depth + 1, sum);
        
    }
    
}