import java.util.*;
import java.io.*;

public class Main
{
    
    static int N;
    static int M;
    static int[][] arr;
    static int max;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        
        for(int row = 0; row < N; row++){
            String str = br.readLine();
            for(int col = 0; col < M; col++){
                arr[row][col] = str.charAt(col) -'0';
            }
        } //초기화 끝
        
        max = 1;
        
        //로직 시작
        for(int row = 0; row < N; row++){
            for(int col = 0; col < M; col++){
                func(arr[row][col], row, col);
            }
        }
	    
	    sb.append(max*max);
	    System.out.print(sb.toString());
	    
	}
	
	static void func(int num, int row, int col){
	    int edge = 1; // 변의 길이
	    int nextCol = col;
	    
	    //가로 계산
	    for(int c = col; c < M; c++){
	        if(num == arr[row][c]){
	            edge = c - col + 1;
	            nextCol = c;
	            
	            // 세로 계산
        	    if(checkRange(row + edge - 1, nextCol) && num == arr[row + edge - 1][nextCol] && num == arr[row + edge -1][col]){
        	        max = Math.max(max, edge);
        	    }
	        }
	    }
	    
	}
	
	
	static boolean checkRange(int row, int col){
	    return row < N && col < M;
	}
}
