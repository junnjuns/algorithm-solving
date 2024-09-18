import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map  = new HashMap<>();
        Map<String, Integer> map2  = new HashMap<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            map.put((i+1), str);
            map2.put(str,(i+1));

        }

        for(int i = 0; i < m; i++){
            String str = br.readLine();
            char ch = str.charAt(0);
            if('A' <= ch && ch <= 'Z'){
                bw.write(map2.get(str)+"\n");
            }
            else{
                bw.write(map.get(Integer.parseInt(str))+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
