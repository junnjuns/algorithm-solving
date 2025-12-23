import java.io.*;
import java.util.*;

class Solution {
    
    
    static int size;
    static ArrayList<String> list;
    static boolean[] vis;
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, Comparator.comparing(a -> a[1])); // 도착지 기준 정렬
        size = tickets.length;
        
        vis = new boolean[size]; //사용한 항공권
        
        list = new ArrayList<>();
        list.add("ICN"); //출발
        
        dfs("ICN", tickets);
        
        
        return answer;
    }
    
    static void dfs(String from, String[][] tickets){
        if(answer != null){
            return;
        }
        
        if(list.size() == size + 1){ //모든 경로 탐색하면 종료
            answer = list.toArray(new String[list.size()]);
            return;
        }
        
        for(int i = 0; i < size; i++){
            if(vis[i]) continue;
            
            String start = tickets[i][0]; //출발지
            String end = tickets[i][1];  //도착지
            
            if(from.equals(start)){
                vis[i] = true;
                list.add(end);
                dfs(end, tickets);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
        
        
    }
    

}