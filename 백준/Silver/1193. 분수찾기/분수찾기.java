import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int input = Integer.parseInt(br.readLine());

        int line = 1;
        int sum = 0;

        while(true){

            if(input <= sum + line){ //찾았을 때
                if(line % 2 != 0){
                    bw.write((line -(input - sum)+1) + "/" + (input - sum));
                    break;
                }
                else{
                    bw.write((input - sum) +"/"+ (line -(input - sum)+1));
                    break;
                }

            }
            else{
                sum += line;
                line += 1;
            }


        }


        bw.flush();
        bw.close();
    }
}
