import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static boolean[] vis;
    static ArrayList<int[]>[] list;
    static int ans;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[n+1];
        
        for(int i=1; i<n+1; i++){
            list[i] = new ArrayList<int[]>();
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            
            list[a].add(new int[] {b, len});
            list[b].add(new int[] {a, len});
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            vis = new boolean[n+1];
            BFS(a,b);
            bw.write(ans+"\n");
        }
        
        
        bw.flush();
        bw.close();
	}
	
	static void BFS(int start, int end){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {start, 0});
	    vis[start] = true;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        int cur = now[0];
	        int dis = now[1];
	        if(cur == end){
	            ans = dis;
	        }
	        
	        for(int i=0; i<list[cur].size(); i++){
	            if(vis[list[cur].get(i)[0]] == false){
	                vis[list[cur].get(i)[0]] = true;
	                dq.add(new int[] {list[cur].get(i)[0], list[cur].get(i)[1]+dis});
	            }
	        }
	    }
	}
	
}
