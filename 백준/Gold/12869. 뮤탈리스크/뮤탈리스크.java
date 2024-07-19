import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n;
    static int[][][] vis = new int[61][61][61];
    static int[] dmg1 = {9,9,3,3,1,1};
    static int[] dmg2 = {3,1,9,1,9,3};
    static int[] dmg3 = {1,3,1,9,3,9};
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static int[] arr = new int[3];
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    
	    for(int idx = 0; idx < n; idx++){
	        arr[idx] = Integer.parseInt(st.nextToken());
	    } 
	    
	    bfs(arr[0], arr[1], arr[2]);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int var1, int var2, int var3){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {var1, var2, var3, 0});
	    vis[var1][var2][var3] = 1;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        if(now[0] == 0 && now[1] == 0 && now[2] == 0){
	            answer = now[3];
	            break;
	        }
	        
	        for(int k=0; k<6; k++){
	            int x = Math.max(0, now[0] - dmg1[k]);
	            int y = Math.max(0, now[1] - dmg2[k]);
	            int z = Math.max(0, now[2] - dmg3[k]);
	            
	            
	            if(vis[x][y][z] == 0){
	                dq.add(new int[] {x, y, z, now[3]+1});
	                vis[x][y][z] = 1;
	            }
	            
	        }
	    }
	}
}
