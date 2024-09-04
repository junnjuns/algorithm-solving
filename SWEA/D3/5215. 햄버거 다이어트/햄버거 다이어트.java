import java.util.*;
import java.io.*;

//테이블 정의
    //dp[현재 보고 있는 재료][현재 까지의 점수] => 현재까지 고른 재료 중 최대 점수를 가진다.
//점화식 세우기
    //만약 현재 칼로리 보다 나의 칼로리가 높으면 이전 재료의 칼로리 값으로 초기화
    //현재 최대 점수 = 이전 재료의 같은 칼로리 점수 값 vs (이전 재료의 같은 칼로리 값 - 나의 칼로리 값)점수 + 나의 점수
//dp배열의 마지막 값 == 최대값 출력

public class Solution {

    static int food;
    static int limit;
    static int[] taste;
    static int[] kcalArr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            bw.write("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            food = Integer.parseInt(st.nextToken()); // 재료 수
            limit = Integer.parseInt(st.nextToken()); // 제한 칼로리

            taste = new int[food + 1]; // 맛 배열
            kcalArr = new int[food + 1]; // 칼로리 배열

            // 맛과 칼로리 입력
            for (int idx = 1; idx < food + 1; idx++) {
                st = new StringTokenizer(br.readLine());
                taste[idx] = Integer.parseInt(st.nextToken());
                kcalArr[idx] = Integer.parseInt(st.nextToken());
            }

            dp = new int[food + 1][limit + 1];

            for (int curFood = 1; curFood < food + 1; curFood++) {
                for (int kcal = 0; kcal < limit + 1; kcal++){

                    //현재 칼로리가 내가 가진 칼로리보다 작을 때 이전 값 가져온다.
                    if(kcalArr[curFood] > kcal) {
                        dp[curFood][kcal] = dp[curFood - 1][kcal];
                    }
                    //현재 최대 점수 = 이전 재료의 같은 칼로리 점수 값 vs (이전 재료의 같은 칼로리 값 - 나의 칼로리 값)점수 + 나의 점수
                    else {
                        dp[curFood][kcal] = Math.max(dp[curFood - 1][kcal], dp[curFood - 1][kcal - kcalArr[curFood]] + taste[curFood]);
                    }
                }
            }


            bw.write(dp[food][limit]+"\n");
        } // 테스트 케이스 끝

        bw.flush();
        bw.close();
    }

}
