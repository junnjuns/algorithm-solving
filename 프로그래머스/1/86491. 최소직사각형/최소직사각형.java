import java.util.*;
import java.io.*;

class Solution {
    
    static int[] width;
    static int[] height;
    
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int size = sizes.length;
        
        width = new int[size];
        height = new int[size];
        
        for(int i = 0; i < size; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            width[i] = w > h ? w : h;
            height[i] = w < h ? w : h;
        }
        
        Arrays.sort(width);
        Arrays.sort(height);
        
        answer = width[size - 1] * height[size - 1];
        
        return answer;
    }
}