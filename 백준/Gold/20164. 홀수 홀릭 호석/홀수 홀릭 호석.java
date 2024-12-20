import java.util.*;
import java.io.*;

public class Main {
    
    static String n;
    static int min, max;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    
        n = br.readLine();
        
        min = Integer.MAX_VALUE;    
        max = 0;
        
        cntOdd(n, 0);
    
    
        bw.write(min+" "+max);
        bw.flush();
        bw.close();
    }
    
    static void cntOdd(String num, int cnt){
        
        for(int idx = 0; idx < num.length(); idx++){ //수의 각 자리 숫자 중에서 홀수의 개수 카운트
            int number = num.charAt(idx) - '0';
            
            if(number % 2 != 0){
                cnt += 1;
            }
        }
        
        if(num.length() == 1){
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }
        
        else if(num.length() == 2){
            int num1 = Integer.parseInt(num.substring(0, 1));
            int num2 = Integer.parseInt(num.substring(1, 2));
            cntOdd(num1+num2+"", cnt);
        }
        
        //3개의 수로 분할하는 경우의 수
        for(int i = 1; i < num.length() - 1; i++){
            for(int j = i + 1; j < num.length(); j++){
                int num1 = Integer.parseInt(num.substring(0, i));
                int num2 = Integer.parseInt(num.substring(i, j));
                int num3 = Integer.parseInt(num.substring(j, num.length()));
                
                cntOdd(num1+num2+num3+"", cnt);
            }
        }
        
    }
}
