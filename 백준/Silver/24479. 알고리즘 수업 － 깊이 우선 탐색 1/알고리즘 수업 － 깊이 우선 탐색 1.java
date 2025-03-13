import java.util.*;
import java.io.*;

public class Main
{
    static int nodeCnt;
    static int edgeCnt;
    static int startNode;
    static List<Integer>[] list;
    static boolean[] vis;
    static int[] answer;
    static int cnt = 1;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    nodeCnt = Integer.parseInt(st.nextToken());
	    edgeCnt = Integer.parseInt(st.nextToken());
	    startNode = Integer.parseInt(st.nextToken());
	    
	    answer = new int[nodeCnt + 1];
	    vis = new boolean[nodeCnt + 1];
	    
	    list = new ArrayList[nodeCnt + 1];
	    
	    for(int idx = 0; idx < nodeCnt + 1; idx++){
	        list[idx] = new ArrayList<>();
	    }
	    
	    for(int idx = 0; idx < edgeCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        int nodeA = Integer.parseInt(st.nextToken());
	        int nodeB = Integer.parseInt(st.nextToken());
	        
	        list[nodeA].add(nodeB);
	        list[nodeB].add(nodeA);
	    }
	   
	    
	    for(int idx = 1; idx < nodeCnt + 1; idx++){
	       
	       if(list[idx].size() > 1){
	           Collections.sort(list[idx]);
	       }
            	       
	    }
	    
	    dfs(startNode);
	    
	    
	    for(int idx = 1; idx < nodeCnt + 1; idx++){
	        bw.write(answer[idx]+"\n");	       
	    }	    
	    
	    bw.flush();
	    bw.close();
	}
	
	static void dfs(int start){
	    vis[start] = true;
	    answer[start] = cnt;
	    cnt += 1;
	    
	    for(int idx = 0; idx < list[start].size(); idx++){
	        if(vis[list[start].get(idx)] == false){
	            dfs(list[start].get(idx));
	        }
	    }
	}
}
