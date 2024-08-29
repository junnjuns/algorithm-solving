import java.util.*;
import java.io.*;


//테스트 케이스 수 입력
	//각 케이스 마다 정점의 개수, 간선의 개수 입력받음
	// 간선의 개수만큼 노드1, 노드2, 가중치 입력 받기
	// 간선 배열을 가중치 기준으로 내림차순
	// 간선 배열을 돌면서 union 연산이 가능하다면 가중치 추가
	//추가된 가중치 출력

public class Solution {

	static class Edge implements Comparable<Edge>{
		
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int nodeCnt;
	static int edgeCnt;
	static Edge[] edges;
	static int[] parents;
	
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int test = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= test; t++) {
			bw.write("#" + t + " ");
			
			//각 케이스 마다 정점의 개수, 간선의 개수 입력받음
			st = new StringTokenizer(br.readLine());
			nodeCnt = Integer.parseInt(st.nextToken());
			edgeCnt = Integer.parseInt(st.nextToken());
			
			edges = new Edge[edgeCnt];
			
			
			// 간선의 개수만큼 노드1, 노드2, 가중치 입력 받기
			for(int idx = 0; idx < edgeCnt; idx++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken()) - 1;
				int node2 = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				
				edges[idx] = new Edge(node1, node2, weight);
			}
			
			
			// 간선 배열을 가중치 기준으로 내림차순
			Arrays.sort(edges);
			
			make();
			
			long min = 0;
			for(Edge edge : edges) {
				if(union(edge.start, edge.end)) {
					min += edge.weight;
				}
			}
			
			bw.write(min+"\n");
		} //테스트 케이스 끝
		
		
		bw.flush();
		bw.close();
	}
	
	//초기 집합의 조상을 저장하는 parents 생성 및 초기화
	static void make() {
		parents = new int[nodeCnt];
		for(int idx = 0; idx < nodeCnt; idx++) {
			parents[idx] = idx;
		}
	}
	
	//두 집합이 합쳐질 수 있는지 판단 후 가능하면 합집합
	static boolean union(int nodeA, int nodeB) {
		int aRoot = find(nodeA);
		int bRoot = find(nodeB);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		if(aRoot > bRoot) {
			parents[aRoot] = bRoot;
		}
		else {
			parents[bRoot] = aRoot;
		}
		return true;
	}
	
	//node의 조상 찾음
	static int find(int node) {
		
		if(parents[node] == node) {
			return node;
		}
		return parents[node] = find(parents[node]);
	}
	
	
}
