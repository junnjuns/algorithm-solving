import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        
        boolean isEmpty = true; //빈칸이면 true
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ' '){
                sb.append(ch);
                isEmpty = true;
                continue;
            }
            
            if(isEmpty && ch != ' '){ //만약 젤 앞일 때
                if(Character.isLowerCase(ch)){
                    ch = Character.toUpperCase(ch);
                }
                sb.append(ch);
                isEmpty = false;
            }
            else if(!isEmpty && ch != ' '){
                if(Character.isUpperCase(ch)){
                    ch = Character.toLowerCase(ch);
                }
                sb.append(ch);
            }
            
        }// for문 끝
        
        
        return sb.toString();
    }
}