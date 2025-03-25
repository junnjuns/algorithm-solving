// t초 동안 붕대 감기
// 1초마다 체력 x 회복
// 연속으로 붕대감기 성공하면 체력 y 추가 회복
// [t, x, y]
// 최대 체력
// [공격 시간, 피해량]
import java.util.*;
import java.io.*;
class Solution {
    
    static int runtime;
    static int recovery;
    static int recoveryAdd;
    static int nowLife;
    static int time;
    static int recovering;
    static int total;
    
    public int solution(int[] bandage, int health, int[][] attacks){
        
        runtime = bandage[0];
        recovery = bandage[1];
        recoveryAdd = bandage[2];
        nowLife = health;
        total = health;
        
        //공격 횟수
        int attackCnt = 0;
        
        
        while(true){
            
            time += 1;
            
            int attackTime = attacks[attackCnt][0];
            int demage = attacks[attackCnt][1];
            //공격 시간일 때
            if(time == attackTime){
                attackCnt += 1; //공격 횟수 추가
                recovering = 0; //연속 회복 초기화
                
                nowLife -= demage; //데미지 입음
                if(nowLife <= 0){ //사망
                    return -1;
                }
                //모든 공격 끝나면 중지
                if(attackCnt == attacks.length){
                    break;
                }
            }
            //공격 시간 아닐 때
            else{
                //회복
                healthy(recovery);
                //추가 회복
                if(recovering == runtime){
                    healthy(recoveryAdd);
                    recovering = 0;
                }
            }
                  
        }
        
        return nowLife;
    }
    
    static public void healthy(int add){
        if(nowLife + add > total){
            nowLife = total;
            
        }
        else{
            nowLife += add;
            
        }
        recovering += 1;
    }
}