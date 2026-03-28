import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 1;
        int right = 1;
        int sum = 1;
        
        while(left <= right){
            
            if(sum < n){
                right += 1;
                sum += right;
            }
            else if(sum > n){
                sum -= left;
                left += 1;
            }
            else{
                answer += 1;
                sum -= left;
                left += 1;
            }
            
        }
       
        
        
        return answer;
    }
}