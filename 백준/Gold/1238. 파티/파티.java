import java.util.*;
import java.io.*;

public class Main{
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
    static int personCnt;
    static int party;
    static int loadCnt;
    static ArrayList<Node>[] list;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    personCnt = Integer.parseInt(st.nextToken());
	    loadCnt = Integer.parseInt(st.nextToken());
	    party = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[personCnt + 1];
	    
	    for(int idx = 1; idx < personCnt + 1; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
        for(int idx = 0; idx < loadCnt; idx++){
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            list[person1].add(new Node(person2, cost));
        }	    
        
        int answer = 0;
        for(int idx = 1; idx < personCnt + 1; idx++){
            answer = Math.max(answer, dijk(idx, party) + dijk(party, idx));
        }
        
        bw.write(answer+"");
	    
	    bw.flush();
	    bw.close();
	}
	static int dijk(int start, int end){
	    
	    int[] dist = new int[personCnt + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    
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
	            int cost = node.cost + now.cost;
	            
	            if(cost < dist[next]){
	                dist[next] = cost;
	                pq.add(new Node(next, cost));
	            }
	        }
	    }
	    return dist[end];
	}
}
