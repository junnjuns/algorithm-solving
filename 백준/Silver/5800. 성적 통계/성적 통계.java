import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int len = st.countTokens();
            int[] arr = new int[len];
            for(int j = 0; j < arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int res = 0;
            for(int j = 0; j < arr.length-1; j++){
                res = Math.max(res, Math.abs(arr[j]-arr[j+1]));
            }

            bw.write("Class "+i+"\n");
            bw.write("Max "+arr[len-1]+", "+"Min "+arr[0]+", "+"Largest gap "+res+"\n");
        }

        bw.flush();
        bw.close();
    }
}
