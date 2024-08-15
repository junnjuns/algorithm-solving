import java.util.*;
import java.io.*;


public class Main
{   
    
    static int food;
    static int[][] taste;
    static boolean[] vis;
    static int min;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    food = Integer.parseInt(br.readLine());
	    taste = new int[food][2];
	    vis = new boolean[food];
	    
	    for(int idx = 0; idx < food; idx++){
	        st = new StringTokenizer(br.readLine());
	        taste[idx][0] = Integer.parseInt(st.nextToken());
	        taste[idx][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    min = Integer.MAX_VALUE;
	    powerSet(0, 1, 0);
	    
	    bw.write(min+"");
	    bw.flush();
	    bw.close();
	}
	
	static void powerSet(int dep, int sour, int bitter){
	    if(dep == food){
	        if(sour == 1 && bitter == 0){
	            return;
	        }
	        min = Math.min(min, Math.abs(sour - bitter));
	        return;
	    }
	    vis[dep] = true;
	    powerSet(dep + 1, sour * taste[dep][0], bitter + taste[dep][1]);
	    vis[dep] = false;
	    powerSet(dep + 1, sour, bitter);
	}
}
