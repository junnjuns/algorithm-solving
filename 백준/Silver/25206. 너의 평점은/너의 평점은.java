import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        int cnt = 0;
        double sum = 0;
        for(int idx = 0; idx < 20; idx++){
            st = new StringTokenizer(br.readLine());

            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(!map.containsKey(grade)){
                continue;
            }
            cnt += score;
            sum += score * map.get(grade);

        }

        bw.write(sum/cnt+"");

        bw.flush();
        bw.close();
    }
}
