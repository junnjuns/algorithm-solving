import java.util.*;
import java.io.*;


public class Main
{
    
    static int N;
    static int Q;
    static ArrayList<int[]>[] list;
    static boolean[] vis;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList[N + 1];
		
		for(int idx = 1; idx < N + 1; idx++){
		    list[idx] = new ArrayList<int[]>();
		}
		
		for(int idx = 0; idx < N - 1; idx++){
		    st = new StringTokenizer(br.readLine());
		    
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int usado = Integer.parseInt(st.nextToken());
		    
		    list[a].add(new int[] {b, usado});
		    list[b].add(new int[] {a, usado});
		}
		
		
		for(int idx = 0; idx < Q; idx++){
		    st = new StringTokenizer(br.readLine());
		    
		    int K = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken()); //영상
		    
		    vis = new boolean[N + 1];
		    int result = bfs(K, v);
		    
		    bw.write(result+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static int bfs(int K, int v){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(v);
	    vis[v] = true;
	    int cnt = 0;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        
	        for(int[] edge : list[now]){
	            
	            int node = edge[0];
	            int usado = edge[1];
	            
	            if(usado >= K && !vis[node]){
	                dq.add(node);
	                vis[node] = true;
	                cnt++;
	            }
	            
	        }
	    }
	    return cnt;
	}
}
