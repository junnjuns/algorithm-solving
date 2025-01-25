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
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static int cityCnt;
    static int busCnt;
    static ArrayList<Node>[] list;
    static int[] prev;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    
	    cityCnt = Integer.parseInt(br.readLine());
	    busCnt = Integer.parseInt(br.readLine());
	    
	    list = new ArrayList[cityCnt + 1];
	    
	    for(int idx = 0; idx < cityCnt + 1; idx++){
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
	    
	    int result = dijk(from, to);
        
        int count = 0;	    
        int cur = to;
        
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
        while(cur != 0){
            dq.addFirst(cur); //스택처럼 저장
            cur = prev[cur];
            count += 1;
        }	    
	    
	    
	    bw.write(result+"\n");
	    bw.write(count+"\n");
	    while(dq.size() != 0){
	        bw.write(dq.poll()+" ");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static int dijk(int start, int end){
	    int[] dist = new int[cityCnt + 1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;	    
        
        prev = new int[cityCnt + 1];
        
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    pq.add(new Node(start, 0));
	    
	    
	    while(pq.size() != 0){
	        Node now = pq.poll();
	        
	        if(now.to == end){
	            break;
	        }
	        
	        if(now.cost > dist[now.to]){
	            continue;
	        }
	        
	        for(Node node : list[now.to]){
	            int next = node.to;
	            int cost = now.cost + node.cost;
	            
	            if(cost < dist[next]){
	                dist[next] = cost;
	                pq.add(new Node(next, cost));
	                prev[next] = now.to;
	            }
	        }
	        
	    }
	    
	    return dist[end];
	}
}
