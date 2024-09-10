import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<Character> list;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] vis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        list = new ArrayList<>();

        String input = br.readLine();
        String[] arr = input.split("-");
        int sum = 0;

        st = new StringTokenizer(arr[0], "+");
        int size = st.countTokens();
        for(int idx = 0; idx < size; idx++){
            sum += Integer.parseInt(st.nextToken());
        }

        if(arr.length > 1){
            for(int idx = 1; idx < arr.length; idx++){
                st = new StringTokenizer(arr[idx], "+");
                size = st.countTokens();
                for(int j = 0; j < size; j++){
                    sum -= Integer.parseInt(st.nextToken());
                }
            }
        }


        bw.write(sum+"");
        bw.flush();
        bw.close();
    }

}
