import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, new Comparator<int[]>() {
            
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        double shot = targets[0][1] - 0.1;
        
        for(int[] arr : targets){
            int start = arr[0];
            int end = arr[1];
            
            if(start < shot && shot < end){
                continue;
            }
            shot = arr[1] - 0.1;
            answer += 1;
            
        }
        
        return answer;
    }
}