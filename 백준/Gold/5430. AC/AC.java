import java.util.*;
import java.io.*;


public class Main {

    static int len;
    static Integer[] arr;
    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 0; t < test; t++){

            String order = br.readLine();
            len = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[,]");
            dq = new ArrayDeque<>();
            for(int idx = 0; idx < len; idx++){
                dq.add(Integer.parseInt(st.nextToken()));
            } //큐에 추가 끝


            boolean check = false;
            boolean state = true; //올바른 상태

            for(int idx = 0; idx < order.length(); idx++){
                //현재 명령어
                int nowOrder = order.charAt(idx);

                //뒤집기
                if(nowOrder == 'R'){
                    state = !state;
                    check = true;
                }
                //맨 앞 삭제하기
                else{
                    if(dq.size() != 0 && state){
                      dq.poll();
                      check = true;
                    }
                    else if(dq.size() != 0 && !state){
                        dq.pollLast();
                        check = true;
                    }
                    else{
                        check = false;
                        break;
                    }
                }

            }
            arr = new Integer[dq.size()];
            arr = dq.toArray(arr);

            if(!check){
                bw.write("error\n");
            }
            else if(check && state){
                bw.write("[");

                for(int idx = 0; idx < arr.length; idx++){
                    if(idx == arr.length - 1){
                        bw.write(arr[idx]+"");
                    }
                    else{
                        bw.write(arr[idx]+",");
                    }
                }

                bw.write("]\n");
            }
            else if(check && !state){
                bw.write("[");

                for(int idx = 0; idx < arr.length; idx++){
                    if(idx == arr.length - 1){
                        bw.write(arr[arr.length - 1 - idx]+"");
                    }
                    else{
                        bw.write(arr[arr.length - 1 - idx]+",");
                    }
                }

                bw.write("]\n");
            }


        }//테스트 끝


        bw.flush();
        bw.close();
    }
}
