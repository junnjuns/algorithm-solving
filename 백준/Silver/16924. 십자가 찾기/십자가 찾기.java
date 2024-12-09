import java.util.*;
import java.io.*;

public class Main
{   
    static int row;
    static int col;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<int[]> list;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    row = Integer.parseInt(st.nextToken());
	    col = Integer.parseInt(st.nextToken());
	    list = new ArrayList<>();
	    
	    board = new char[row][col];
	    vis = new boolean[row][col];
	    
	    for(int h = 0; h < row; h++){
	        String str = br.readLine();
	        for(int w = 0; w < col; w++){
	            board[h][w] = str.charAt(w);
	        }
	    }
	    
	    // 각 셀에 대해 가능한 최대 십자가 크기 계산
	    for(int h = 0; h < row; h++){
	        for(int w = 0; w < col; w++){
	            if(board[h][w] == '*'){
	                int maxSize = getMaxCrossSize(h, w);
	                
	                    if(maxSize > 0){
	                        placeCross(h, w, maxSize);
	                        list.add(new int[] {h + 1, w + 1, maxSize});
	                    }
	            }	        
	        }
	    }
	    
	    // 모든 '*'가 커버되었는지 확인
	    boolean isPossible = true;
	    
	    for(int h = 0; h < row; h++){
	        for(int w = 0; w < col; w++){
                if(board[h][w] == '*' && !vis[h][w]){
                    isPossible = false;
                }	        
	        }
	    }
	    
	    if(isPossible){
	        bw.write(list.size()+"\n");
	        
	        for(int[] now : list){
	            bw.write(now[0]+" "+now[1]+" "+now[2]+"\n");
	        }
	        
	    }
	    else{
	        bw.write("-1");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static int getMaxCrossSize(int x, int y){
	    
	    int size = 0;
	    
	    while(true){
	        boolean possible = true;
	        for(int dir =0; dir <4; dir++){
	            
	            int nx = x + dx[dir]*(size+1);
	            int ny = y + dy[dir]*(size+1);
	            
	            if(!possible(nx, ny)){
	                possible = false;
	                break;
	            }
	        }
	        if(possible){
	            size += 1;
	        }
	        else{
	            break;
	        }
	    }
	    return size;
	}
	
	static void placeCross(int x, int y, int size){
	    
	    vis[x][y] = true; // 중심점 마킹
        for(int dir = 0; dir < 4; dir++){
            for(int k = 1; k <= size; k++){
                
                int nx = x + dx[dir] * k;
                int ny = y + dy[dir] * k;
                
                vis[nx][ny] = true;
                
            }
        }
	}
	
	static boolean possible(int x, int y){
	    return x >= 0 && y >= 0 && x < row && y < col && board[x][y] == '*';
	}
}
