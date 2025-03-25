import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vdo = changeSecond(video_len);
        int now = changeSecond(pos);
        int ops = changeSecond(op_start);
        int ope = changeSecond(op_end);
        
        for(String str : commands){
            
            if(ops <= now && now <= ope){
                now = ope;
            }
            
            if(str.equals("next")){
                now += 10;
                if(now > vdo){
                    now = vdo;
                }
            }
            else{
                now -= 10;
                if(now < 0){
                    now = 0;
                }
            }
            if(ops <= now && now <= ope){
                now = ope;
            }
        }
        
        return changeString(now);
    }
    
    static int changeSecond(String s){
        String[] arr = s.split(":");
        int minute = Integer.parseInt(arr[0]) * 60;
        int second = Integer.parseInt(arr[1]);
        return minute + second;
    }
    static String changeString(int s){
        int minute = (s / 60);
        int second = (s % 60);
        return String.format("%02d:%02d", minute, second);
    }
}