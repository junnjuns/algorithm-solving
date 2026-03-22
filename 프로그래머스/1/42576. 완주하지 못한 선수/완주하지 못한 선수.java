import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> pMap = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++){
            
            if(pMap.containsKey(participant[i])){
                pMap.put(participant[i], pMap.get(participant[i]) + 1);
            } // 존재한다면
            
            else{
                pMap.put(participant[i], 1);
            }
        } // 참가자 map
        
        
        for(int i = 0; i < completion.length; i++){
            String now = completion[i];
            
            pMap.put(now, pMap.get(now) - 1);
        } 
        
        for(int i = 0; i < participant.length; i++){
            String now = participant[i];
            
            if(pMap.get(now) != 0){
                answer = now;
                break;
            }
            
        }
        
        
        
        return answer;
    }
}