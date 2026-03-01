// 매일 1명의 가수 노래함
// k 번째 이내만 명예의 전당
// score 의 길이 == 일

//우선순위 큐 값 추출하기
    //단 우선순위 큐 크기는 k


import java.util.*;
import java.io.*;

class Solution {
    
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 0;
        for(int value : score){
             
            pq.add(value); //값 넣기
            
            
            if(pq.size() == k + 1){
                pq.poll();
            }
            answer[idx++] = pq.peek();
        }
        
        return answer;
    }
}