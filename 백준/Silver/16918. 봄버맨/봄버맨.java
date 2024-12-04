import java.util.*;
import java.io.*;

public class Main {
    
    static int row;
    static int col;
    static int time;
    static char[][] board;
    static int[][] boomTime;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        board = new char[row][col];
        boomTime = new int[row][col];

        for (int h = 0; h < row; h++) {
            String str = br.readLine();
            for (int w = 0; w < col; w++) {
                char now = str.charAt(w);
                board[h][w] = now;
                
            }
        }

        // 시뮬레이션을 1초부터 시작하여 time초까지 진행
        for (int t = 1; t <= time; t++) {
            if (t % 2 == 0) { // 짝수 초에는 모든 빈 칸에 폭탄 설치
                for (int h = 0; h < row; h++) {
                    for (int w = 0; w < col; w++) {
                        if (board[h][w] == '.') {
                            board[h][w] = 'O';
                            boomTime[h][w] = t; // 현재 시간을 설치 시간으로 설정
                        }
                    }
                }
            } 
            else { // 홀수 초에는 폭발 처리 
                if (t > 1) {
                    ArrayList<int[]> explodeList = new ArrayList<>();
                    
                    for (int h = 0; h < row; h++) {
                        for (int w = 0; w < col; w++) {
                            if (board[h][w] == 'O' && (t - boomTime[h][w]) == 3) {
                                explodeList.add(new int[]{h, w});
                            }
                        }
                    }

                    // 폭발 적용
                    for (int[] pos : explodeList) {
                        int h = pos[0];
                        int w = pos[1];
                        // 폭탄이 터진 위치
                        board[h][w] = '.';
                        boomTime[h][w] = -1; // 폭발한 폭탄의 시간을 음수로 설정하여 다시 폭발하지 않도록 함

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = h + dx[dir];
                            int ny = w + dy[dir];

                            if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                                if (board[nx][ny] == 'O') {
                                    board[nx][ny] = '.';
                                    boomTime[nx][ny] = -1; // 폭발로 제거된 폭탄의 시간을 음수로 설정
                                }
                            }
                        }
                    }
                }
            }
        }

        for (char[] arr : board) {
            for (char c : arr) {
                bw.write(c+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
