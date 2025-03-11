import java.util.*;  
import java.io.*;    


//0 a b  -> a와 b를 합쳐라
//1 a b  -> a와 b가 같은 집합에 포함되어 있는지 확인해라

//자기 자신을 부모로 하는 배열 생성


public class Main {
	
	static int n;
	static int m;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        parents = new int[n + 1];
        for(int idx = 0; idx < n + 1; idx++) {
        	parents[idx] = idx;
        }
        
        
        for(int idx = 0; idx < m; idx++) {
        	st = new StringTokenizer(br.readLine());
        	int order = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	//합집합 연산 수행
        	if(order == 0) {
        		union(a, b);
        	}
        	
        	else {
        		bw.write(find(a) == find(b) ? "YES\n" : "NO\n");
        	}
        	
        }
        
        bw.flush();
        bw.close();
    }
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return;
		}
		
		if(rootA > rootB) {
			parents[rootA] = rootB;
		}
		else {
			parents[rootB] = rootA;
		}
		
	}
	
	static int find(int node) {
		if(node == parents[node]) {
			return node;
		}
		return parents[node] = find(parents[node]);
	}
}