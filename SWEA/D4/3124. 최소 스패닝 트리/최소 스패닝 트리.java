import java.util.*;
import java.io.*;

//우선순위 큐에 저장할 객체는 필수적으로 Comparable Interface를 구현해야한다. => Edge를 가중치 기준으로 정렬한다.
//각각의 노드의 인접 리스트를 생성한다.
//인접리스트를 생성 후 간선의 정보를 넣는다.(노드, 가중치)
//인접리스트 완성
//Prim 알고리즘 수행
    //우선순위 큐에 Edge를 추가한다. (시작 지점)
    //우선순위 큐의 크기가 0이 될 때까지 반복문 실행
    //만약 방문한 노드이면 다음 큐를 확인한다.
    //만약 방문하지 않은 노드이면 큐에 추가 후 가중치를 추가한다.
    //방문하지 않은 노드의 인접 리스트를 확인한다.
        //인접 리스트 내부의 node가 아직 방문하지 않은 노드이면 우선 순위 큐에 추가한다.
//추가된 가중치의 총합을 반환한다.



public class Solution
{

    //간선의 정보 가중치 기준으로 정렬하기 위해 Comparable 사용
    static class Edge implements Comparable<Edge>{

        int node;
        int cost;

        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }

    }

    static int nodeCnt;
    static int edgeCnt;
    static ArrayList<Edge>[] list;
    static boolean[] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            nodeCnt = Integer.parseInt(st.nextToken());
            edgeCnt = Integer.parseInt(st.nextToken());

            list = new ArrayList[nodeCnt + 1];
            vis = new boolean[nodeCnt + 1];
            //각 노드마다의 인접 리스트 생성
            for(int idx = 0; idx <= nodeCnt; idx++){
                list[idx] = new ArrayList<>();
            }

            //간선의 정보 입력
            for(int idx = 0; idx < edgeCnt; idx++){
                st = new StringTokenizer(br.readLine());
                int nodeA = Integer.parseInt(st.nextToken());
                int nodeB = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list[nodeA].add(new Edge(nodeB, cost) );
                list[nodeB].add(new Edge(nodeA, cost));
            }

            //prim 알고리즘 수행, 시작은 1번 노드로 시작
            bw.write(prim(1)+"\n");

        }//테스트케이스 끝

        bw.flush();
        bw.close();
    }

    static long prim(int start){

        //우선 순위 큐 생성
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        long sum = 0;

        while(pq.size() != 0){
            Edge edge = pq.poll();
            int node = edge.node;
            int cost = edge.cost;

            //만약 이미 방문했으면 다음 큐를 확인한다.
            if(vis[node]) continue;

            vis[node] = true;
            sum += cost;

            for(Edge element : list[node]){
                //아직 연결 안했다면 우선순위 큐에 추가
                if(vis[element.node] == false){
                    pq.add(element);
                }
            }

        }
        return sum;
    }

}
