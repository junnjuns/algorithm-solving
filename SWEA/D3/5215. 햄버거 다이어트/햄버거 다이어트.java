import java.util.*;
import java.io.*;




public class Solution {

    static int number;
    static int limit;
    static int[] taste;
    static int[] cal;
    static int[] select;
    static int answer;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int test = Integer.parseInt(br.readLine());
    	
        for(int t = 0; t < test; t++){
            bw.write("#"+(t+1)+" ");
            
            answer = 0;
            
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            
            taste = new int[number];
            cal = new int[number];
            
            for(int idx = 0; idx < number; idx++){
                st = new StringTokenizer(br.readLine());
                
                taste[idx] = Integer.parseInt(st.nextToken());
                cal[idx] = Integer.parseInt(st.nextToken());
                
            } // 맛과 칼로리 저장
            
            
            subSet(0, 0, 0);
            
            bw.write(answer+"\n");
        }	
    	
    	bw.flush();
    	bw.close();
    }
    static void subSet(int depth, int calSum, int tasteSum){
       
       if(depth == number){
           
           if(calSum <= limit)
                answer = Math.max(answer, tasteSum);
           
           return;
       }
       
       subSet(depth+1, calSum + cal[depth], tasteSum + taste[depth]);
       
       subSet(depth+1, calSum , tasteSum);
    }
}
