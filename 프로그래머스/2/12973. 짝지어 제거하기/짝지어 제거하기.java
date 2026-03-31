import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(dq.size() == 0){
                dq.add(ch);
            }
            else{
                if(dq.peekLast() == ch){
                    dq.pollLast();
                }
                else{
                    dq.add(ch);
                }
            }
        }
        
        int answer = dq.size() == 0 ? 1 : 0;
        
        return answer;
    }
}