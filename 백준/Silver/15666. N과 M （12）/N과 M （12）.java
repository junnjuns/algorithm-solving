import java.util.*;
import java.io.*;

public class Main {

	
	static int n,m;
	static int[] ans;
	static BufferedWriter bw;
	static boolean[] vis;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ans = new int[m];
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		vis = new boolean[n];
		
		DFS(0, 0);
		
		bw.flush();
		bw.close();
	}
	
	static void DFS(int dep, int start) throws Exception{
		if(dep == m) {
			for(int i: ans) {
				bw.write(i+" ");
			}
			bw.newLine();
			return;
		}
		
		int pre = -1;
		for(int i=start; i<n; i++) {
			if(pre == arr[i]) continue;
				vis[i] = true;
				pre = arr[i];
				ans[dep] = arr[i];
				DFS(dep+1, i);
				vis[i] = false;
		}
	}
}
