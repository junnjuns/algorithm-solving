import java.util.*;
import java.io.*;

public class Main {
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
    static int[] dist;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());
        
        dist = new int[nodeCnt + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        
        list = new ArrayList[nodeCnt + 1];
        for(int idx = 0; idx < nodeCnt + 1; idx++){
            list[idx] = new ArrayList<>();
        }
        
        for(int idx = 0; idx < edgeCnt; idx++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            list[nodeA].add(new Node(nodeB, cost));
            list[nodeB].add(new Node(nodeA, cost));
        }
        
        
        bw.write(dijk(1)+"");
        
        bw.flush();
        bw.close();
    }
    static int dijk(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        dist[start] = 0;
        
        while(pq.size() != 0){
            Node node = pq.poll();
            
            if(node.cost > dist[node.end]){
                continue;
            }
            
            
            for(Node n : list[node.end]){
                if(node.cost + n.cost < dist[n.end]){
                    pq.add(new Node(n.end, node.cost + n.cost));
                    dist[n.end] = node.cost + n.cost;
                }
            }
        }
    
        return dist[nodeCnt];
    }
    
    
}
