// 음식의 배치를 나타내는 문자열 리턴
// 인덱스: 음식의 번호
// 값: 음식의 개수
// 0번째 인덱스는 항상 1 == 물은 항상 1개

//몫 구하기
//몫 만큼 인덱스를 문자열에 추가
// 문자열 + 물 + 문자열 리버스

import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] food){
        String answer = "";
        StringBuffer sb = new StringBuffer();
        
        for(int i = 1; i < food.length; i++){
            int value = food[i] / 2;
        
            for(int j = 0; j < value; j++){
                sb.append(i);
            }
            
        }
        
        answer = sb.toString()+"0"+sb.reverse().toString();
        
        return answer;
    }
}