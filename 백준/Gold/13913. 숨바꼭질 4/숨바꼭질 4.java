import java.util.*;
import java.io.*;

public class Main
{   
    static int start, end;
    static int[] vis = new int[100005];
    static int[] preVis = new int[100005];
    static int answer;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        find(start);
        bw.write(answer+"\n");
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        dq.add(end);
        int idx = end;
        while(true){
            if(idx == start){
                break;
            }
            dq.addFirst(preVis[idx]);
            idx = dq.peek();
        }
        
        while(dq.size() != 0){
            bw.write(dq.poll()+" ");
        }
        
        bw.newLine();
        bw.flush();
        bw.close();
	}
	
	static void find(int n){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(n);
	    vis[n] = 1;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        
	        if(now == end){
	            answer = vis[now] - 1;
	            break;
	        }
	        
	        int[] arr = {now + 1, now - 1, now * 2};
	        
	        for(int idx = 0; idx < arr.length; idx++){
	            int num = arr[idx];
	            
	            if(num>=0 && num < vis.length){
	                if(vis[num] == 0 || vis[num] == vis[now] + 1){
	                    dq.add(num);
	                    vis[num] = vis[now] + 1;
	                    preVis[num] = now;
	                }
	            }
	        }
	    }
	}
}
