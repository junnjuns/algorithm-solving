import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main
{   
    static int n,m;
    static boolean[][][][] vis;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Point[] coin = new Point[2]; //동전의 위치 저장
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    board = new char[n][m];
	    vis = new boolean[n][m][n][m];
	    int coinCnt = 0;
	    
	    for(int i=0; i<n; i++){
	        String s = br.readLine();
	        for(int j=0; j<m; j++){
	            board[i][j] = s.charAt(j);
	            if(board[i][j] == 'o'){
	                coin[coinCnt] = new Point(i, j);
	                coinCnt += 1;
	            }
	        }
	    }
	    bw.write(bfs()+"");
	    bw.flush();
	    bw.close();
	}
	static int bfs(){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {coin[0].x, coin[0].y, coin[1].x, coin[1].y, 0});
	    vis[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = true;
	    
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        int cnt = now[4]; //버튼 누른 횟수
	        
	        
	        if(cnt >= 10){
	            return -1;
	        }
	        
	        for(int k=0; k<4; k++){
	            int drop = 0; //떨어진 동전 개수
	            int x1 = now[0] + dx[k];
	            int y1 = now[1] + dy[k];
	            int x2 = now[2] + dx[k];
	            int y2 = now[3] + dy[k];
	            
	            
	            if(x1<0 || y1<0 || x1>=n || y1>=m){ //밖일 때
	                drop += 1;
	            }
	            else if(board[x1][y1] == '#'){ //도착한 곳이 벽일 때
	                    x1 = now[0];
	                    y1 = now[1];
	            }
	            if(x2<0 || y2<0 || x2>=n || y2>=m){ //밖일 때
	                drop += 1;
	            }
	            else if(board[x2][y2] == '#'){ //도착한 곳이 벽일 때
	                    x2 = now[0];
	                    y2 = now[1];
	            }
	            
	            if(drop == 1){ //만약 동전이 하나만 떨어졌으면
	                return cnt + 1;
	            }
	            else if(drop == 0 && vis[x1][y1][x2][y2] == false){
	                dq.add(new int[] {x1, y1, x2, y2, cnt+1});
	                vis[x1][y1][x2][y2] = true;
	            }
	        }
	        
	    }
	    return -1;
	}
	
}
