import java.util.*;
import java.io.*;

public class Main
{   
    static int n, m;
    static int s, e;
    static ArrayList<Integer>[] list;
    static int[] vis;
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken()); // 텔레포트 정거장 개수
	    
	    st = new StringTokenizer(br.readLine());
	    
	    s = Integer.parseInt(st.nextToken()); // 시작
	    e = Integer.parseInt(st.nextToken()); // 도착
	    
	    vis = new int[n + 1];
	    list = new ArrayList[n + 1];
	    
	    for(int idx = 1; idx < n + 1; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
	    
	    for(int idx = 0; idx < m; idx++){
	        st = new StringTokenizer(br.readLine());
	        int num1 = Integer.parseInt(st.nextToken());
	        int num2 = Integer.parseInt(st.nextToken());
	        
	        list[num1].add(num2);
	        list[num2].add(num1);
	    }
	    
	    bfs(s);
	    
	    bw.write((vis[e]-1)+"");
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int start){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(start);
	    vis[start] = 1;
	    
	    while(!dq.isEmpty()){
	        int now = dq.poll();
	        
	        int plusNum = now + 1;
	        int minusNum = now - 1;
	        if(check(plusNum) && vis[plusNum] == 0){
	            dq.add(plusNum);
	            vis[plusNum] = vis[now] + 1;
	        }
	        if(check(minusNum) && vis[minusNum] == 0){
	            dq.add(minusNum);
	            vis[minusNum] = vis[now] + 1;
	        }
	        
	        for(Integer num : list[now]){
	            if(vis[num] == 0){
	                dq.add(num);
	                vis[num] = vis[now] + 1;
	            }
	        }
	    }
	}
	static boolean check(int num){
	    return num > 0 && num < n + 1;
	}
}
