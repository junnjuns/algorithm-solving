import java.util.*;
import java.io.*;

public class Main {
    
    static int cityCnt;
    static int planCnt;
    static int[] parents;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        cityCnt = Integer.parseInt(br.readLine());
        planCnt = Integer.parseInt(br.readLine());
        
        parents = new int[cityCnt + 1];
        for(int idx = 0; idx < cityCnt + 1; idx++){
            parents[idx] = idx;
        }
        
        for(int idx = 1; idx < cityCnt + 1; idx++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < cityCnt + 1; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(idx, j);
                } 
            }
        }
        
        boolean answer = true;
        st = new StringTokenizer(br.readLine());
        int result = parents[Integer.parseInt(st.nextToken())];
        for(int idx = 1; idx < planCnt; idx++){
            if(result != parents[Integer.parseInt(st.nextToken())]){
                answer = false;
                break;
            }
        }
        
        bw.write(answer == true ? "YES" : "NO");
        
        bw.flush();
        bw.close();
    }
    
    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA > parentB){
            parents[parentA] = parentB;
        }
        else{
            parents[parentB] = parentA;
        }
        
    }
    static int find(int num){
        if(parents[num] != num){
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }   
}
