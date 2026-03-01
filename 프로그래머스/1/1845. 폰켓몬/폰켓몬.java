//HashSet 크기 반환하기

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int value : nums){
            set.add(value);
        }
        
        answer = set.size() > nums.length / 2 ? nums.length / 2 : set.size();
        
        return answer;
    }
}