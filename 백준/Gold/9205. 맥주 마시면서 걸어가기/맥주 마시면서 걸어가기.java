import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] home = new int[1][2];
	static int[][] end = new int[1][2];
	static int[][] store;
	static boolean[] vis;
	static boolean check;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {

			n = Integer.parseInt(br.readLine()); // 편의점 개수
			store = new int[n][2];
			st = new StringTokenizer(br.readLine());
			home[0][0] = Integer.parseInt(st.nextToken());
			home[0][1] = Integer.parseInt(st.nextToken()); // 시작위치 좌표
			
			vis = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			} // 편의점 좌표

			st = new StringTokenizer(br.readLine());
			end[0][0] = Integer.parseInt(st.nextToken());
			end[0][1] = Integer.parseInt(st.nextToken()); // 도착 위치 좌표
			
			check = false;
			
			bfs(home[0][0], home[0][1]);
			
			bw.write(check == true ? "happy" : "sad");
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		
	}
	static void bfs(int i, int j){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i, j});
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        if(Math.abs((end[0][0] - now[0])) + Math.abs((end[0][1] - now[1])) <= 1000){
	            check = true;
	            return;
	        }
	        
	        for(int k=0; k<n; k++){
	            if((Math.abs(store[k][0] - now[0])) + Math.abs((store[k][1] - now[1])) <= 1000 && vis[k] == false){
	                vis[k] = true;
	                dq.add(new int[] {store[k][0], store[k][1]});
	            }
	        }
	    }
	}
	
}