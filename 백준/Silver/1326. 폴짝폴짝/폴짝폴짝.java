//징검다리는 숫자가 쓰여 있다.
//징검다리에서 점프할 때, 징검다리 숫자의 배수만큼 이동 가능
//a번째에서 b번째까지 가야 함.
//a에서 최소 몇 번 점프해야 b 까지 갈 수 있나?


import java.util.*;
import java.io.*;

public class Main
{
    static int bridgeCnt;
    static int bridgeA;
    static int bridgeB;
    static int[] arr;
    static int[] vis;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        bridgeCnt = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        arr = new int[bridgeCnt];
        vis = new int[bridgeCnt];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < bridgeCnt; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        bridgeA = Integer.parseInt(st.nextToken());
        bridgeB = Integer.parseInt(st.nextToken());
        
        if(arr[bridgeA - 1] == 1){
            System.out.print(1);
            return;
        }
        
        bfs(bridgeA - 1, arr[bridgeA - 1]);
        bw.write(vis[bridgeB - 1]+"");
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int index, int value){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {index, value});
	    vis[index] = 0;
	    
	    while(!dq.isEmpty()){
	        int[] now = dq.poll();
	        
            for(int idx = now[0] + now[1]; check(idx); idx += now[1]){
                if(vis[idx] == -1){
                    vis[idx] = vis[now[0]] + 1;
                    dq.add(new int[] {idx, arr[idx]});
                }
            }
            
            for(int idx = now[0] - now[1]; check(idx); idx -= now[1]){
                if(vis[idx] == -1){
                    vis[idx] = vis[now[0]] + 1;
                    dq.add(new int[] {idx, arr[idx]});
                }
            }
            
	    }
	}
	
	static boolean check(int num){
	    return num >= 0 && num < bridgeCnt;
	}
}
