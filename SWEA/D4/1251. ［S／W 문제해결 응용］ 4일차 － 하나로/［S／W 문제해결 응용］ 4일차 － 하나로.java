import java.util.*;
import java.io.*;

//[Prim 알고리즘]
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
    static class Edge implements Comparable<Edge>{

        int node;
        double cost;

        public Edge(int node, double cost){
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return Double.compare(this.cost, o.cost);
        }

    }


    static int nodeCnt;
    static boolean[] vis;
    static int[][] nodes;
    static double rate;
    static ArrayList<Edge>[] list;
    static double answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            bw.write("#"+t+" ");

            //섬의 개수 입력
            nodeCnt = Integer.parseInt(br.readLine());

            //노드의 좌표를 담고있는 배열 생성
            nodes = new int[nodeCnt][2];

            //x좌표 입력
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < nodeCnt; idx++){
                nodes[idx][0] = Integer.parseInt(st.nextToken());
            }

            //y좌표 입력
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < nodeCnt; idx++){
                nodes[idx][1] = Integer.parseInt(st.nextToken());
            }

            //세율 입력
            rate = Double.parseDouble(br.readLine());

            list = new ArrayList[nodeCnt];

            for(int idx = 0; idx < nodeCnt; idx++){
                list[idx] = new ArrayList<Edge>();
            }


            //인접리스트 초기화 로직
            for(int start = 0; start < nodeCnt - 1; start++){
                for(int end = start + 1; end < nodeCnt; end++ ){

                    //간선의 cost 구하기
                    double cost =  rate * (Math.pow(nodes[start][0] - nodes[end][0], 2) + Math.pow(nodes[start][1] - nodes[end][1], 2));

                    list[start].add(new Edge(end, cost));
                    list[end].add(new Edge(start, cost));
                }
            }

            vis = new boolean[nodeCnt];
            answer = 0;
            //0번째 idx의 노드부터 prim 알고리즘 수행
            prim(0);

            bw.write(Math.round(answer)+"\n");
        }//테스트케이스 끝

        bw.flush();
        bw.close();
    }

    static void prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        double sum = 0;

        while(pq.size() != 0){
            Edge edge = pq.poll();

            int node = edge.node;
            double cost = edge.cost;

            if(vis[node]) continue;

            vis[node] = true;
            sum += cost;

            for(Edge e : list[node]){
                if(!vis[e.node]){
                    pq.add(e);
                }
            }

        }
        answer = sum;
    }

}
