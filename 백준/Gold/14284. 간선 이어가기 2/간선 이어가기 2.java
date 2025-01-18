import java.util.*;
import java.io.*;

public class Main
{
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
    
    static int nodeCnt;
    static int edgeCnt;
    static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    nodeCnt = Integer.parseInt(st.nextToken());
	    edgeCnt = Integer.parseInt(st.nextToken());
	    
	    
	    list = new ArrayList[nodeCnt + 1];
	    
	    for(int idx = 1; idx < nodeCnt + 1; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
	    for(int idx = 0; idx < edgeCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        int node1 = Integer.parseInt(st.nextToken());
	        int node2 = Integer.parseInt(st.nextToken());
	        int cost = Integer.parseInt(st.nextToken());
	        
	        list[node1].add(new Node(node2, cost));
	        list[node2].add(new Node(node1, cost));
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int num1 = Integer.parseInt(st.nextToken());
	    int num2 = Integer.parseInt(st.nextToken());
	    
	    int answer = dijkstra(num1, num2);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	
	static int dijkstra(int start, int end){
	    
	    int[] dist = new int[nodeCnt + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    
	    dist[start] = 0;
	    
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(start, 0));
	    
	    while(pq.size() != 0){
	        Node now = pq.poll();
	        
	        if(now.cost > dist[now.end]){
	            continue;
	        }
	        
	        for(Node node :list[now.end]){
	            int next = node.end;
	            int cost = node.cost + now.cost;
	            
	            if(dist[next] > cost){
	                dist[next] = cost;
	                pq.add(new Node(next , cost));
	            }
	        }
	        
	    }
	    
	    return dist[end];
	}
}
