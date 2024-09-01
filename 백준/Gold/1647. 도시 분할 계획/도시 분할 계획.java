import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int nodeCnt;
    static int edgeCnt;
    static Edge[] edges;
    static int[] parents;
    static int maxValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        edges = new Edge[edgeCnt];

        for(int idx = 0; idx< edgeCnt; idx++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken()) - 1;
            int nodeB = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            edges[idx] = new Edge(nodeA, nodeB, cost);
        }

        Arrays.sort(edges);

        parents = new int[nodeCnt];
        for(int idx = 0; idx < nodeCnt; idx++){
            parents[idx] = idx;
        }

        long answer = 0;

        for(Edge edge : edges){
            if(union(edge.nodeA, edge.nodeB)){
                answer += edge.cost;
                maxValue = Math.max(maxValue, edge.cost);
            }
        }
        answer -= maxValue;
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }


    static boolean union(int nodeA, int nodeB){
        int aRoot = find(nodeA);
        int bRoot = find(nodeB);

        if(aRoot == bRoot){
            return false;
        }

        if(aRoot > bRoot){
            parents[aRoot] = bRoot;
        }
        else{
            parents[bRoot] = aRoot;
        }

        return true;
    }
    static int find(int node){
        if(parents[node] == node){
            return node;
        }
        return parents[node] = find(parents[node]);
    }
}
