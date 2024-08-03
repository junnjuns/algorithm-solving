import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        
        int[] truck = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            truck[idx] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] position = new int[n];
        int time = 0;
        int curWeight = 0;
        int idx = 0;

        while (true) {
            time++;
            
            if (!queue.isEmpty() && position[queue.peek()] == time) {
                int truckIdx = queue.poll();
                curWeight -= truck[truckIdx];
            }
            
            if (idx < n && curWeight + truck[idx] <= limit) {
                queue.add(idx);
                curWeight += truck[idx];
                position[idx] = time + goal;
                idx++;
            }
            
            if (queue.isEmpty() && idx >= n) {
                break;
            }
        }
        
        bw.write(time + "");
        bw.flush();
        bw.close();
    }
}
