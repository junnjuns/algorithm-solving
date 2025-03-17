import java.util.*;
import java.io.*;

public class Main
{
    
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] vis;
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    vis = new boolean[n];
	    list = new ArrayList[n];
	    
	    for(int idx = 0; idx < n; idx++){
	        list[idx] = new ArrayList<>();
	    }

        st = new StringTokenizer(br.readLine());
        
        int start = 0;
        
        for(int idx = 0; idx < n; idx++){
            int num = Integer.parseInt(st.nextToken());
            
            if(num == -1){
                start = idx;
                continue;
            }
            
            list[num].add(idx);
        }
        
        int deleteNum = Integer.parseInt(br.readLine());
        
        if( start == deleteNum){
            bw.write("0");
            bw.flush();
            bw.close();
            return; 
        }
        
        //노드 자식 방문처리하여 삭제 시킴
	    vis[deleteNum] = true;
	    
	    
	    if(list[deleteNum].size() == 0){
	        for(int idx = 0; idx < n; idx++){
	            if(list[idx].contains(deleteNum)){
	                list[idx].remove(Integer.valueOf(deleteNum));
	            }
	        }    
	    }
	    
	    vis[start]=  true;
	    dfs(start);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void dfs(int num){

	    
	    if(list[num].size() == 0){
	        answer += 1;
	        return;
	    }
	    
	    for(int idx = 0; idx < list[num].size(); idx++){
	        if(vis[list[num].get(idx)] == false){
	            vis[list[num].get(idx)] = true;
	            dfs(list[num].get(idx));
	        }
	    }
	}
}
