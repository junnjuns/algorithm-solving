import java.util.*;
import java.io.*;

public class Main
{
    static int a,b,n,m;
    static ArrayList<Integer>[] list;
    static int[] vis;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //1~n
		m = Integer.parseInt(st.nextToken()); //쌍의 개수
		
		list = new ArrayList[n+1];
		
		for(int i=1; i<n+1; i++){
		    list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++){
		    st = new StringTokenizer(br.readLine());
		    int num1 = Integer.parseInt(st.nextToken());
		    int num2 = Integer.parseInt(st.nextToken());
		    list[num1].add(num2);
		    list[num2].add(num1);
		}
		vis = new int[n+1];
		bfs(a);
		
		bw.write(vis[b]-1+"");
		bw.flush();
		bw.close();
	}
	
	static void bfs(int a){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(a);
	    vis[a] = 1;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        if(now == b) break;
	        for(int i=0; i<list[now].size(); i++){
	            if(vis[list[now].get(i)] == 0){
	                dq.add(list[now].get(i));
	                vis[list[now].get(i)] = vis[now] + 1;
	            }
	        }
	    }
	}
}
