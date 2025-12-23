import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean check = false;
        int targetIdx = 0;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                check = true;
                targetIdx = i;
                break;
            }
        } //target이 목록에 없으면 종료
        
        if(!check){
            return 0;
        }
        
        int size = begin.length();
        int[] vis = new int[words.length];
        ArrayDeque<String> dq = new ArrayDeque<>();
        dq.add(begin);
        dq.add(0+"");
        
        while(dq.size() != 0){
            String now = dq.poll();
            int res = Integer.parseInt(dq.poll());
            
            if(now.equals(target)){ //꺼낸 것과 타겟 같으면 종료
                break;
            }
            
            
            for(int i = 0; i < words.length; i++){ //words 단어들 비교하기
                
                if(vis[i] != 0 ) continue; //만약 방문했다면 안 감
                
                int cnt = 0; //몇 개의 문자가 다른지 카운트
                for(int j = 0; j < size; j++){ //몇개가 같은지 비교
                    if(now.charAt(j) != words[i].charAt(j)){
                        cnt += 1;
                    }
                }
                
                if(cnt == 1){ // 1개만 달라서 바꿀 수 있으면 방문
                    vis[i] = res + 1;
                    dq.add(words[i]);
                    dq.add(vis[i]+"");
                    
                }
                
            }
            
        }
        
        answer = vis[targetIdx];
        
        return answer;
    }
    
    
 
}