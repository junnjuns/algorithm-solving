import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] g;
    static int[] dist;
    static long answer;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        // 문제 요구 정렬 방향 확인: (일반적으로 24447은 오름차순)
        for (int i = 1; i <= N; i++) Collections.sort(g[i]);

        dist = new int[N + 1];
        Arrays.fill(dist, -1);

        bfs(R);

        System.out.println(answer);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);
        cnt = 0;
        answer = 0L;

        while (!q.isEmpty()) {
            int node = q.poll();

            // 큐에서 꺼내는 시점 = 방문 확정 시점
            cnt++;
            answer += 1L * cnt * dist[node];

            for (int nxt : g[node]) {
                if (dist[nxt] != -1) continue;
                dist[nxt] = dist[node] + 1;
                q.add(nxt);
            }
        }
    }
}
