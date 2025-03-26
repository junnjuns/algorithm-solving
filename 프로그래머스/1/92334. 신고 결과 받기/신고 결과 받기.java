import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        //유저, 신고당한 횟수
        Map<String, Integer> reported = new HashMap<>();
        
        Map<String, Set<String>> map = new HashMap<>();
        
        Map<Integer, String> user = new HashMap<>();
        
        for(int idx = 0; idx < id_list.length; idx++){
            map.put(id_list[idx], new HashSet<String>());
            reported.put(id_list[idx], 0);
            user.put(idx, id_list[idx]);
        }
        
        
        
        //신고 횟수
        for(int idx = 0; idx < report.length; idx++){
            String[] str = report[idx].split(" ");
            map.get(str[0]).add(str[1]);
        }
        
        
        for(Map.Entry<String, Set<String>> m : map.entrySet()){
            String key = m.getKey();
            
            for(String str : m.getValue()){
                reported.put(str, reported.get(str) + 1);
            }
            
            
        }
        
        int[] answer = new int[id_list.length];
        
        for(int idx = 0; idx < id_list.length; idx++){
            
            //현재 사람
            String man = user.get(idx);
            int cnt = 0;
            for(String str : map.get(man)){
                if(reported.get(str) >= k){
                    cnt += 1;
                }
            }
            answer[idx] = cnt;
            
            
        }
        
        return answer;
    }
}