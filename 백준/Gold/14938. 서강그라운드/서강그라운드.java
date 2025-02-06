import java.util.*;
import java.io.*;

public class Main{
    
    static int landCnt;
    static int range;
    static int loadCnt;
    static int[] land;
    static ArrayList<Node>[] list;
    
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
        
    }
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    landCnt = Integer.parseInt(st.nextToken());
	    range = Integer.parseInt(st.nextToken());
	    loadCnt = Integer.parseInt(st.nextToken());
	    
	    land = new int[landCnt + 1];
	    st = new StringTokenizer(br.readLine());
	    for(int idx = 0; idx < landCnt; idx++){
	        land[idx + 1] = Integer.parseInt(st.nextToken());
	    }
	    
	    list = new ArrayList[landCnt + 1];
	    for(int idx = 0; idx <= landCnt; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
	    for(int idx = 0; idx < loadCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        int loadA = Integer.parseInt(st.nextToken());
	        int loadB = Integer.parseInt(st.nextToken());
	        int cost = Integer.parseInt(st.nextToken());
	        
	        list[loadA].add(new Node(loadB, cost));
	        list[loadB].add(new Node(loadA, cost));
	    }
	    
	    
	    int answer = Integer.MIN_VALUE;
	    //모든 지역에서 시작해보기
	    for(int idx = 1; idx <= landCnt; idx++){
	        answer = Math.max(answer, dijk(idx));
	    }
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static int dijk(int start){
	    int[] dist = new int[landCnt + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[start] = 0; //자기자신 값도 포함해야 함
	    
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(start, 0));
	    int totalItems = 0;
	    
	    while(pq.size() != 0){
	        Node now = pq.poll();
	        
	        if(now.cost > range) continue;  
	        
	        if(now.cost > dist[now.to]){
	            continue;
	        }
	        
	        totalItems += land[now.to];
	        
	        for(Node node : list[now.to]){
	            int next = node.to;
	            int cost = node.cost + now.cost;
	            
	            if(cost < dist[next]){
	                dist[next] = cost;
	                pq.add(new Node(next, cost));
	            }
	            
	        }
	    }
	    return totalItems;
	}
}
