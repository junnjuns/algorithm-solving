// 거꾸로 채워나가기
// 아래, 오른쪽, 위 , 왼쪽 순서로 동작하도록 구현

import java.util.*;
import java.io.*;

public class Main
{   
    
    static int size;
    static int target;
    static int[][] board;
    static Map<Integer, int[]> map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0 , -1};
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    size = Integer.parseInt(br.readLine());
	    target = Integer.parseInt(br.readLine());
	    
	    board = new int[size][size];
	    map = new HashMap<>(); //좌표 저장용 map : (값, 좌표)
	    
        int x = 0;
        int y = 0;
        
	    board[x][y] = size * size; //초기 값
	    map.put(board[x][y], new int[] {x + 1, y + 1});
	    
	    while(true){
	        if(board[x][y] == 1){
	            break;
	        }
	        
	        for(int dir = 0; dir < 4; dir++){
	            
	            while(true){
    	            int nx = x + dx[dir];
    	            int ny = y + dy[dir];
    	            
    	            if(check(nx, ny) && board[nx][ny] == 0){
    	                board[nx][ny] = board[x][y] - 1;
    	                map.put(board[nx][ny], new int[] {nx + 1, ny + 1});
    	                x = nx;
    	                y = ny;
    	            }
    	            else{
    	                break;
    	            }
    	            
	            }

	        }

	    }
	    
	    
	    for(int[] arr : board){
	        for(int n : arr){
	            bw.write(n+" ");
	        }
	        bw.newLine();
	    }
	    bw.write(map.get(target)[0]+" "+map.get(target)[1]);
	    
	    bw.flush();
	    bw.close();
	}
	
	static boolean check(int x, int y){
	    return x >= 0 && y >= 0 && x < size && y < size;
	}
}
