import java.util.*;
import java.io.*;

public class Main {

    static BufferedWriter bw;

    static int subjectCnt;
    static int count;
    static int[] subjects;
    static ArrayList<Integer>[] list;
    static ArrayDeque<int[]> dq;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        subjectCnt = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());

        list = new ArrayList[subjectCnt + 1];
        subjects = new int[subjectCnt + 1];
        subjects[0] = -1;

        for(int idx = 0; idx < subjectCnt + 1; idx++){
            list[idx] = new ArrayList<Integer>();
        }

        for(int idx = 0; idx < count; idx++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            list[nodeA].add(nodeB);
            subjects[nodeB]++;
        }

        dq = new ArrayDeque<>();

        for(int idx = 1; idx < subjectCnt + 1; idx++){
            if(subjects[idx] == 0){
                dq.add(new int[] {idx, 1});
            }
        }

        answer = new int[subjectCnt + 1];
        sortFunc();

        for(int idx = 1; idx < subjectCnt + 1; idx++){
            bw.write(answer[idx]+" ");
        }
        bw.flush();
        bw.close();
    }

    static void sortFunc(){

        while (dq.size() != 0){
            int[] now = dq.poll();
            int node = now[0];
            int time = now[1];
            answer[node] = time;

            for(int idx = 0; idx < list[node].size(); idx++){
                subjects[list[node].get(idx)] -= 1;
                if(subjects[list[node].get(idx)] == 0){
                    dq.add(new int[] {list[node].get(idx), time + 1});
                }
            }


        }
    }

}
