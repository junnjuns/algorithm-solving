import java.util.*;
import java.io.*;

public class Main{
    static int U;
    static int D;
    static int G;
    static int F;
    static int S;
    static int res;
    static boolean[] vis;
    static boolean check;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    F = Integer.parseInt(st.nextToken());
	    S = Integer.parseInt(st.nextToken());
	    G = Integer.parseInt(st.nextToken());
	    U = Integer.parseInt(st.nextToken());
	    D = Integer.parseInt(st.nextToken());
	    vis = new boolean[F+1];
	    BFS(S);
	    if(check){
	        bw.write(res+"");
	    }
	    else{
	        bw.write("use the stairs");
	    }
	    bw.flush();
	    bw.close();
	}
	static void BFS(int i){
	    check = false;
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(i);
	    dq.add(0);
	    vis[i] = true;
	    while(dq.size() != 0){
	        int now = dq.poll();
	        int cnt = dq.poll();
	        if(now == G){
	            check = true;
	            res = cnt;
	            break;
	        }
	        int var1 = now + U;
	        int var2 = now - D;
	        if(var1 <= F){
	            if(vis[var1] == false){
	                dq.add(var1);
	                dq.add(cnt+1);
	                vis[var1] = true;
	            }
	        }
	        if(var2 > 0){
	            if(vis[var2] == false){
	                dq.add(var2);
	                dq.add(cnt+1);
	                vis[var2] = true;
	            }
	        }
	    }
	}
}
