



import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int k;
    static ArrayList<Integer>[] list;
    static int[] vis;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[n + 1];
	    
	    
	    for(int i = 0; i < n + 1; i++){
	        list[i] = new ArrayList<>();
	    }
	    
	    for(int i = 0; i < k; i++){
	        st = new StringTokenizer(br.readLine());
	        
	        int num1 = Integer.parseInt(st.nextToken());
	        int num2 = Integer.parseInt(st.nextToken());
	        
	        list[num1].add(num2);
	        list[num2].add(num1);
	    } // 인접 리스트 생성 끝
	    
	    boolean answer = true;
	    
	    int cnt = 0;
	    for(int i = 1; i < n + 1; i++){
	        vis = new int[n + 1];
	        
	        boolean check = bfs(i);
	        
	        for(int j = 1; j < n + 1; j++){
	            if(vis[j] == 0){
	                answer = false;
	                break;
	            }
	        }
	        
	        if(check == false){
	            answer = false;
	            break;
	        }
	    }
	    
	    String str = answer == true ? "Small World!" : "Big World!";
	    
	    bw.write(str);
        bw.flush();
        bw.close();
    }
    
    static boolean bfs(int num){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(num);
        vis[num] = 1;
        int max = 0;
        
        while(dq.size() != 0){
            int now = dq.poll();
            
            if(max > 7){
                return false;
            }
            
            int size = list[now].size();
            
            for(int i = 0; i < size; i++){
                int next = list[now].get(i);
                
                if(vis[next] == 0){
                    dq.add(next);
                    vis[next] = vis[now] + 1;
                    // System.out.println(now+"에서");
                    // System.out.println(next+"까지 값은: "+vis[next]);
                    max = Math.max(max, vis[next]);
                }
            }
            
        }
        return true;
    }
}
