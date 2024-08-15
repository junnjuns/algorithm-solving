import java.util.*;
import java.io.*;

public class Solution
{   
    static int food;
    static int cnt;
    static int[][] badArr;
    static boolean[] vis;
    static int answer;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	   
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t = 0; t < test; t++){
	        bw.write("#"+(t+1)+" ");
	        
	        st = new StringTokenizer(br.readLine());
	        
	        food = Integer.parseInt(st.nextToken()); //재료 종류
	        cnt = Integer.parseInt(st.nextToken()); // 안 좋은 궁합 수
	        badArr = new int[cnt][2]; //안 좋은 궁합 배열
	        vis = new boolean[food];
	        
	        for(int idx = 0; idx < cnt; idx++){
	            st = new StringTokenizer(br.readLine());
	            
	            badArr[idx][0] = Integer.parseInt(st.nextToken())-1;
	            badArr[idx][1] = Integer.parseInt(st.nextToken())-1;
	            
	        }// 안 좋은 궁합 배열 입력
	        
	        answer = 0;
	        powerSet(0);
	        
	        bw.write(answer+"\n");
	    } //테스트 케이스 끝
	    
	    
	    bw.flush();
	    bw.close();
	}	
	
	static void powerSet(int dep){
	    if(dep == food){
    	    
    	    for(int idx = 0; idx < cnt; idx++){
    	        if(vis[badArr[idx][0]] && vis[badArr[idx][1]]){
    	            return;
    	        }
    	    }
    	    answer++;
	        return;
	    }
	    vis[dep] = true;
	    powerSet(dep+1);
	    
	    
	    vis[dep] = false;
	    powerSet(dep+1);
	    
	}
}
