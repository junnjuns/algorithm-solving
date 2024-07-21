import java.io.*;
import java.util.*;

public class Main
{   
    static boolean[] vis;   // 레지스터 범위가 0 ~ 10000 이기 때문에 범위 고정
    static String[] arr;
    static int numA;
    static int numB;
    static int ans;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	     int test = Integer.parseInt(br.readLine());
	     StringTokenizer st;
	     for(int i=0; i<test; i++){ //test 번 반복
	        st = new StringTokenizer(br.readLine());
	        numA = Integer.parseInt(st.nextToken());
	        numB = Integer.parseInt(st.nextToken());
	        
	        vis = new boolean[10001];
	        arr = new String[10001];
	        Arrays.fill(arr, ""); //배열 "" 로 모두 초기화
	        
	        BFS(numA);
	        bw.write(arr[ans]);
	        bw.newLine();
	     }
	        bw.flush();
	        bw.close();
	}
    	
    	static void BFS(int numA){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(numA);
	    vis[numA] = true;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        if(now == numB){
	            ans = now;
	            break;
	        }
	        int D = (now*2)%10000;
	        int S = now-1;
	        if(now == 0){
	            S = 9999;
	        }
	        int L = (now % 1000) * 10 + now/1000;
	        int R = (now% 10)*1000 + now / 10;
	       
	       if(vis[D] == false){
	           dq.add(D);
	           vis[D] = true;
	           arr[D] = arr[now] + "D";
	       }
	       if(vis[S] == false){
	           dq.add(S);
	           vis[S] = true;
	           arr[S] = arr[now] + "S";
	       }
	       if(vis[L] == false){
	           dq.add(L);
	           vis[L] = true;
	           arr[L] = arr[now] + "L";
	       }
	       if(vis[R] == false){
	           dq.add(R);
	           vis[R] = true;
	           arr[R] = arr[now] + "R";
	       }
	    }
	}
}
