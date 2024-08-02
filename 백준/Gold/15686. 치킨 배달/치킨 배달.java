import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] board;
	static boolean[] vis;
	static int[][] ans;
	static int res = Integer.MAX_VALUE;
	static ArrayList<int[]> list = new ArrayList<>();
	static ArrayList<int[]> person = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[m][2];
		
		
		board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if(board[i][j] == 2) {
					list.add(new int[] {i,j});
				}//치킨집 좌표
				else if(board[i][j] == 1) {
					person.add(new int[] {i,j});
				}
			}
		}
		vis = new boolean[list.size()];
		DFS(0,0);
		bw.write(res+"");
		bw.flush();
		bw.close();
	
	}
	
	static void DFS(int dep, int start) {
		if(dep == m) {
			int sum=0;
			
			for(int i=0; i<person.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<m; j++) {
					min = Math.min(min, Math.abs(person.get(i)[0] - ans[j][0]) + Math.abs(person.get(i)[1] - ans[j][1]) );
				}
				sum += min;
			}
		
			res = Math.min(res, sum);
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			if(vis[i] == false) {
				vis[i] = true;
				ans[dep][0] = list.get(i)[0];
				ans[dep][1] = list.get(i)[1];
				DFS(dep+1, i);
				vis[i] = false;
			}
		}
	}
}
