import java.util.*;
import java.io.*;

//선수는 총 9명
//이닝이 지나도 타순은 유지되어야 한다.
//최대 점수를 얻을 수 있도록 각 이닝에서 타순을 정해야 한다.(단 , 1번 선수는 항상 4번 타자)


//   1. 이닝 수 입력 받기
//   2. 각 선수의 이닝 결과 입력 받기
//   3. 4번 타자는 항상 1번 선수로 설정
//   4. 나머지 선수들의 타순을 결정하기 위해 순열 호출
//   5. 타순이 결정되면 해당 순서로 경기를 시작
//      5-1. 각 이닝마다 현재 선수의 결과에 따라 점수를 계산
//      5-2. 3아웃이 되면 다음 이닝으로 넘어감
//   6. 경기가 끝나면 점수를 갱신하여 최대 점수를 기록
//   7. 모든 순열을 시도한 후, 최대 점수를 출력
 

public class Main {
    static int[][] player; // 선수들 이닝 결과 저장 배열
    static int[] lineUp = new int[10]; // 내가 뽑은 선발 라인업 배열(4번 인덱스는 항상 1번 선수)
    static int inning; // 이닝 수
    static boolean[] vis = new boolean[10]; // 선발 라인업 뽑을 때 방문 배열 활용
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    
        inning = Integer.parseInt(br.readLine()); // 이닝 수 입력
    
        
        player = new int[10][inning]; 
        
        for(int idx = 0; idx < inning; idx++) {
            st = new StringTokenizer(br.readLine());
            for(int person = 1; person < 10; person++) {
                player[person][idx] = Integer.parseInt(st.nextToken()); //각 선수의 이닝마다의 결과 입력 받음
            }
        }
    
        lineUp[4] = 1; // 4번 타자는 항상 1번 선수
        vis[4] = true;
        
        permut(2); // 2번 선수부터 넣어준다. 1번은 이미 넣음
    
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
    
    static void permut(int playerNum) {
        if (playerNum == 10) { // 1 ~ 9 번 선수까지 다 넣어줬으면 경우의 수 생성 완료
            
            gameStart(); // 경기 시작
            
            return;
        }
    
        for (int idx = 1; idx < 10; idx++) { // 경기에 출전 순서 : 1 ~ 9 번 순서 정하기
            if (vis[idx])
                continue; // 이미 뽑은 선수이면 넘어감
    
            vis[idx] = true; // 선수 뽑기
            lineUp[idx] = playerNum; // 각 순서(idx)에 선수(playerNum)를 넣어준다.
            permut(playerNum + 1); // 다음 선수 뽑기
            vis[idx] = false;
        }
    }
    
    static void gameStart() { // 선발 라인업 완성 후 경기 시작
    
        int score = 0; // 경기 결과 점수
        int nowTurn = 1; // 현재 선발 순서 : 1번 선수부터 시작(이닝이 바뀌어도 초기화 되지 않음)
        int curInning = 0; //현재 이닝 
        
        for (int idx = 0; idx < inning; idx++) { // 입력받은 inning 만큼 이닝 진행
    
            int[] base = new int[4]; // 야구 베이스 : 1루 2루 3루 홈
            int outCnt = 0; // 이닝 시작 직후 아웃 카운트 : 0
    
    
            while (true) { // 이닝 시작
                
                int res = player[lineUp[nowTurn]][curInning]; // 현재 선수의 결과를 res에 저장
                
                
                if (res == 0) { // 만약 아웃이면
    
                    outCnt += 1; // 아웃 카운트 1 증가
                    if (outCnt == 3) { // 3아웃이면 이닝 종료
                        break;
                    }
    
                }
                
                
                else if (res == 1) { // 만약 1루타 일 때
                    for (int baseIdx = 2; baseIdx >= 0; baseIdx--) { // 3루 부터 1루순으로  확인한다.
                        
                        if(base[baseIdx] == 1){ //만약 해당 루에 사람이 있으면 
                            base[baseIdx] = 0; // 이동해야 되기 때문에 0으로 초기화
                            
                            if(baseIdx + res >= 3){ //만약 홈 or 홈 이상으로 가면 점수 + 1
                                score += 1;
                            }
                            else{ //아직 홈에 도착하지 않으면 해당 루에 사람을 위치 시킴
                                base[baseIdx + res] = 1;
                            }
                        }
                        
                    }
                    base[res - 1] = 1; // 1루타를 친 타자를 1루에 보낸다.
                }
    
                else if (res == 2) { // 만약 2루타 일 때
                    for (int baseIdx = 2; baseIdx >= 0; baseIdx--) { //1루타와 동일
                        
                        if(base[baseIdx] == 1){
                            base[baseIdx] = 0;
                            
                            if(baseIdx + res >= 3){
                                score += 1;
                            }
                            else{
                                base[baseIdx + res] = 1;
                            }
                        }
                        
                    }
                    base[res - 1] = 1;
                }
    
                else if (res == 3) { // 만약 3루타 일 때
                    for (int baseIdx = 2; baseIdx >= 0; baseIdx--) { //1루타와 동일
                        
                        if(base[baseIdx] == 1){
                            base[baseIdx] = 0;
                            
                            if(baseIdx + res >= 3){
                                score += 1;
                            }
                            else{
                                base[baseIdx + res] = 1;
                            }
                        }
                        
                    }
                    base[res - 1] = 1;
                }
    
                else if (res == 4) { // 만약 홈런 일 때
                    for (int baseIdx = 0; baseIdx < 4; baseIdx++) {
                        if (base[baseIdx] == 1) {
                            base[baseIdx] = 0; // 홈런이기 때문에 base 모두 0으로 초기화
                            score += 1; // 1의 개수 만큼 점수 증가
                        }
                    }
                    score += 1;
                }
                nowTurn += 1;
                nowTurn = nowTurn == 10 ? 1 : nowTurn; //타순을 다음 타순으로 업데이트함. 만약 현재 9번 타자이면 다시 1번부터 시작
                
            } // 이닝 끝
            nowTurn += 1;
            nowTurn = nowTurn == 10 ? 1 : nowTurn;
            
            curInning += 1;
        } // 모든 이닝 끝
    
        answer = Math.max(answer, score);
    }
}