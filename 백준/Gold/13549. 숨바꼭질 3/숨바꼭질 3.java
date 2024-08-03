import java.util.*;
import java.io.*;

public class Main
{   
    static int start, target;
    static int[] vis = new int[100010];
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    start = Integer.parseInt(st.nextToken());
	    target = Integer.parseInt(st.nextToken());
	    Arrays.fill(vis, -1);
	    bfs(start);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	static void bfs(int s){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(s);
	    vis[s] = 0;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        
	        if(now == target){
	            answer = vis[now];
	            return;
	        }
	        
	        int move1 = now + 1;
	        int move2 = now - 1;
	        int move3 = now * 2;
	        
	        if(move3 >= 0 && move3 < vis.length){
	            if(vis[move3] == -1){
	                dq.add(move3);
	                vis[move3] = vis[now];
	            }
	            else{
	                vis[move3] = Math.min(vis[move3], vis[now]);
	            }
	        }
	        if(move1 >= 0 && move1 < vis.length){
	            if(vis[move1] == -1){
	                dq.add(move1);
	                vis[move1] = vis[now] + 1;
	            }
	            else{
	                vis[move1] = Math.min(vis[move1], vis[now] + 1);
	            }
	        }
	        if(move2 >= 0 && move2 < vis.length){
	            if(vis[move2] == -1){
	                dq.add(move2);
	                vis[move2] = vis[now] + 1;
	            }
	            else{
	                vis[move2] = Math.min(vis[move2], vis[now] + 1);
	            }
	        }   
	    }
	}
}
