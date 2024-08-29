import java.util.*;
import java.io.*;

//계단의 입구는 반드시 2개이다.
//계단 위에는 동시에 최대 3명까지만 올라가 있을 수 있다.
//이미 계단에 3명이 내려가고 있는 경우, 그 중 한명이 계단을 완전히 내려갈 떄 까지 계단 입구에서 대기해야 한다.

// N명의 사람중 M명은 1번 계단
// Na명의 사람중 N-M명은 2번 계단

public class Solution
{

    static class Stair{

        int x;
        int y;
        int depth;

        public Stair(int x, int y, int depth) { 
            this.x = x;
            this.y = y;
            this.depth = depth; // 계단의 깊이 저장
        }

    }
    static class Person{

        int x;
        int y;
        int arriveStair;

        public Person(int x, int y){
            this.x = x;
            this.y = y;
        }

    }


    static ArrayList<Person> stair1;
    static ArrayList<Person> stair2;
    static ArrayList<Stair> stair;
    static ArrayList<Person> person;
    static int size;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test; t++){
            bw.write("#"+t+" ");
            person = new ArrayList<>();
            stair = new ArrayList<>();
            size = Integer.parseInt(br.readLine());

            board = new int[size][size];

            //board 생성
            for(int row = 0; row < size; row++){
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < size; col++){
                    board[row][col] = Integer.parseInt(st.nextToken());

                    //사람일 때
                    if(board[row][col] == 1){
                        person.add(new Person(row, col));
                    }

                    //계단일 때
                    else if(board[row][col] >= 2){
                        stair.add(new Stair(row, col, board[row][col]));
                    }
                }
            } //board 생성 끝

            //첫번째 계단 사용하는 사람
            stair1 = new ArrayList<>();
            //두번째 계단 사용하는 사람
            stair2 = new ArrayList<>();
            answer = Integer.MAX_VALUE;
            //모든 사람들을 두 계단에 배치하는 재귀 시작
            selectPerson(0, stair1, stair2);

            bw.write((answer+1)+"\n");
        }//테스트 케이스 끝


        bw.flush();
        bw.close();
    }

    static void selectPerson(int dep, ArrayList<Person> s1, ArrayList<Person> s2){
        //모든 사람을 배치했다면 종료
        if (dep == person.size()) {
            int[] arrivalTime1 = new int[s1.size()];
            int[] arrivalTime2 = new int[s2.size()];
            int TotalTime;
            int s1Time = 0;
            int s2Time = 0;

            // 첫 번째 계단에 대한 처리
            if (s1.size() > 0) {
                // 각 사람의 첫 번째 계단까지의 도착 시간
                for (int idx = 0; idx < s1.size(); idx++) {
                    // person 객체의 계단까지의 도착 시간 설정
                    arrivalTime1[idx] = Math.abs(s1.get(idx).x - stair.get(0).x) + Math.abs(s1.get(idx).y - stair.get(0).y);
                }

                // 도착 시간을 오름차순으로 정렬
                Arrays.sort(arrivalTime1);

                // 4번째 사람부터는 대기 시간을 고려하여 도착 시간 조정
                for (int i = 3; i < s1.size(); i++)
                    arrivalTime1[i] = Math.max(arrivalTime1[i], arrivalTime1[i - 3] + stair.get(0).depth);

                // 마지막 사람이 계단을 내려가는 시간 계산
                s1Time = arrivalTime1[s1.size() - 1] + stair.get(0).depth;
            }

            // 두 번째 계단에 대한 처리
            if (s2.size() > 0) {
                // 각 사람의 두 번째 계단까지의 도착 시간
                for (int idx = 0; idx < s2.size(); idx++) {
                    arrivalTime2[idx] = Math.abs(s2.get(idx).x - stair.get(1).x) + Math.abs(s2.get(idx).y - stair.get(1).y);
                }

                // 도착 시간을 오름차순으로 정렬
                Arrays.sort(arrivalTime2);

                // 4번째 사람부터는 대기 시간을 고려하여 도착 시간 조정
                for (int i = 3; i < s2.size(); i++)
                    arrivalTime2[i] = Math.max(arrivalTime2[i], arrivalTime2[i - 3] + stair.get(1).depth);

                // 마지막 사람이 계단을 내려가는 시간 계산
                s2Time = arrivalTime2[s2.size() - 1] + stair.get(1).depth;
            }

            // 두 계단을 모두 고려한 최종 시간을 계산
            TotalTime = Math.max(s1Time, s2Time);

            // 현재 계산한 시간이 최소인지 확인하고 갱신
            answer = Math.min(answer, TotalTime);

            return;
        }

        //현재 사람 첫 번째 계단에 배치, 재귀 호출, 원상 복구
        s1.add(person.get(dep));
        selectPerson(dep + 1, s1, s2);
        s1.remove(s1.size() - 1);

        //현재 사람 두 번째 계단에 배치, 재귀 호출, 원상 복구
        s2.add(person.get(dep));
        selectPerson(dep + 1, s1, s2);
        s2.remove(s2.size() - 1);

    }

}
