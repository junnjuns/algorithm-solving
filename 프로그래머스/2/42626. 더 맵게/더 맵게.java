import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            if(pq.peek() >= K){
                break;
            }
            if(pq.peek() < K && pq.size() == 1){
                answer = -1;
                break;
            }
            
            int num = pq.poll() + (pq.poll() * 2);
            pq.add(num);
            answer += 1;
            
        }
        
        return answer;
    }
}