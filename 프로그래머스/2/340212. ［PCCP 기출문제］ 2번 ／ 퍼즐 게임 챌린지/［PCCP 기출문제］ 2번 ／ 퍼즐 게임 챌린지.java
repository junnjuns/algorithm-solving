// 0 ~ 100,000 까지 난이도 존재함
// 가운데 값으로 초기 레벨 지정

import java.util.*;


class Solution {

    static int answer;
    public int solution(int[] diffs, int[] times, long limit) {
        
        
        binary(1, 100000, diffs, times, limit);
        
        return answer;
    }
    
    static void binary(int left, int right, int[] diffs, int[] times, long limit){
        

        //종료 조건
        if(left >= right){
            answer = left;
            return;
        }
        
        int level = (right + left) / 2;
        
        long totalTime = times[0];
        for(int idx = 1; idx < diffs.length; idx++){
            if(level >= diffs[idx]){
                totalTime += times[idx];
            }
            else{
                int cnt = diffs[idx] - level;
                totalTime += (times[idx - 1] + times[idx]) * cnt + times[idx];
            }
            

        }
        
        if(totalTime <= limit){
            binary(left, level, diffs, times, limit);
        }
        else{
            binary(level + 1, right, diffs, times, limit);
        }
        
    }
}