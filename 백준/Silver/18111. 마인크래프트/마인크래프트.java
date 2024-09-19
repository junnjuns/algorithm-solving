import java.util.*;
import java.io.*;


public class Main {

    static int n, m;
    static int blockCnt;
    static int[][] board;
    static int workTime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        blockCnt = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int h = 0; h < n; h++){
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < m; w++){
                board[h][w] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[h][w]);
                max = Math.max(max, board[h][w]);
            }
        }
        int answerTime = Integer.MAX_VALUE;
        int answerH = 0;

        for(int cur = min; cur <= max; cur++){
            int time = 0;
            int block = 0;
            for(int h = 0; h < n; h++){
                for(int w = 0; w < m; w++){
                    if(board[h][w] > cur){
                        time += 2 * (board[h][w] - cur);
                        block += board[h][w] - cur;
                    }
                    else if(board[h][w] < cur){
                        time +=  cur - board[h][w];
                        block -= cur - board[h][w];
                    }
                }
            }
            if(blockCnt + block >= 0){
                if(answerTime > time){
                    answerTime = time;
                    answerH = cur;
                }
                if(answerTime == time && answerH < cur){
                    answerTime = time;
                    answerH = cur;
                }
            }
        }


        bw.write(answerTime+" "+answerH);
        bw.flush();
        bw.close();
    }
}
