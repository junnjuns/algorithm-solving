import java.util.*;
import java.io.*;


public class Main
{   
    static int row, col;
    static char[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    row = Integer.parseInt(st.nextToken());
	    col = Integer.parseInt(st.nextToken());
	    
	    board = new char[row][col];
	    
	    
	    for(int h = 0; h < row; h++){
	        String str = br.readLine();
	        for(int w = 0; w < col; w++){
	            board[h][w] = str.charAt(w);
	        }
	    } //입력 끝
	    
	    int answer = Integer.MIN_VALUE;
	    for(int h = 0; h < row; h++){
	        for(int w = 0; w < col; w++){
	            //육지일때만 탐색 ㄱㄱ
	            if(board[h][w] == 'L'){
	                vis = new int[row][col];
	                answer = Math.max(answer, bfs(h, w));
	            }            
	        }
	    }
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	static int bfs(int sx, int sy){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {sx, sy});
	    vis[sx][sy] = 1;
	    
        int num = 0;	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        num = vis[now[0]][now[1]];
	        for(int dir = 0; dir < 4; dir++){
	            int nx = now[0] + dx[dir];
	            int ny = now[1] + dy[dir];
	            
	            //만약 범위 안 + 땅일 때
	            if(check(nx, ny) && board[nx][ny] =='L'){
	                //방문 안했을 때
	                if(vis[nx][ny] == 0){
	                    vis[nx][ny] = vis[now[0]][now[1]] + 1;
	                    dq.add(new int[] {nx, ny});
	                }
	            }
	        }
	        
	    }
	    return num - 1;
	}
	
	static boolean check(int x, int y){
	    return x >= 0 && y >= 0 && x < row && y < col;
	}
}
