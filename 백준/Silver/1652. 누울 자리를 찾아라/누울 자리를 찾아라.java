// N x N 방
// 연속해서 2 칸 이상의 빈 칸이면 누울 수 있다.
// 가로, 세로로 누울 수 있다.

import java.util.*;
import java.io.*;

public class Main
{
    static int size;
    static char[][] board;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        size = Integer.parseInt(br.readLine());
        board = new char[size][size];
        
        int width = 0;
        for(int row = 0; row < size; row++){
            
            String str = br.readLine();
            int cnt = 0;
            boolean check = false;
            
            for(int col = 0; col < size; col++){
                board[row][col] = str.charAt(col);
                if(board[row][col] == '.'){
                    cnt += 1;
                }
                else{
                    cnt = 0;
                    check = false;
                }
                if(cnt == 2){
                    check = true;
                    width += 1;
                }
            }
        }  // board 초기화하면서 가로 계산
        
        int height = 0;
        for(int col = 0; col < size; col++){
            
            int cnt = 0;
            boolean check = false;
            
            for(int row = 0; row < size; row++){
                if(board[row][col] == '.'){
                    cnt += 1;
                }
                else{
                    cnt = 0;
                    check = false;
                }
                
                if(cnt == 2){
                    check = true;
                    height += 1;
                }
            }
        } 
        
        
        
        
        bw.write(width+" "+height);
        bw.flush();
        bw.close();
        
    }
}
