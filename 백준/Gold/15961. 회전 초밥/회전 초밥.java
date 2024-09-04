import javax.naming.PartialResultException;
import java.util.*;
import java.io.*;

public class Main {

    static int plateCnt;
    static int sushiType;
    static int eating;
    static int coupon;
    static int[] rotation;
    static int[] sushi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        plateCnt = Integer.parseInt(st.nextToken());    //접시 수
        sushiType = Integer.parseInt(st.nextToken());   //초밥 종류
        eating = Integer.parseInt(st.nextToken());  //연속으로 먹는 수
        coupon = Integer.parseInt(st.nextToken());  //초밥 종류가 쓰여져있는 쿠폰

        //현재 회전 초밥 접시 배열
        rotation = new int[plateCnt];
        for(int idx = 0; idx < plateCnt; idx++){
            rotation[idx] = Integer.parseInt(br.readLine());
        }
        int answer = 0;

        sushi = new int[3001];


        //쿠폰은 항상 존재하도록 함
        sushi[coupon] = 1;
        int max = 1;

        //초기 값 세팅
        for(int idx = 0; idx < eating; idx++){
            if(sushi[rotation[idx]] == 0){
                max++;
            }
            answer = Math.max(answer, max);
            sushi[rotation[idx]]++;
        }

        int end = eating;
        for(int start = 1; start < plateCnt; start++){

//            for(int idx = 0; idx < eating; idx++){
//                for(int i = 0; i < sushi.length; i++){
//                    if(sushi[i] != 0){
//                        System.out.print(i+" ");
//                    }
//                }
//                System.out.print(": "+max);
//                System.out.println();
//            }

            //이전 시작 값 지우기
            sushi[rotation[start - 1]]--;
            //만약 이전 값을 지웠을 때 0이면 max 값 감소
            if(sushi[rotation[start - 1]] == 0){
                max--;
            }

            //만약 다음으로 갈 곳이 0이면 max값 추가
            if(sushi[rotation[ (end + start - 1) % plateCnt]] == 0){
                max++;
            }
            //다음 값 증가
            sushi[rotation[ (end + start - 1) % plateCnt]]++;
            answer = Math.max(answer, max);
        }


        bw.write(answer+"");

        bw.flush();
        bw.close();
    }
}
