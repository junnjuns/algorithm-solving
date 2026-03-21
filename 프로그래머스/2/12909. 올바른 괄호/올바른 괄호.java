import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        ArrayDeque<Character> dq = new ArrayDeque<>();
        dq.add(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                dq.add(ch);
            }
            else{
                if(dq.size() != 0 && dq.peekLast() == '('){
                    dq.pollLast();
                }
                else{
                    return false;
                }
            }

        }
        
        answer = dq.size() == 0 ? true : false;

        return answer;
    }
}