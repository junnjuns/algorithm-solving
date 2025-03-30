import java.util.*;
import java.io.*;

class Solution {
    
    static int[] arr;
    static int goal;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        
        arr = numbers;
        goal = target;
        
        DFS(0, 0);
        
        
        return answer;
    }
    
    static void DFS(int sum, int index){
        
        if(index == arr.length){
            if(sum == goal){
                answer += 1;
            }
            return;
        }
            
        
        DFS(sum + arr[index], index + 1);
        DFS(sum - arr[index], index + 1);
        
        
        
    }
}