import java.util.*;
import java.io.*;

public class Main {
    
    static int totalTime;
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        totalTime = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        int answer = 0;
        
        for(int t = 0; t < totalTime; t++){
            
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if(type == 0){
                if(dq.size() != 0 ){
                    int[] now = dq.pollLast();
                    int nowScore = now[0];
                    int nowTime = now[1] - 1;
                    
                    
                    if(nowTime == 0){
                        
                        answer += nowScore;
                    }
                    else{
                        dq.add(new int[] {nowScore, nowTime});
                    }
                }
            }
            
            else{
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) - 1;
                
                if(time == 0){
                    answer += score;
                    continue;
                }
                
                dq.add(new int[] {score, time});
            }
        }
        
        bw.write(answer+"");
        
        bw.flush();
        bw.close();
    }
}
