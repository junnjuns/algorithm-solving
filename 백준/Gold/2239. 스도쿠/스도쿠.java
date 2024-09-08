import java.util.*;
import java.io.*;


public class Main {

    static int[][] board;
    static ArrayList<int[]> list;
    static int answer = Integer.MAX_VALUE;
    static boolean end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new int[9][9];
        list = new ArrayList<>();


        for(int row = 0; row < 9; row++){
            String input = br.readLine();
            for(int col = 0; col < 9; col++){
                board[row][col] = input.charAt(col) - '0';
                if(board[row][col] == 0){
                    list.add(new int[] {row, col});
                }
            }
        }

        fill(0);


        bw.flush();
        bw.close();
    }

    static void fill(int select){
        if (end){
            return;
        }
        //모든 0을 다 채웠다면 스도쿠 완성
        if(select == list.size()){

            for(int[] row : board){
                for(int col : row){
                    System.out.print(col);
                }
                System.out.println();
            }

            end = true;
            return;
        }

        int[] now = list.get(select);
        for(int idx = 1; idx <= 9; idx++){

            if(check(now[0], now[1], idx)){

                board[now[0]][now[1]] = idx;
                fill(select + 1);
                board[now[0]][now[1]] = 0;
            }
        }

    }

    static boolean check(int x, int y, int num){

        for(int idx = 0; idx < 9; idx++){
            if(board[x][idx] == num){
                return false;
            }
        }

        for(int idx = 0; idx < 9; idx++){
            if(board[idx][y] == num){
                return false;
            }
        }

        int nowX = 3 * (x / 3);
        int nowY = 3 * (y / 3);
        for(int row = nowX; row < nowX + 3; row++){
            for(int col = nowY; col < nowY + 3; col++){
                if(board[row][col] == num){
                    return false;
                }
            }
        }

        return true;
    }

}
