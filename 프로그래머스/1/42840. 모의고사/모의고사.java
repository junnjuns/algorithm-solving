// 1부터 5까지
// 홀수번째 무조건 2, 짝수는 1부터 5까지 (2제외)
// 3 1 2 4 5 반복
// 가장 높은 점수 인덱스 출력


import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] arr = 
        {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[][] answer = new int[3][2];
    
        answer[0][1] = 1;
        answer[1][1] = 2;
        answer[2][1] = 3;
        
        int max = 0;
        
        for(int i = 0; i < answers.length; i++){
            int num = answers[i];
            
            int index1 = i > arr[0].length - 1 ? i % arr[0].length  : i;
            int index2 = i > arr[1].length - 1 ? i % arr[1].length : i;
            int index3 = i > arr[2].length - 1 ? i % arr[2].length: i;
            
            
            if(arr[0][index1] == num){
                answer[0][0] += 1;
            }
            if(arr[1][index2] == num){
                answer[1][0] += 1;
            }
            if(arr[2][index3] == num){
                answer[2][0] += 1;
            }
            
            max = Math.max(answer[0][0], max);
            max = Math.max(answer[1][0], max);
            max = Math.max(answer[2][0], max);
        }
        
        Arrays.sort(answer, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(b[0], a[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            if(answer[i][0] == max) list.add(answer[i][1]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}