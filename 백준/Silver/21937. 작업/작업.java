import java.util.*;
import java.io.*;

public class Main
{
    static int nodeCnt;
    static int edgeCnt;
    static ArrayList<Integer>[] list;
    static int work;
    static int[] vis;
        
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[nodeCnt + 1];
        
        for(int i = 0; i < nodeCnt + 1; i++){
            list[i] = new ArrayList<>();
        }
        
        
        for(int i = 0 ; i < edgeCnt; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            
            //단 방향 그래프
            list[nodeB].add(nodeA);
        }
        
        work = Integer.parseInt(br.readLine());
        
        vis = new int[nodeCnt + 1];
        bw.write(bfs(work)+"");
        
	    bw.flush();
	    bw.close();
	}
	
	static int bfs(int start){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    int cnt = 0;
	    vis[start] = 1;
	    dq.add(start);
	    
	    while(!dq.isEmpty()){
	        int now = dq.poll();
	        
	        for(int node : list[now]){
	            if(vis[node] == 0){
	                vis[node] = 1;
	                dq.add(node);
	                cnt += 1;    
	            }
	            
	        }
	    }
	    return cnt;
	}
	
}
