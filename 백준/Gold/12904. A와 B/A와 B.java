import java.util.*;
import java.io.*;


public class Main {

    static String now;
    static String target;
    static ArrayDeque<Character> dqNow = new ArrayDeque<>();
    static char[] arr;
    static boolean answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        now = br.readLine();
        target = br.readLine();

        boolean check = true;
        while (true){
            char ch = target.charAt(target.length() - 1);
            if(target.length() == now.length()){
                break;
            }
            if(ch == 'A'){
                target = target.substring(0, target.length() - 1);
            }
            else{
                target = target.substring(0, target.length() - 1);
                String s = "";
                for(int idx = 0; idx < target.length(); idx++){
                    s += target.charAt(target.length() -idx-1);
                }
                target = s;
            }

        }
        if(now.equals(target)){
            bw.write("1");
        }
        else{
            bw.write("0");
        }

        bw.flush();
        bw.close();
    }

}
