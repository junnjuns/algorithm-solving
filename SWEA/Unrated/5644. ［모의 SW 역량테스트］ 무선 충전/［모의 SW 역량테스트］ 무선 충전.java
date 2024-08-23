


// 테스트 케이스 수 입력
// 각 테스트 케이스 실행
//   이동 시간과 충전기 개수를 입력
//   사용자 A와 B의 이동 경로 입력
//   각 충전기의 위치, 충전 범위, 충전량 입력
//   사용자 A와 B의 초기 위치 설정
//   초기 위치에서 두 사람이 각각 최대로 충전할 수 있는 양 계산
//   각 이동 단계마다 사용자 A와 B의 위치를 업데이트 후, 두 사람이 최대로 충전할 수 있는 양을 계산하여 합산함
//   각 테스트 케이스의 결과 출력



import java.util.*;
import java.io.*;

public class Solution {

    static int[][] map; // 맵 배열 (사용하지 않음)
    static int[] dx = {0, 0, 1, 0, -1}; // 이동 방향 배열 (상하좌우 및 정지)
    static int[] dy = {0, -1, 0, 1, 0}; // 이동 방향 배열 (상하좌우 및 정지)
    static int T, total, cnt; // T: 테스트 케이스 수, total 이동 시간, cnt: 충전기 개수
    static int[] personA; // A의 이동 경로
    static int[] personB; // B의 이동 경로
    static int[][] charger; // 충전기 정보 (x좌표, y좌표, 충전 범위, 충전량)
    static int ax, ay, bx, by; // A와 B의 현재 위치


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            total = Integer.parseInt(st.nextToken()); // 이동 시간 입력
            cnt = Integer.parseInt(st.nextToken()); // 충전기 개수 입력

            map = new int[11][11]; // 10x10 맵 생성
            personA = new int[total]; // A의 이동 경로 배열 생성
            personB = new int[total]; // B의 이동 경로 배열 생성

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < total; i++) {
                personA[i] = Integer.parseInt(st.nextToken()); // A의 이동 경로 입력
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < total; i++) {
                personB[i] = Integer.parseInt(st.nextToken()); // B의 이동 경로 입력
            }

            charger = new int[cnt + 1][4]; // 충전기 정보 배열 생성
            for (int i = 1; i <= cnt; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                charger[i][0] = x; // 충전기 x좌표
                charger[i][1] = y; // 충전기 y좌표
                charger[i][2] = Integer.parseInt(st.nextToken()); // 충전 범위
                charger[i][3] = Integer.parseInt(st.nextToken()); // 충전량
            }

            ax = 1; ay = 1; // A의 초기 위치
            bx = 10; by = 10; // B의 초기 위치
            answer = move(); // 초기 위치에서의 충전량 계산

            for (int i = 0; i < total; i++) {
                ax += dx[personA[i]]; // A의 위치 업데이트
                ay += dy[personA[i]];
                bx += dx[personB[i]]; // B의 위치 업데이트
                by += dy[personB[i]];
                answer += move(); // 매 이동 후 충전량 계산 및 합산
            }

            System.out.println("#" + tc + " " + answer); // 결과 출력
        }
    }
    
    
    // 현재 위치에서 두 사람이 각각 최대로 충전할 수 있는 양 계산
    static int move() {
        int ans;
        int max = 0;

        
        for (int i = 1; i <= cnt; i++) { // A가 선택한 충전기
            for (int j = 1; j <= cnt; j++) { // B가 선택한 충전기
                int chargeA = charging(ax, ay, i); // A의 충전량
                int chargeB = charging(bx, by, j); // B의 충전량

                if (i == j) {
                    // 같은 충전기를 선택한 경우 최대 충전량 중 하나만 선택
                    ans = Math.max(chargeA, chargeB);
                } 
                
                else {
                    // 다른 충전기를 선택한 경우 둘의 충전량 합산
                    ans = chargeA + chargeB;
                }
                max = Math.max(ans, max); // 최대 충전량 업데이트
            }
        }
        return max; // 두 사람이 충전할 수 있는 최대 충전량 반환
    }
    
      // 특정 위치에서 특정 충전기까지의 거리 계산 및 충전 가능 여부 확인
    static int charging(int x, int y, int n) {
        int cx = charger[n][0]; // 충전기 x좌표
        int cy = charger[n][1]; // 충전기 y좌표

        int d = Math.abs(x - cx) + Math.abs(y - cy); // 맨해튼 거리 계산
        if (d <= charger[n][2]) {
            return charger[n][3];
        } // 충전 가능 거리 내에 있으면 충전량 반환
        return 0; // 아니면 0 반환
    }
}
