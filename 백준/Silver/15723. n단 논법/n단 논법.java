import java.util.*;
import java.io.*;


public class Main
{
    
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] vis;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        list = new ArrayList[26];
        
        for(int idx = 0; idx < 26; idx++){
            list[idx] = new ArrayList<Integer>();
        }
        
        for(int idx = 0; idx < n; idx++){
            st = new StringTokenizer(br.readLine());
            
            int num1 = st.nextToken().charAt(0) - 'a';
            String is = st.nextToken();
            int num2 = st.nextToken().charAt(0) - 'a';
            
            list[num1].add(num2);
        }
        
        int m = Integer.parseInt(br.readLine());
        for(int idx = 0; idx < m; idx++){
            st = new StringTokenizer(br.readLine());
            
            int num1 = st.nextToken().charAt(0) - 'a';
            String is = st.nextToken();
            int num2 = st.nextToken().charAt(0) - 'a';
            
            vis = new boolean[26];
            
            boolean result = bfs(num1, num2);
            
            if(result){
                bw.write("T\n");
            }
            else{
                bw.write("F\n");
            }
            
        }      
        
        
	    bw.flush();
	    bw.close();
	}
	
	static boolean bfs(int start, int end){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(start);
	    vis[start] = true;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        
	        for(int idx = 0; idx < list[now].size(); idx++){
	            
	            int next = list[now].get(idx);
	            
	            if(next == end){
	                return true;
	            }
	            
	            else if(vis[next] == false){
	                dq.add(next);
	                vis[next] = true;
	            }
	            
	        }
	        
	    }
	    return false;
	}
	
	
}
