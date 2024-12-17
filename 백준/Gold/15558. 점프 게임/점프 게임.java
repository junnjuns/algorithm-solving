import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] loadA, loadB;
    static boolean[] visA, visB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        loadA = new int[N];
        loadB = new int[N];
        visA = new boolean[N];
        visB = new boolean[N];
        
        String strA = br.readLine();
        for(int j = 0; j < strA.length(); j++) {
            loadA[j] = strA.charAt(j) - '0';
        }
        
        String strB = br.readLine();
        for(int j = 0; j < strB.length(); j++) {
            loadB[j] = strB.charAt(j) - '0';
        }
        
        boolean result = bfs();
        bw.write(result ? "1" : "0");
        bw.flush();
        bw.close();
    }
    
    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        // 상태: {line, position, time}
        queue.add(new int[] {0, 0, 0});
        visA[0] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int line = current[0];
            int pos = current[1];
            int time = current[2];
            
            // 게임 클리어 조건
            if(pos >= N) return true;
            
            // 다음 시간
            int nextTime = time + 1;
            
            // 이동 가능한 3가지 경우
            int[][] moves = new int[3][2];
            // 앞으로 한 칸
            moves[0][0] = line;
            moves[0][1] = pos + 1;
            // 뒤로 한 칸
            moves[1][0] = line;
            moves[1][1] = pos - 1;
            // 반대편 줄로 점프
            moves[2][0] = 1 - line;
            moves[2][1] = pos + K;
            
            for(int i = 0; i < 3; i++) {
                int newLine = moves[i][0];
                int newPos = moves[i][1];
                
                // 클리어 조건
                if(newPos >= N) return true;
                
                // 유효한 위치인지 확인
                if(newPos < 0) continue;
                
                // 사라진 칸인지 확인
                if(newPos <= time) continue;
                
                // 해당 줄의 칸이 안전한지 확인
                if(newLine == 0 && loadA[newPos] == 0) continue;
                if(newLine == 1 && loadB[newPos] == 0) continue;
                
                // 이미 방문했는지 확인
                if(newLine == 0 && visA[newPos]) continue;
                if(newLine == 1 && visB[newPos]) continue;
                
                // 방문 처리
                if(newLine == 0) visA[newPos] = true;
                else visB[newPos] = true;
                
                // 큐에 추가
                queue.add(new int[] {newLine, newPos, nextTime});
            }
        }
        
        return false;
    }
}
