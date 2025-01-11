import java.util.*;
import java.io.*;

public class Main
{   
    
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
        
    static int NodeCnt;
    static int busCnt;
    static ArrayList<Node> list[];
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    NodeCnt = Integer.parseInt(br.readLine());
	    busCnt = Integer.parseInt(br.readLine());
	    
	    list = new ArrayList[NodeCnt + 1];
	    
	    for(int idx = 1; idx < NodeCnt + 1; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
	    for(int idx = 0; idx < busCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        
	        int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
	        int cost = Integer.parseInt(st.nextToken());
	        
	        list[from].add(new Node(to, cost));
	        
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    
	    int from = Integer.parseInt(st.nextToken());
	    int to = Integer.parseInt(st.nextToken());
	    
	    
	    int result = dijkstra(from, to);
	    
	    bw.write(result+"");
	    bw.flush();
	    bw.close();
	}
	
	static int dijkstra(int start, int end){
	    
	    int[] dist = new int[NodeCnt + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE); //최댓값으로 모두 초기화
	    
	    dist[start] = 0;
	    
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(start, 0));
	    
	    
	    while(pq.size() != 0){
	        Node now = pq.poll();
	        
	        if(now.cost > dist[now.to]){
	            continue;
	        }
	        
	        for(Node node : list[now.to]){
	            int next = node.to;
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
