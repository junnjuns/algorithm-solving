import java.util.*;
import java.io.*;

public class Main {

	
	static int n,m;
	static int[] ans;
	static BufferedWriter bw;
	static boolean[] vis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[m];
		vis = new boolean[n+1];
		DFS(0);
		
		bw.flush();
		bw.close();
	}
	
	static void DFS(int dep) throws Exception{
		if(dep == m) {
			for(int i: ans) {
				bw.write(i+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=1; i<=n; i++) {
				ans[dep] = i;
				DFS(dep+1);
		}
	}
}
