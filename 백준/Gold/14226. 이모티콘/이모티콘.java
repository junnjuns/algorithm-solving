import java.util.*;
import java.io.*;

public class Main
{   
    static int[][] vis = new int[1005][1005]; //현재 스티커 수, 클립보드 스티커 수
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int target = Integer.parseInt(br.readLine());
	    
	    int answer = find(target);
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	static int find(int target){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {1, 0, 0}); //현재 위치, 클립보드, 횟수
	    vis[1][0] = -1;
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        int present = now[0];
	        int clip = now[1];
	        int time = now[2];
	        
	        if(present == target){
	            return time;
	        }
	        
	        //복사
	        dq.add(new int[] {present, present, time + 1});
	        
	        //붙여넣기
	        if(clip != 0){
	         int m = present + clip; //현재에 클립보드 추가
	         
	         if(m >= 0 && m < vis[0].length){
	             if(vis[m][clip] == 0){
	                 dq.add(new int[] {m, clip, time + 1});
	                 vis[m][clip] = -1;
	             }
	         }
	         
	         //현재 하나 삭제
	         int n = present - 1;
	         if(n >=0 && n < vis[0].length){
	             if(vis[n][clip] == 0){
	                 dq.add(new int[] {n, clip, time + 1});
	                 vis[n][clip] = -1;
	             }
	         }
	         
	        }
	        
	    }
	    return -1;
	}
}
