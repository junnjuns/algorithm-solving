import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int m;
    static boolean[] vis;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[] arr;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    arr = new int[n+1];
	    list = new ArrayList[n+1];
	    
	    for(int i=0; i<n+1; i++){
	        list[i] = new ArrayList<Integer>();
	    }
	    
	    for(int i=0; i<m; i++){
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        list[a].add(b);
	    }
	    
	    for(int i=1; i<n+1; i++){
	        vis = new boolean[n+1];
	        
	        LinkedList<Integer> dq = new LinkedList<>();
	    dq.add(i);
	    vis[i] = true;
	    while(dq.size() != 0){
	        int now = dq.poll();
	        for(int j=0; j<list[now].size(); j++){
	            if(vis[list[now].get(j)] == false){
	               dq.add(list[now].get(j));
	               arr[list[now].get(j)]++;
	               vis[list[now].get(j)] = true; 
	            }
	        }
	    }
	        
	    }
	    
	    int max = Integer.MIN_VALUE;
	    
	    for(int i=1; i<n+1; i++){
	        if(max < arr[i]){
	            max = arr[i];
	        }
	    }
	    
	    
	    for(int i=1; i<n+1; i++){
	        if(arr[i] == max){
	            bw.write(i+" ");
	        }
	    }
	    bw.flush();
	    bw.close();
	}
	
	
}
