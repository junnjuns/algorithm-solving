import java.util.*;

class Solution {

    public int solution(int[] bandage, int health, int[][] attacks){
    
    int now = health;
    int lastATK = 0;
        
    int per;
    int bonus;
        
    for(int[] atk : attacks){
        if(now <= 0){
            return -1;
        }
        
        per = atk[0] - lastATK - 1;
        bonus = per / bandage[0];
        
        lastATK = atk[0];
        
        now = Math.min(health, now + per * bandage[1]);
        now = Math.min(health, now + bonus * bandage[2]);
        
        now -= atk[1];
    }
        
    return now <= 0 ? -1 : now;
    }
}