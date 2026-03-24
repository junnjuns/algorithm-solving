import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String str : operations){
            String[] arr = str.split(" ");
            
            int num = Integer.parseInt(arr[1]);
            
            if(arr[0].equals("I")){
                if(map.containsKey(num)){
                    map.put(num, map.get(num) + 1);
                }
                else{
                    map.put(num, 1);
                }
            } //삽입
            
            else if(arr[0].equals("D") && map.size() > 0){
                
                int key = 0;
                
                if(num == 1){
                    key = map.lastKey();
                } //최댓값 삭제
                
                else{
                    key = map.firstKey();
                } //최솟값 삭제
                
                
                map.put(key, map.get(key) - 1);
                        
                if(map.get(key) == 0){
                    map.remove(key);
                }
                
                
            } //삭제
            
        } //for문 끝
        
        int max = map.size() > 0 ? map.lastKey() : 0;
        int min = map.size() > 0 ? map.firstKey() : 0;
        
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}