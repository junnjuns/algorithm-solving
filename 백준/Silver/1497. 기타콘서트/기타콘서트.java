import java.util.*;
import java.io.*;


public class Main
{   
    static int n;
    static int m;
    static long result;
    static long[] bit;
    static int answer;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        bit = new long[n];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();   // 저장 안 해도 됨
            String song = st.nextToken();
            
            long mask = 0;
            
            for(int j = 0; j < m; j++){
                if(song.charAt(j) == 'Y'){
                    mask = mask | (1L << j);
                }
            }
            
            bit[i] = mask;
        }
        
        result = 0;
        for(long num : bit){
            result = result | num;
        }
        
        if(result == 0){
            bw.write("-1");
            bw.flush();
		    bw.close();
		    
            return;
        }
        
        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        
        bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	
	static void dfs(int idx, long mask, int cnt){
        if(idx == n){
            if(mask == result){
                answer = Math.min(answer, cnt);
            }
            return;
        }
        
        dfs(idx + 1, mask, cnt);
        
        dfs(idx + 1, mask | bit[idx], cnt + 1);
        
    }
	
}