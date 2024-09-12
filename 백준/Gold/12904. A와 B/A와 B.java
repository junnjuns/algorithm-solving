import java.util.*;
import java.io.*;


public class Main {

    static StringBuilder now;
    static StringBuilder target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        now = new StringBuilder(br.readLine());
        target = new StringBuilder(br.readLine());

        while(true){
            if(target.length() == now.length()){
                break;
            }
            if(target.charAt(target.length()-1) == 'A'){
                target = target.deleteCharAt(target.length()-1);
            }
            else {
                target = target.deleteCharAt(target.length()-1);
                target.reverse();
            }

        }

        bw.write((target.toString().equals(now.toString()) == true ? 1 : 0) +"");

        bw.flush();
        bw.close();
    }

}
