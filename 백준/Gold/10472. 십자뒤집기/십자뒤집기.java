import java.util.*;
import java.io.*;

public class Main
{   
    
    static int[] vis;
    static int board;
    static int[] dx = {0,1,-1,0,0};
    static int[] dy = {0,0,0,1,-1};
    static int answer;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < test; t++){
		    vis = new int[512];
		    
		    board = 0;
		    for(int h = 0; h < 3; h++){
		        String str = br.readLine();
		        for(int w = 0; w < 3; w++){
		            if(str.charAt(w) == '*'){
		                int num = 3 * h + w;
		                board = board | 1 << num;
		            }
		        }
		    } // 비트마스킹
		    
		    answer = 0;
		    bfs(0);
		    bw.write((answer - 1)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int start){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(start);
	    vis[start] = 1;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        if(now == board){
	            answer = vis[now];
	            return;
	        }
	        
	        
	        for(int i = 0; i < 9; i++){
	            int next = now;
	            
	            int x = i / 3;
	            int y = i % 3;
	            
	            for(int dir = 0; dir < 5; dir++){
	                int nx = x + dx[dir];
	                int ny = y + dy[dir];
	                
	                if(nx >= 0 && ny >= 0 && nx < 3 && ny < 3){
	                    int num = 3 * nx + ny;
	                    next = next ^ (1 << num);
	                }
	                
	            }
	            
	            if(vis[next] == 0){
	                dq.add(next);
	                vis[next] = vis[now] + 1;
	            }
	            
	        }
	        
	        
	    }
	}
	
}
