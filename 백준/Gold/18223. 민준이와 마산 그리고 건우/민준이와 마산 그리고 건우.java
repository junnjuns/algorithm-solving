import java.util.*;
import java.io.*;

public class Main
{   
    static int NodeCnt;
    static int EdgeCnt;
    static int Him;
    static ArrayList<Node>[] list;
    
    static class Node implements Comparable<Node>{
        int end;
        int cost;
        
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
        
    }
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    NodeCnt = Integer.parseInt(st.nextToken());
	    EdgeCnt = Integer.parseInt(st.nextToken());
	    Him = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[NodeCnt + 1];
	    
	    for(int idx = 1; idx < NodeCnt + 1; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
	    for(int idx = 0; idx < EdgeCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        
	        int start = Integer.parseInt(st.nextToken());
	        int end = Integer.parseInt(st.nextToken());
	        int cost = Integer.parseInt(st.nextToken());
	        
	        list[start].add(new Node(end, cost));
	        list[end].add(new Node(start, cost));
	    }
	    
	    String result = dijkstra(1, NodeCnt) == dijkstra(1, Him) + dijkstra(Him, NodeCnt) ? "SAVE HIM" : "GOOD BYE";
	    
	    bw.write(result);
	    
	    bw.flush();
	    bw.close();
	}
	
	static int dijkstra(int start, int end){
	    
	    int[] dist = new int[NodeCnt + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    
	    dist[start] = 0;
	    
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(start, 0));
	    
	    while(pq.size() != 0){
	        Node now = pq.poll();
	        
	        if(now.cost > dist[now.end]){
	            continue;
	        }
	        
	        for(Node node : list[now.end]){
	            int next = node.end;
	            int cost = now.cost + node.cost;
	            
	            if(cost < dist[next]){
	                dist[next] = cost;
	                pq.add(new Node(next, cost));
	            }
	        }
	    }
	    
	    return dist[end];
	}
	
}
