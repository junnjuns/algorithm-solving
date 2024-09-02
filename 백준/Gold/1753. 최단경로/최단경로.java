import java.util.*;
import java.io.*;

public class Main {

    //node 클래스
    static class Node implements Comparable<Node>{

        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int nodeCnt;
    static int edgeCnt;
    static int start;
    static ArrayList<Node>[] nodes;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken()); //node의 개수
        edgeCnt = Integer.parseInt(st.nextToken()); //edge의 개수
        start = Integer.parseInt(br.readLine()) - 1; //시작 노드

        nodes = new ArrayList[nodeCnt];
        //인접 리스트
        for(int idx = 0; idx < nodeCnt; idx++){
            nodes[idx] = new ArrayList<Node>();
        }

        //인접 리스트 초기화
        for(int idx = 0; idx < edgeCnt; idx++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken()) - 1;
            int nodeB = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            nodes[nodeA].add(new Node(nodeB, cost));
        }

        //미 방문 지점 max값으로 초기화
        dist = new int[nodeCnt];
        for(int idx = 0; idx < nodeCnt; idx++){
            dist[idx] = Integer.MAX_VALUE;
        }

        //다익스트라 알고리즘 메서드
        Dijkstra();

        for(int value : dist){
            if(value == Integer.MAX_VALUE){
                bw.write("INF\n");
            }
            else{
                bw.write(value+"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작 노드, 값은 0부터 시작
        pq.add(new Node(start, 0));

        // 해당 노드를 선택한 것이나 마찬가지 이므로 0으로 초기화
        dist[start] = 0;

        while (pq.size() != 0){
            // 목표 정점이 꺼내 졌다면 해당 노드까지는 최솟값 갱신이 완료 되었다는 것이 확정이다(다익스트라 알고리즘)
            Node now = pq.poll();

            int node = now.node;
            int cost = now.cost;

            // 꺼낸 노드 == 현재 최소 비용을 갖는 노드이다.
            // 즉, 해당 노드의 비용이 현재 dist 배열에 기록된 내용보다 크다면 고려할 필요가 없으므로 스킵한다.
            if(dist[node] < cost){
                continue;
            }

            for(Node nextNode : nodes[node]){
                if(dist[nextNode.node] > nextNode.cost + cost){
                    dist[nextNode.node] = nextNode.cost + cost;
                    //cost를 추가한 값 으로 우선순위 큐에 다음 요소를 추가한다.
                    pq.add(new Node(nextNode.node, dist[nextNode.node]));
                }
            }

        }

    }
}
