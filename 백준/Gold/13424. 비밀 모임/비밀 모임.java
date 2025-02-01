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
    
    static int roomCnt;
    static int loadCnt;
    static ArrayList<Node>[] list;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t = 0; t < test; t++){
	        st = new StringTokenizer(br.readLine());
	        
	        roomCnt = Integer.parseInt(st.nextToken());
	        loadCnt = Integer.parseInt(st.nextToken());
	        
	        list = new ArrayList[roomCnt + 1];
	        
	        for(int idx = 0; idx < roomCnt + 1; idx++){
	            list[idx] = new ArrayList<>();
	        }
	        
	        for(int idx = 0; idx < loadCnt; idx++){
	            st = new StringTokenizer(br.readLine());
	            int roomA = Integer.parseInt(st.nextToken());
	            int roomB = Integer.parseInt(st.nextToken());
	            int cost = Integer.parseInt(st.nextToken());
	            
	            list[roomA].add(new Node(roomB, cost));
	            list[roomB].add(new Node(roomA, cost));
	        }
	        
	        int personCnt = Integer.parseInt(br.readLine());
	        int[] personPosition = new int[personCnt];
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int idx = 0; idx < personCnt; idx++){
	            personPosition[idx] = Integer.parseInt(st.nextToken());
	        }
	        
	        int[] roomCost = new int[roomCnt + 1];
	        for(int person = 0; person < personCnt; person++){
	            int[] dist = dijkstra(personPosition[person]);
    	        for(int room = 1; room < roomCnt + 1; room++){
    	            
	                roomCost[room] += dist[room];
	            }	            
	        }
	        
	        int min = Integer.MAX_VALUE;
	        int answer = 0;
            for(int room = 1; room < roomCnt + 1; room++){
                if(roomCost[room] < min){
                    min = roomCost[room];
                    answer = room;
                }
            }
            
            bw.write(answer+"\n");
	    } //테스트 끝
	    
	    bw.flush();
	    bw.close();
	}
	
	static int[] dijkstra(int start){
	    int[] dist = new int[roomCnt + 1];
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
	    
	    return dist;
	}
}
