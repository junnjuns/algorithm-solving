// N 개의 방
// 모든 방은 1 부터 N 개까지의 번호 부여 받음
    // 입구 == 1



import java.util.*;
import java.io.*;

public class Main
{
    static int N; //방의 개수
    static ArrayList<int[]>[] list;
    static long[] vis;
    static long max;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    N = Integer.parseInt(br.readLine());
	    vis = new long[N + 1];
	    Arrays.fill(vis, -1);
	    list = new ArrayList[N + 1];
	    
	    for(int idx = 0; idx < N + 1; idx++){
	        list[idx] = new ArrayList<>();
	    } //인접 배열 초기화
	    
	    for(int idx = 0; idx < N - 1; idx++){
	        st = new StringTokenizer(br.readLine());
	        
	        int roomA = Integer.parseInt(st.nextToken());
	        int roomB = Integer.parseInt(st.nextToken());
	        int dist = Integer.parseInt(st.nextToken());
	        
	        list[roomA].add(new int[] {roomB, dist});
	        list[roomB].add(new int[] {roomA, dist});
	        
	    } // 입력값 세팅
	    
	    bfs(1);
	    
	    sb.append(max);
	    System.out.print(max);
	    
	}
	
	static void bfs(int num){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(num);
	    vis[num] = 0;
	    
	    while(dq.size() != 0 ){
	        int room = dq.poll();
	        long dist = vis[room];
	        max = Math.max(max, dist);
	        for(int[] node : list[room]){
	            int nextRoom = node[0];
	            int nextDist = node[1];
	            if(vis[nextRoom] == -1){
	                vis[nextRoom] = nextDist + dist;
	                dq.add(nextRoom);
	            }
	        }
	    }
	}
	
}
