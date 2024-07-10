import java.util.*;
import java.io.*;

public class Main
{
	static int n;
	static int m;
	static int[][] board;
	static boolean[][] vis;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[] answer = new int[2];
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		vis = new boolean[n][m];
		for(int i=0; i<n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<m; j++){
		        board[i][j] = Integer.parseInt(st.nextToken());
		        if(board[i][j] == 1){
		            list.add(i);
		            list.add(j);
		        }
		    }
		}
	    boolean check = true;
		BFS(list);
		for(int i=0; i<n; i++){
		    for(int j=0; j<m; j++){
		        if(board[i][j] == 0){
		            check = false;
		            break;
		        }
		    }
		}
		if(check)
		bw.write((board[answer[0]][answer[1]]-1)+"");
		else
		bw.write("-1");
		bw.flush();
		bw.close();
	}
	static void BFS(ArrayList<Integer> list){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    for(int i=0; i<list.size(); i+=2){
	        dq.add(new int[] {list.get(i),list.get(i+1)});
	        vis[list.get(i)][list.get(i+1)] = true;
	    }
	    //System.out.println(board[0][0]);
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        if(dq.size() == 0){
	            answer = now;
	        }
	        for(int k=0; k<4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x >=0 && y >=0 && x < n && y < m){
	                if(board[x][y] != -1 && vis[x][y] == false){
	                    dq.add(new int[] {x,y});
	                    vis[x][y] = true;
	                    board[x][y] = board[now[0]][now[1]] + 1;
	                }
	            }
	        }
	    }
	}
}
