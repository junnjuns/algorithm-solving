import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 첫 번째 줄 입력 받기: 트럭 수(n), 다리 길이(goal), 다리 최대 하중(limit)
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        
        // 두 번째 줄 입력 받기: 각 트럭의 무게 배열(truck)
        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            truck[idx] = Integer.parseInt(st.nextToken());
        }

        // 트럭의 인덱스를 저장할 큐(queue)와 각 트럭의 목표 도착 시간을 저장할 배열(position)
        Queue<Integer> dq = new ArrayDeque<>();
        int[] position = new int[n];

        int time = 0; // 현재 시간
        int curWeight = 0; // 현재 다리 위의 총 하중
        int idx = 0; // 다음에 다리에 올 트럭의 인덱스

        while (true) {
            time++;
            
            // 꺼내는 조건
            if(!dq.isEmpty() && position[dq.peek()] == time){
                int truckIdx = dq.poll();
                curWeight -= truck[truckIdx];
            }
            
            
            //다리 들어올 수 있는 조건
            if(idx < n && curWeight + truck[idx] <= limit){
                dq.add(idx);
                curWeight += truck[idx];
                position[idx] = time + goal;
                idx++;
            }
            
            if(position[n-1] == time){
                break;
            }
            
        }
        
        // 총 소요된 시간을 출력
        bw.write(time + "");
        bw.flush();
        bw.close();
    }
}
