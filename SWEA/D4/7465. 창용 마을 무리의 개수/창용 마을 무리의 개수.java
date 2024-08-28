import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

//사람의 수, 관계의 수 입력 받기
//서로소 집합 구현
	//경로 압축 !
//parent 배열 내 값을 Set에 추가한다.
//set의 크기 출력한다.


public class Solution {

	static int count;
	static int edge;
	static int[] parent;
	static int[] rank;
	
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int test = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= test; t++) {
			bw.write("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
			
			count = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			
			parent = new int[count];
			rank = new int[count];
			
			for(int idx = 0; idx < count; idx++) {
				parent[idx] = idx;
			} //Root 자신으로 입력
			
			
			for(int idx = 0; idx < edge; idx++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken()) - 1;
				int node2 = Integer.parseInt(st.nextToken()) - 1;
				
				union(node1, node2);
			}
			
			int answer = 0;
			
			for(int i = 0; i < count; i++) {
				if(parent[i] == i){
				    answer++;
				}
			}
			bw.write(answer+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	
	static int find(int person) {
		
		if(parent[person] == person) {
			return parent[person];
		}
		
		return parent[person] = find(parent[person]);
	}
	
	static void union(int personA, int personB) {
		int aRoot = find(personA);
		int bRoot = find(personB);
		
		
		if(aRoot == bRoot) {
			return;
		}
		
		
		if(rank[aRoot] < rank[bRoot]) {
			parent[aRoot] = bRoot;
		}
		else if(rank[aRoot] > rank[bRoot]){
			parent[bRoot] = aRoot;
		}
		else {
			parent[bRoot] = aRoot;
			rank[aRoot]++;
		}
		
	}
	
	
}
