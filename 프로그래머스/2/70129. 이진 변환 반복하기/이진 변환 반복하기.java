import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        
        int runCnt = 0;
        int removeZeroCnt = 0;
        
        while(true){
            if(s.equals("1")) break;
            
            runCnt += 1;
            int oneCnt = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) - '0' == 1){
                    oneCnt += 1;
                }
                else{
                    removeZeroCnt += 1;
                }
            } // 다음 길이 구하기, 제거된 0의 개수 구하기
            
            s = Integer.toBinaryString(oneCnt);
            
        } // 반복문 종료
        
        answer[0] = runCnt;
        answer[1] = removeZeroCnt;
        
        return answer;
    }
}