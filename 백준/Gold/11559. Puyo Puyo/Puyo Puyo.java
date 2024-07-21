import java.util.*;
import java.io.*;


public class Main
{   
    static char[][] board = new char[12][6];
    static char[] color = {'R', 'B', 'Y', 'G', 'P'};
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] vis;
    static boolean check;
    static ArrayList<int[]> list;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    for(int col = 0; col < 12; col++){
	        String s = br.readLine();
	        for(int row = 0; row < 6; row++){
	            board[col][row] = s.charAt(row);
	        }
	    }
	    
	    int count = 0;
	    
	    while(true){
	        check = false; //연쇄가 없는 상태.
	        list = new ArrayList<int[]>();
	        
	        for(int c = 0; c < 5; c++){
	            
	            vis = new boolean[12][6];
	            
	            for(int col = 0; col < 12; col++){
	                for(int row = 0; row < 6; row++){
	                    if(board[col][row] == color[c]){
	                        bfs(col, row, color[c]);
	                    }
	                }
	            }
	        } //각 컬러 별 bfs 끝
	        
	        if(!check){ //bfs 다 돌아도 연쇄가 없으면 break
	            break;
	        }
	        
	        for(int[] arr : list){
	            int x = arr[0];
	            int y = arr[1];
	            board[x][y] = '.';
	        } // list에 있던 좌표를 . 으로 초기화
	        
	        for(int col = 10; col >= 0; col--){
	            for(int row = 0; row < 6; row++){
	                boolean point = false;
	                int cm = 0;
	                for(int i = col + 1; i < 12; i++){
	                    if(board[i][row] == '.'){
	                        point = true;
	                        cm++;
	                    }
	                    else{
	                        break;
	                    }
	                }
	                if(point){
	                    board[col+cm][row] = board[col][row];
	                    board[col][row] = '.';
	                }
	            }
	        }
	        
	        count++;
	    }
	    
	    bw.write(count+"");
	    bw.flush();
	    bw.close();
	}
	
	static void bfs(int i, int j, char nowColor){
	    ArrayDeque<int[]> dq = new ArrayDeque<>();
	    dq.add(new int[] {i, j});
	    vis[i][j] = true;
	    ArrayList<int[]> nowList = new ArrayList<>();
	    nowList.add(new int[] {i, j});
	    
	    while(dq.size() != 0){
	        int[] now = dq.poll();
	        
	        
	        for(int k=0; k<4; k++){
	            int x = now[0] + dx[k];
	            int y = now[1] + dy[k];
	            
	            if(x >= 0 && y >= 0 && x < 12 && y < 6){
	                if(board[x][y] == nowColor && vis[x][y] == false){
	                    dq.add(new int[] {x, y});
	                    vis[x][y] = true;
	                    nowList.add(new int[] {x, y});
	                }
	            }
	        }
	    }
	    if(nowList.size() >= 4){
	        check = true;
	        for(int[] arr : nowList){
	            list.add(arr);
	        }
	    }
	}
}
