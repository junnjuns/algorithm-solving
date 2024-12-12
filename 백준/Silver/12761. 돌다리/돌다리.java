import java.io.*;
import java.util.*;

public class Main {
    static int A, B, n, m;
    static int[] vis = new int[100001];
    static int result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Arrays.fill(vis, 0);
        BFS(n);
        
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
    
    static void BFS(int start) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        vis[start] = 1;
        
        while (!dq.isEmpty()) {
            int now = dq.poll();
            
            if (now == m) {
                result = vis[now] - 1;
                break;
            }
            
            int[] nextPositions = {
                now + 1, now - 1, now + A, now + B, now - A, now - B,
                now * A, now * B
            };
            
            for (int next : nextPositions) {
                if (next >= 0 && next < vis.length && vis[next] == 0) {
                    dq.add(next);
                    vis[next] = vis[now] + 1;
                }
            }
        }
        
    }
}
