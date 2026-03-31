import java.util.*;
import java.io.*;

class Solution {
    
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        
        for(int i = 0; i < n; i++){
            int num = arr1[i] | arr2[i];
            
            StringBuffer sb = new StringBuffer();
            
            for(int j = 0; j < n; j++){
                if((num & (1 << n - j - 1)) != 0){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        
        return answer;
    }
}