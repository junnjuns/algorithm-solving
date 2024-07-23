import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static int[][] board;
    static int[][] vis;

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static ArrayList<int[]> list = new ArrayList<>();
	static boolean[] listVis;
	static int[][] arr;
	static ArrayDeque<int[]> dq;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken()); //보드판 크기
	    m = Integer.parseInt(st.nextToken()); //바이러스 투입 개수
	    
	    board = new int[n][n];
	    
	    for(int i=0; i<n; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<n; j++){
	            board[i][j] = Integer.parseInt(st.nextToken());
	            if(board[i][j] == 2){
	                list.add(new int[] {i,j});
	            }
	        }
	    }
	    
	    listVis = new boolean[list.size()];
	    arr = new int[m][2];
	    func(0,0); //백트래킹 함수 호출
	    
	    if(min == Integer.MAX_VALUE){
	        bw.write("-1");
	    }
	    else{
	        bw.write(min+"");
	    }
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep, int idx){
	    if(dep == m){
	        vis = new int[n][n];
	        for(int i=0; i<n; i++){
	            for(int j=0; j<n; j++){
	                if(board[i][j] == 1){
	                    vis[i][j] = -1;
	                }
	                else{
	                    vis[i][j] = 0;
	                }
	            }
	        }
	        
	        dq = new ArrayDeque<int[]>();
	        for(int i=0; i<m; i++){
	            dq.add(new int[] {arr[i][0], arr[i][1]});
	            vis[arr[i][0]][arr[i][1]] = 1;
	        }
	        
	        BFS();
	        
	        return;
	    }
	    
	    for(int i=idx; i<list.size(); i++){
	        if(listVis[i] == false){
	            listVis[i] = true;
	            arr[dep][0] = list.get(i)[0];
	            arr[dep][1] = list.get(i)[1];
	            func(dep+1, i);
	            listVis[i] = false;
	        }
	    }   
	}
	
	static void BFS(){
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        for(int i=0; i<4; i++){
	            int x = now[0] + dx[i];
	            int y = now[1] + dy[i];
	            
	            if(x >=0 && y>=0 && x<n && y<n){
	                if(vis[x][y] == 0){
	                    dq.add(new int[] {x,y});
	                    vis[x][y] = vis[now[0]][now[1]] + 1;
	                }
	            }
	        }
	    }
	    
	    int res = 0;
	    
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            if(vis[i][j] == 0){
	                res = Integer.MAX_VALUE;
	                break;
	            }
	            res = Math.max(res, vis[i][j]-1);
	        }
	    }
	    min = Math.min(min, res);
	  }
}
