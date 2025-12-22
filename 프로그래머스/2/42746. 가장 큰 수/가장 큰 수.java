import java.io.*;
import java.util.*;

class Comp implements Comparator<String>{
    
    public int compare(String a, String b){
        int num1 = Integer.parseInt(a + b);
        int num2 = Integer.parseInt(b + a);
        
        return num2 - num1;
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int size = numbers.length;
        
        String[] strArr = new String[size];
        
        for(int i = 0; i < size; i++){
            strArr[i] = numbers[i] + "";
        }
        
        Arrays.sort(strArr, new Comp());
        
        if(strArr[0].equals("0")){
            return "0";
        }
        
        for(String s : strArr){
            sb.append(s);
        }
        return sb.toString();
    }
}