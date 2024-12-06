import java.util.*;
import java.io.*;

public class Main {
    
    static int userCnt;
    static ArrayList<Integer>[] list;
    static boolean[] vis;
    static int[] arr;
    static int cnt;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        userCnt = Integer.parseInt(br.readLine());
        
        arr = new int[userCnt + 1];
        list = new ArrayList[userCnt + 1];
        
        for(int idx = 1; idx < userCnt + 1; idx++){
            list[idx] = new ArrayList<>();
        }
        
        while(true){
            st = new StringTokenizer(br.readLine());
            
            int userA = Integer.parseInt(st.nextToken());
            int userB = Integer.parseInt(st.nextToken());
            
            if(userA == -1 && userB == -1){
                break;
            }
            
            
            list[userA].add(userB);
            list[userB].add(userA);
        }
        
        for(int idx = 1; idx < userCnt + 1; idx++){
            vis = new boolean[userCnt + 1];
            cnt = 0;
            bfs(idx, 0);
        }
        
        
        int result = 0;
	    for(int idx = 1; idx < userCnt + 1; idx++){
	        if(arr[idx] == min) {
	            result++;
	        }
	    }
	    
	    bw.write(min+" "+result+"\n");
	    
	    for(int idx = 1; idx < userCnt + 1; idx++){
	        if(arr[idx] == min) {
	            bw.write(idx+" ");
	        }
	    }
	    
        
        bw.flush();
        bw.close();
    }
    
    static void bfs(int user, int dep){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(user);
        dq.add(dep);
        vis[user] = true;
        
        while(dq.size() != 0){
            int now = dq.poll();
            cnt = dq.poll();
            
            for(int idx = 0; idx < list[now].size(); idx++){
                if(!vis[list[now].get(idx)]){
                    dq.add(list[now].get(idx));
                    dq.add(cnt + 1);
                    vis[list[now].get(idx)] = true;
                }
            }
        }
        
        arr[user] = cnt;
        min = Math.min(arr[user], min);
    }
}
