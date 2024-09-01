import java.util.*;
import java.io.*;

//board를 생성하면서 cctv를 찾으면 cctv의 좌표와 타입을 갖고있는 cctv 객체를 생성 후 리스트에 추가한다.
//list 내부에 있는 cctv들을 모두 확인하는 시뮬레이션을 실행한다.
    //list 내부에 있는 cctv를 하나씩 확인한다.
        //cctv의 종류에 따라 확인 할 수 있는 시야가 존재한다. 때문에 각 cctv의 타입에 따라 봐야할 시야를 확인한다.
        //시야를 확인 할 때 벽이 아니면 모두 확인 가능하다. 확인했다는 표시를 할 때 cctv끼리 겹칠 수 있기 때문에 한번 확인할 때 한 가지로 방법으로 초기화 하는것이 아닌 -1씩 추가한다.
        //cctv의 한 방향을 모두 봤으면 다음 cctv를 확인하는 재귀 함수 실행한다.
        //확인했던 곳을 다시 원상복구한다.
    //만약 모든 cctv를 다 확인했다면 재귀 종료
        //board를 확인하면서 사각지대를 count한다.
        //각각의 시뮬레이션에서 가장 작은 값을 answer에 초기화한다.
//answer 출력

public class Main {

    //cctv 클래스
    static class CCTV{
        int x;
        int y;
        int type;

        public CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static int answer;
    static int height;
    static int width;
    static int[][] board;
    static ArrayList<CCTV> cctvs;
    //우 하 좌 상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][][] direction = {
            {{0},{1},{2},{3}}, //1번
            {{0,2}, {1,3}}, //2번
            {{0,1}, {1,2}, {2,3}, {3,0}}, //3번
            {{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}}, //4번
            {{0,1,2,3}} //5번
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        board = new int[height][width];

        //cctv 리스트 생성
        cctvs = new ArrayList<>();
        //board 입력
        for(int row = 0; row < height; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < width; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
                //cctv 일 때 list에 추가
                if(board[row][col] != 0 && board[row][col] != 6){
                    cctvs.add(new CCTV(row, col, board[row][col]));
                }
            }
        }
        //초기 값 설정
        answer = Integer.MAX_VALUE;

        //시뮬레이션 시작
        simulation(0);

        bw.write(answer+"");
        bw.flush();
        bw.close();
    }

    static void simulation(int dep){
        //모든 cctv를 다 확인했을 때
        if(dep == cctvs.size()){
            int res = 0;

            for(int[] col : board){
                for(int value : col){
                    if(value == 0){
                        res++;
                    }
                }
            }

            answer = Math.min(answer, res);

            return;
        }

        CCTV cctvNow = cctvs.get(dep);
        int directionCount = direction[cctvNow.type - 1].length;
        // 1번 : 4번
        // 2번 : 2번
        // 3번 : 4번
        // 4번 : 4번
        // 5번 : 1번
        for(int idx = 0; idx < directionCount; idx++){

            watch(cctvNow, direction[cctvNow.type - 1][idx]);
            simulation(dep + 1);
            reset(cctvNow, direction[cctvNow.type - 1][idx]);

        }

    }

    static void watch(CCTV cctv, int[] directionArr ){
        //해당 방향으로 감시
        for(int dir = 0; dir < directionArr.length; dir++){

            int nx = cctv.x;
            int ny = cctv.y;
            int nowDir = directionArr[dir];
            while(true){
                nx += dx[nowDir];
                ny += dy[nowDir];

                //범위 이내
                if(nx >= 0 && ny >= 0 && nx < height && ny < width){
                    //벽이 아니면 탐색 처리
                    if(board[nx][ny] == 0){
                        board[nx][ny] = -1;
                    }
                    //0보다 작다면 이미 지나온 곳
                    else if(board[nx][ny] < 0){
                        board[nx][ny] -= 1;
                    }
                    //cctv이면
                    else if((1 <= board[nx][ny] && board[nx][ny] <= 5)){
                        continue;
                    }
                    //벽이면 탐색 종료
                    else if(board[nx][ny] == 6){
                        break;
                    }
                }
                //범위를 넘어섰으면 종료
                else{
                    break;
                }

            }
        }
    }
    static void reset(CCTV cctv, int[] directionArr){


        for(int dir = 0; dir < directionArr.length; dir++){

            int nx = cctv.x;
            int ny = cctv.y;
            int nowDir = directionArr[dir];

            while(true){
                nx += dx[nowDir];
                ny += dy[nowDir];

                //범위 이내
                if(nx >= 0 && ny >= 0 && nx < height && ny < width){
                    //방문 했던 곳이면 + 1
                    if(board[nx][ny] < 0){
                        board[nx][ny] += 1;
                    }
                    //cctv이면 다음으로 확인
                    else if(1 <= board[nx][ny] && board[nx][ny] <= 5){
                        continue;
                    }
                    //벽이면 종료
                    else if(board[nx][ny] == 6){
                        break;
                    }
                }
                //범위를 넘어섰으면 종료
                else{
                    break;
                }

            }
        }
    }
}
