import java.util.*;
import java.io.*;

class Solution {
    
    static Map<String, Integer> map;
    
    public int solution(String s) {
        
        StringBuffer sb = new StringBuffer();
        StringBuffer word = new StringBuffer();
        
        map = new HashMap<>();
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                sb.append(ch);
            } //숫자이면 그대로
            
            else{
                
                word.append(ch); //일단 추가
                
                if(map.containsKey(word.toString())){ // 키 찾으면
                    sb.append(map.get(word.toString()));
                    word.setLength(0);
                }
                
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}