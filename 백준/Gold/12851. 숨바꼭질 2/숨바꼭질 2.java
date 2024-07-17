import java.util.*;
import java.io.*;

public class Main
{   
    static int n,m;
    static int[] vis = new int[100005];
    static int answer;
    static int cnt;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    find(n);
	    
	    bw.write(answer+"\n");
	    bw.write(cnt+"");
	    
	    bw.flush();
	    bw.close();
	}
	static void find(int num){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(num);
	    vis[num] = 1; //횟수
	    
	    while(dq.size() != 0){
	        
	        int now = dq.poll();
	        
	        if(now == m){
	            answer = vis[now] - 1;
	            cnt += 1;
	            continue;
	        }
	        
	        int[] arr = {now + 1, now - 1, now * 2};
	        
	        for(int i=0; i<arr.length; i++){
	            int x = arr[i];
	            
	            if(x>=0 && x<vis.length){
	                
	                if(vis[x] == 0 || vis[x] == vis[now] + 1){
	                    vis[x] = vis[now] + 1;
	                    dq.add(x);
	                }
	            }
	        }
	    }
	}
}
