import java.util.*;
import java.io.*;


public class Main {

    static int swichCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        swichCnt = Integer.parseInt(br.readLine());
        int[] swichs = new int[swichCnt + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= swichCnt; i++){
            swichs[i] = Integer.parseInt(st.nextToken());
        }

        int test = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < test; idx++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            //남자일 때
            if(gender == 1){
                int plus = num;
                while(true){
                    if(num > swichCnt){
                        break;
                    }
                    swichs[num] = swichs[num] == 1 ? 0 : 1;
                    num += plus;
                }
            }
            //여자일 떄
            else{
                int left = num - 1;
                int right = num + 1;
                swichs[num] = swichs[num] == 1 ? 0 : 1;

                while (true){
                    //범위 벗어남
                    if(!check(left) || !check(right)){
                        break;
                    }
                    //대칭이 아닐 때
                    else if(swichs[left] != swichs[right]){
                        break;
                    }
                    swichs[left] = swichs[left] == 1 ? 0 : 1;
                    swichs[right] = swichs[right] == 1 ? 0 : 1;
                    left--;
                    right++;
                }

            }
        }
        for(int idx = 1; idx <= swichCnt; idx++){
            bw.write(swichs[idx]+" ");
            if(idx % 20 == 0){
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static boolean check(int n){
        return 1 <= n && n <= swichCnt;
    }
}
