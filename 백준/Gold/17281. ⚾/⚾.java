import java.util.*;
import java.io.*;

//선수는 총 9명
//이닝이 지나도 타순은 유지되어야 한다.
//최대 점수를 얻을 수 있도록 각 이닝에서 타순을 정해야 한다.(단 , 1번 선수는 항상 4번 타자)

//경기 시작 전 선발 라인업 정하기 (단, 4번 타자는 무조건 1번 선수) 

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
            
            // for(int idx = 1; idx < 10; idx++){
            //     System.out.print(lineUp[idx]+" ");    
            // }
            // System.out.println();
            gameStart(); // 경기 시작
            // System.out.println();
            // System.out.println();
            // ㅇ ㅇ ㅇ 1 ㅇ ㅇ ㅇ ㅇ ㅇ
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
                
                //System.out.print("- "+lineUp[nowTurn]+" : ");
                int res = player[lineUp[nowTurn]][curInning]; // 현재 선수의 결과를 res에 저장
                
                //System.out.println("현재 선수 결과: "+res+" 아웃: "+outCnt +" 점수: "+score);
                
                //System.out.println(res);
                
                if (res == 0) { // 만약 아웃이면
    
                    outCnt += 1; // 아웃 카운트 1 증가
                    if (outCnt == 3) { // 3아웃이면 이닝 종료
                        break;
                    }
    
                }
                
                
                else if (res == 1) { // 만약 1루타 일 때
                    for (int baseIdx = 2; baseIdx >= 0; baseIdx--) {
                        
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
    
                else if (res == 2) { // 만약 2루타 일 때
                    for (int baseIdx = 2; baseIdx >= 0; baseIdx--) {
                        
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
                    for (int baseIdx = 2; baseIdx >= 0; baseIdx--) {
                        
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
                //System.out.println(nowTurn);
                nowTurn += 1;
                nowTurn = nowTurn == 10 ? 1 : nowTurn;
                // for(int i : base){
                //     System.out.print(i+" ");
                // }
                // System.out.println();
                
            } // 이닝 끝
            nowTurn += 1;
            nowTurn = nowTurn == 10 ? 1 : nowTurn;
            
            curInning += 1;
        } // 모든 이닝 끝
    
        answer = Math.max(answer, score);
    }
}