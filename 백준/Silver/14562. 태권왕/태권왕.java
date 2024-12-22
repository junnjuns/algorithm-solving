import java.util.*;
import java.io.*;

public class Main {
    
    
    static int userA;
    static int userB;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int test = Integer.parseInt(br.readLine());
        
        
        for(int t = 0; t < test; t++){
            st = new StringTokenizer(br.readLine());
            
            userA = Integer.parseInt(st.nextToken());
            userB = Integer.parseInt(st.nextToken());
            
            bfs(userA, userB);
            
        }
        
        
        
        bw.flush();
        bw.close();
    }
    
    static void bfs(int score, int end){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {score, end, 0});
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            if(now[0] == now[1]){
                System.out.println(now[2]);
                return;
            }
            
            if(now[0] < now[1]){
                dq.add(new int[] {now[0] + now[0], now[1] + 3, now[2] + 1});
            
                dq.add(new int[] {now[0] + 1, now[1], now[2] + 1});
            }
        }
    }
}
