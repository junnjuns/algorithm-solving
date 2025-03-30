import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] list;
    static boolean[] vis;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new ArrayList[n];
        vis = new boolean[n];
        
        for(int idx = 0; idx < n; idx++){
            list[idx] = new ArrayList<Integer>();
        }
        
        for(int idx = 0; idx < n; idx++){
            for(int j = 0; j < n; j++){
                if(computers[idx][j] == 1){
                    list[idx].add(j);
                }
            }
        }
        
        for(int idx = 0; idx < n; idx++){
            if(vis[idx] == false){
                bfs(idx);
                answer += 1;
            }
        }
        
        
        return answer;
    }
    
    static void bfs(int index){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(index);
        vis[index] = true;
        
        while(dq.size() != 0){
            int now = dq.poll();
            
            int size = list[now].size();
            
            for(int idx = 0; idx < size; idx++){
                
                int next = list[now].get(idx);
                
                if(vis[next] == false){
                    dq.add(next);
                    vis[next] = true;
                }
            }
        }
    }
}