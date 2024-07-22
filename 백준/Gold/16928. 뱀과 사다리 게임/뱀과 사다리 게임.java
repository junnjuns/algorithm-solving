import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int m;
    static int[] board;
    static boolean[] vis;
    static LinkedList<Integer>[] list;
    static int ans;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[101];
        vis = new boolean[101];
        
        for(int i=1; i<101; i++){
                board[i] = i;
        }
	    
	    list = new LinkedList[101];
	    
	    for(int i=0; i<101; i++){
	        list[i] = new LinkedList<Integer>();
	    }
	    
	    for(int i=0; i<n+m; i++){
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        //list[a].add(b);
	        board[a] = b;
	        
	    }
	    
	    BFS(1);
	    bw.write(ans+"");
	    bw.flush();
	    bw.close();
	}
	
	static void BFS(int i){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(board[i]); // 1
	    dq.add(0);
	    vis[i] = true;
	    while(dq.size() != 0){
	        int now = dq.poll(); //1
	        int cnt = dq.poll();
	        if(now == 100){
	            ans = cnt;
	        }
	        for(int j=1; j<7; j++){
                int x = now+j; //2,3,4,5,6,7
                if(x <101){
                if(board[x] < 101 && vis[board[x]] == false){
                    dq.add(board[x]);
                    dq.add(cnt+1);
                    vis[board[x]] = true;
                }
	        }}
	    }
	}
	
}
