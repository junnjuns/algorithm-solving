import java.util.*;
import java.io.*;

    
class Main {
    
    static int row, col;
    static int cnt;
    static int order;
    static int[][] board;
    static int[][] copy;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());
        
        board = new int[row][col];
        copy = new int[row][col];
        
        for(int h = 0; h < row; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < col; w++){
                board[h][w] = Integer.parseInt(st.nextToken());
                copy[h][w] = board[h][w];
            }
        } //초기 board 입력
        
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < cnt; idx++){
            order = Integer.parseInt(st.nextToken()); //명령어
            
            if(order == 1){ //상하 반전
                updown();
            }
            else if(order == 2){ //좌우 반전
                LeftRight();
            }
            else if(order == 3){ //오른쪽 90 도
                rotationRight();
            }
            else if(order == 4){ //왼쪽 90도 == 오른쪽 90도 3번
                rotationRight();
                rotationRight();
                rotationRight();
            }
            else if(order == 5){ //4등분 후 4개의 조각이 오른쪽 회전
                divRight();
                
            }
            else if(order == 6){ //4등분 한 후 4개의 조각이 왼쪽으로 회전 == //4등분 후 4개의 조각이 오른쪽 회전 3번
                divRight();
                divRight();
                divRight();
            }
            
        }
        
        for(int[] value : board){
            for(int v : value){
                bw.write(v+" ");
            }
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
    
    static void updown(){ //상하 반전
    
        int[][] boardTest = new int[row][col];
        for(int h = row-1; h >= 0 ; h--){
            for(int w = 0; w < col; w++){
                boardTest[h][w] = copy[row - h - 1][w];
            }
        }
        
        board = boardTest;
        copy = board;
        
    }
    
    static void LeftRight(){ //좌우 반전
    
        int[][] boardTest = new int[row][col];
        for(int h = 0; h < row; h++){
            for(int w = col-1; w >= 0; w--){
                boardTest[h][w] = copy[h][col - w - 1];
            }
        }
        board = boardTest;
        copy = board;
        
        
    }
    
    static void rotationRight(){ //오른쪽 90도 회전
        
        int[][] boardTest = new int[col][row];
        for(int h = 0; h < col; h++){
            for(int w = 0; w < row; w++){
                boardTest[h][w] = board[row - w - 1][h];
            }
        }
        int temp = col;
        col = row;
        row = temp;
        board = boardTest;
        copy = boardTest;
        
    }
    static void divRight(){ //4등분 후 4개의 조각이 오른쪽 회전
    
        int halfR = row/2;
        int halfC = col/2;
        
        int[][] boardTest = new int[row][col];
        
        for(int h = 0; h < halfR; h++){
            for(int w = halfC; w < col; w++){
                boardTest[h][w] = copy[h][w - halfC];
            }
        }
        
        for(int h = halfR; h < row; h++){
            for(int w = halfC; w < col; w++){
                boardTest[h][w] = copy[h - halfR][w];
            }
        }
        
        for(int h = halfR; h < row; h++){
            for(int w = 0; w < halfC; w++){
                boardTest[h][w] = copy[h][halfC + w];
            }
        }
        
        for(int h = 0; h < halfR; h++){
            for(int w = 0; w < halfC; w++){
                boardTest[h][w] = copy[h + halfR][w];
            }
        }
        
        board = boardTest;
        copy = boardTest;
        
        
       
        // 0, 0
        // 0, half + 1
        // half + 1, 0
        // half + 1, half + 1
        
    }
}
