import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m,k,start;
	static LinkedList<Integer>[] list;
	static boolean[] vis;
	static boolean check;
	static BufferedWriter bw;
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[n+1];
		vis = new boolean[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		ans = new ArrayList<>();
		BFS(start);
		Collections.sort(ans);
		if(!check) {
			bw.write("-1");
		}
		else {
			for(int i : ans) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	static void BFS(int j) throws Exception {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(j);
		dq.add(0);
		vis[j] = true;
		
		while(dq.size() != 0) {
			int now = dq.poll();
			int cnt = dq.poll();
			
			if(cnt == k) {
				check = true;
				ans.add(now);
			}
			
			for(int i=0; i<list[now].size(); i++) {
				if(vis[list[now].get(i)] == false) {
					vis[list[now].get(i)] = true;
					dq.add(list[now].get(i));
					dq.add(cnt+1);
				}
			}
		}
	}
}

