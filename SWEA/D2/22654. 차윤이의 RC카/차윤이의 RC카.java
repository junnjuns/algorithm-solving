import java.util.*;
import java.io.*;


public class Solution {

    static char[][] board; //필드
    static int size; //필드의 크기
    static int[] dir = {0,1,2,3};
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] vis;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            bw.write("#"+t+" ");

            size = Integer.parseInt(br.readLine());

            board = new char[size][size];

            int startX = 0;
            int startY = 0;

            for(int h = 0; h < size; h++){
                String str = br.readLine();
                for(int w = 0; w < size; w++){
                    board[h][w] = str.charAt(w);
                    if(board[h][w] == 'X'){
                        startX = h;
                        startY = w;
                    }
                }
            }

            int cnt = Integer.parseInt(br.readLine());

            for(int idx = 0; idx < cnt; idx++){

                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                String command = st.nextToken();

                vis = new boolean[size][size];

                vis[startX][startY] = true;

                int x = startX;
                int y = startY;
                int nowDir = 0;

                boolean check = false;

                //시뮬레이션
                for(int i=0; i < num; i++){
                    char ch = command.charAt(i);

                    if(ch == 'A'){
                        int nx = x + dx[nowDir];
                        int ny = y + dy[nowDir];

                        if(possible(nx, ny) && board[nx][ny] != 'T'){
                                x = nx;
                                y = ny;
                        }

                    }
                    else if(ch == 'L'){
                        nowDir = (nowDir + 3) % 4;
                    }
                    else if(ch == 'R'){
                        nowDir = (nowDir + 1) % 4;
                    }

                }
                if(board[x][y] == 'Y'){
                    bw.write("1 ");
                }
                else{
                    bw.write("0 ");
                }

            }

            bw.newLine();
        }


        bw.flush();
        bw.close();
    }


    static boolean possible(int x, int y){
        return x >= 0 && y >= 0 && x < size && y < size;
    }
}
