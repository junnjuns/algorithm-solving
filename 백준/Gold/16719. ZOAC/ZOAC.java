import java.util.*;
import java.io.*;

public class Main {
    
    static String str;
    static boolean[] vis;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        str = br.readLine();
        
        vis = new boolean[str.length()];
        func(0, str.length() - 1); 
        
        bw.flush();
        bw.close();
    }
    
    
    static void func(int left, int right){
        if(left > right){
            return;
        }
        
        int nextCh = 'Z' + 1;
        int nextIdx = -1;
        
        for(int idx = left; idx < right + 1; idx++){
            if(vis[idx] == false && str.charAt(idx) < nextCh){
                nextCh = str.charAt(idx);
                nextIdx = idx;
            }
        }
        
        if(nextIdx == -1){
            return;
        }
        
        vis[nextIdx] = true;
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int idx = 0; idx < str.length(); idx++){
            if(vis[idx]){
                sb.append(str.charAt(idx));
            }
        }
        
        System.out.println(sb.toString());
        
        func(nextIdx + 1, right); //오른쪽 확인
        func(left, nextIdx - 1); //왼쪽 확인
        
    }
}
