import java.util.*;
import java.io.*;

public class Main
{   
    static int nodeCnt;
    static int edgeCnt;
    static int startNode;
    static ArrayList<Integer>[] list;
    static int[] vis;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    nodeCnt = Integer.parseInt(st.nextToken());
	    edgeCnt = Integer.parseInt(st.nextToken());
	    startNode = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[nodeCnt + 1];
	    for(int idx = 0; idx < nodeCnt + 1; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
	    vis = new int[nodeCnt + 1];
	    Arrays.fill(vis, -1);
	    
	    
	    for(int idx = 0; idx < edgeCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        int nodeA = Integer.parseInt(st.nextToken());
	        int nodeB = Integer.parseInt(st.nextToken());
	        
	        list[nodeA].add(nodeB);
	        list[nodeB].add(nodeA);
	    }
	    
	    bfs(startNode);
	    
	    for(int idx = 1; idx < nodeCnt + 1; idx++){
	        bw.write(vis[idx]+"\n");
	    }
	    
	    
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int startNode){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(startNode);
	    vis[startNode] = 0;
	    
	    while(!dq.isEmpty()){
	        int now = dq.poll();
	        
	        for(int next : list[now]){
	            if(vis[next] == -1){
    	            dq.add(next);
    	            vis[next] = vis[now] + 1;    
	            }
	            
	        }
	        
	    }
	}
	
}
