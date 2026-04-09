// 배열의 크기 == 논문 수 == n
// 배열의 값 = 인용된 횟수
// 배열의 인덱스 = 논문

// 0 1 3 5 6

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length; //논문의 수
        
        Arrays.sort(citations);
        
        for(int i = 0; i < n; i++){
            int min = Math.min(citations[i], n - i);
            
            answer = Math.max(answer, min);
            
        }
        
        return answer;
    }
}