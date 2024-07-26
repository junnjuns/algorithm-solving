import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static boolean[] vis;
    static ArrayList<Integer>[] list;
    static int[] arr;
    static int cnt;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    arr = new int[n+1];
	    list = new ArrayList[n+1];
	    
	    for(int i=1; i<n+1; i++){
	        list[i] = new ArrayList<Integer>();
	    }
	    
	    while(true){
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        if(a == -1 && b == -1){
	            break;
	        }
	        list[a].add(b);
	        list[b].add(a);
	    }
	    
	    for(int i=1; i<n+1; i++){
	        vis = new boolean[n+1];
	        cnt = 0;
	        BFS(i,0);
	    }
	    
	    int count = 0;
	    int min = Integer.MAX_VALUE;
	    for(int i=1; i<n+1; i++){
	        min = Math.min(min, arr[i]);
	    }
	    
	    for(int i=1; i<n+1; i++){
	        if(arr[i] == min) count++;
	    }
	    
	    bw.write(min+" "+count+"\n");
	    for(int i=1; i<n+1; i++){
	        if(arr[i] == min){
	            bw.write(i+" ");
	        }
	    }
	    
        bw.flush();
        bw.close();
        
	}
	
	static void BFS(int i, int dep){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(i);
	    dq.add(dep);
	    vis[i] = true;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        cnt = dq.poll();
	        
	        for(int j=0; j<list[now].size(); j++){
	            if(vis[list[now].get(j)] == false){
	                dq.add(list[now].get(j));
	                dq.add(cnt+1);
	                vis[list[now].get(j)] = true;
	            }
	        }
	    }
	    arr[i] = cnt;
	}
}
