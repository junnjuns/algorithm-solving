import java.util.*;
import java.io.*;

class Main {
    
    static int[][] country = new int[6][3];
    static boolean possible;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        for(int test = 0 ; test < 4; test++){
            
            boolean check = true;
            st = new StringTokenizer(br.readLine());
            
            for(int h = 0 ; h < 6; h++){
                int gameCnt = 0;
                for(int w = 0; w < 3; w++){
                    country[h][w] = Integer.parseInt(st.nextToken());
                    if(country[h][w] != 0){
                        gameCnt += country[h][w];
                    }
                }
                
                if(gameCnt != 5){ //만약 현재 나라의 경기수가 5경기가 아닐 경우 해당 테스트는 불가능한 결과.
                    check = false;
                    break;
                }
            } //모든 경기 입력 끝
            
            if(check){
                possible = false;
                checkGame(0, 1); //0번째 나라와 1번째 나라부터 확인 시작
                
                if(possible){
                    bw.write("1 ");
                }
                else{
                    bw.write("0 ");   
                }
            }
            else{
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
    }
    
    static void checkGame(int now, int next) throws Exception {
        if(now == 5){ //가장 마지막 나라까지 도착했으면
            possible = true;
            return;
        }
        
        if(next == 6){ //next(상대 나라)를 다 보았을 때
            checkGame(now + 1, now + 2);
        }
        
        if(country[now][0] > 0 && country[next][2] > 0){ //승리 했을 떄
            country[now][0] -= 1;
            country[next][2] -= 1;
            checkGame(now, next + 1);
            country[now][0] += 1;
            country[next][2] += 1;
        }
        if(country[now][1] > 0 && country[next][1] > 0){ // 무승부 일 때
            country[now][1] -= 1;
            country[next][1] -= 1;
            checkGame(now, next + 1);
            country[now][1] += 1;
            country[next][1] += 1;
        }
        if(country[now][2] > 0 && country[next][0] > 0){ // 패배 했을 떄
            country[now][2] -= 1;
            country[next][0] -= 1;
            checkGame(now, next + 1);
            country[now][2] += 1;
            country[next][0] += 1;
        }
    }
}
