import java.io.*;
import java.util.*;

public class Solution
{   
    static int n, limit;
    static boolean[] vis;
    static int[] calArr;
    static int[] scoreArr;
    static int[] score;
    static int[] cal;
    static int max;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t=0; t<test; t++){
		    bw.write("#"+(t+1)+" ");
		    
		    st = new StringTokenizer(br.readLine());
		    n = Integer.parseInt(st.nextToken()); // 재료의 수
		    limit = Integer.parseInt(st.nextToken()); // 제한 칼로리
		    
		    score = new int[n]; //점수
		    cal = new int[n]; //칼로리
		    
		    for(int i=0; i<n; i++){
		        st = new StringTokenizer(br.readLine());
		        score[i] = Integer.parseInt(st.nextToken());
		        cal[i] = Integer.parseInt(st.nextToken());
		    }//점수, 칼로리 초기화
		    
		    max = 0;
		    for(int i=1; i<n+1; i++){
		        vis = new boolean[n];
		        calArr = new int[i];
		        scoreArr = new int[i];
		        dfs(0,0,i);
		    }
		    
		    bw.write(max+"\n");
		} //테스트 케이스 끝
		
		bw.flush();
		bw.close();
	}
	static void dfs(int dep, int start, int k){
	    if(dep == k){
	        int calSum = 0;
	        int scoreSum = 0;
	        for(int i=0; i<dep; i++){
	            calSum += calArr[i];
	            scoreSum += scoreArr[i];
	        }
	        if(calSum <= limit){
	            max = Math.max(max, scoreSum);
	        }
	        return;
	    }
	    
	    for(int i=start; i<n; i++){
	        if(vis[i] == false){
	            vis[i] = true;
	            calArr[dep] = cal[i];
	            scoreArr[dep] = score[i];
	            dfs(dep+1, i, k);
	            vis[i] = false;
	        }
	    }
	}
}
