// n 개의 기둥



import java.util.*;
import java.io.*;

public class Main
{
   
    static int n;
    static int[][] sticks;
    static int maxH;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
	    n = Integer.parseInt(br.readLine()); // 기둥의 개수
        
        sticks = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());    
            
            sticks[i][0] = Integer.parseInt(st.nextToken()); // 위치
            sticks[i][1] = Integer.parseInt(st.nextToken()); // 높이
            
            maxH = Math.max(maxH, sticks[i][1]);
            
        } // 기둥 초기화
        
        
        Arrays.sort(sticks, (a, b) -> Integer.compare(a[0], b[0])); // 위치 순서로 정렬하기 (0번 째 인덱스 정렬)
        
        int firstMaxIdx = -1;
        int lastMaxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (sticks[i][1] == maxH) {
                if (firstMaxIdx == -1) firstMaxIdx = i;
                lastMaxIdx = i;
            }
        }

        
        int answer = 0;
        
        int nowLocation = sticks[0][0];
        int nowHeight = sticks[0][1];
        
        for(int i = 1; i <= firstMaxIdx; i++){
            
            if(sticks[i][1] >= nowHeight){
                answer += (sticks[i][0] - nowLocation) * nowHeight;
                nowLocation = sticks[i][0];
                nowHeight = sticks[i][1];
                
            }
            
        }
        
        
        nowLocation = sticks[n - 1][0];
        nowHeight = sticks[n - 1][1];
        
        for(int i = n - 2; i >= lastMaxIdx; i--){
            
            if(sticks[i][1] >= nowHeight){
                answer += (nowLocation - sticks[i][0]) * nowHeight;
                nowLocation = sticks[i][0];
                nowHeight = sticks[i][1];
                
            }
            
        }        
        
        
        answer += (sticks[lastMaxIdx][0] - sticks[firstMaxIdx][0] + 1) * maxH;
        
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
    

}
