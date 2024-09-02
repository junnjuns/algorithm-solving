import java.util.*;
import java.io.*;



public class Main {

    static int cityCnt;
    static int[][] board;
    static boolean[] vis;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //도시의 수
        cityCnt = Integer.parseInt(br.readLine());

        board = new int[cityCnt][cityCnt];

        //인접 행렬 초기화
        for(int row = 0; row < cityCnt; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < cityCnt; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        vis = new boolean[cityCnt];

        for(int idx = 0; idx < cityCnt; idx++){
            vis[idx] = true;
            simulation(1,0,idx, idx);
            vis[idx] = false;
        }


        bw.write(min+"");
        bw.flush();
        bw.close();
    }

    static void simulation(int dep, int sum, int city, int cur){
        if(dep == cityCnt){
            if(board[cur][city] != 0){
                sum += board[cur][city];
                min = Math.min(min, sum);
            }

             return;
        }

        for(int col = 0; col < cityCnt; col++){
            if(vis[col] || board[cur][col] == 0) continue;

            vis[col] = true;
            simulation(dep + 1, sum + board[cur][col], city, col);
            vis[col] = false;
        }
    }
}

