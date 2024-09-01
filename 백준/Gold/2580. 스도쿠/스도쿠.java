import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static int[][] board;
    static ArrayList<int[]> list;
    static BufferedWriter bw;
    static boolean end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        board = new int[9][9];
        list = new ArrayList<>();

        for(int row = 0; row < 9; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < 9; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
                if(board[row][col] == 0){
                    list.add(new int[] {row, col});
                }
            }
        }

        fill(0);

        bw.flush();
        bw.close();
    }

    static void fill(int select) throws Exception {
        if(end){
            return;
        }
        if(select == list.size()){

            for(int[] row : board){
                for(int col : row){
                    bw.write(col+" ");
                }
                bw.newLine();
            }
            end =true;
            return;
        }

        int[] point = list.get(select);
        for(int idx = 1; idx <= 9; idx++){
            if(check(point[0], point[1], idx)){
                board[point[0]][point[1]] = idx;
                fill(select + 1);
                board[point[0]][point[1]] = 0;
            }
        }
    }

    static boolean check(int x, int y, int number){

        //가로 확인
        for(int idx = 0; idx < 9; idx++){
            if(board[x][idx] == number){
                return false;
            }
        }

        //세로 확인
        for(int idx = 0; idx < 9; idx++){
            if(board[idx][y] == number){
                return false;
            }
        }

        //속해있는 칸 확인

        int startX = x - x % 3;
        int startY = y - y % 3;

        for(int row = startX; row < startX + 3; row++){
            for(int col = startY; col < startY + 3; col++){
                if(board[row][col] == number){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean range(int x, int y){
        return (x >= 0 && y >= 0 && x < 9 && y <9);
    }
}
