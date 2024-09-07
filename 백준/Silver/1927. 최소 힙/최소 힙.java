import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int idx = 0; idx < n; idx++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.size() == 0){
                    bw.write("0\n");
                }
                else{
                    int now = pq.poll();
                    bw.write(now+"\n");
                }

            }
            else{
                pq.add(num);
            }
        }

        bw.flush();
        bw.close();
    }
}
