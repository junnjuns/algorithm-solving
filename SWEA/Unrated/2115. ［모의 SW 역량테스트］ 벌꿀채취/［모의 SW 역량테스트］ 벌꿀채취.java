import java.util.*;
import java.io.*;


//각각의 일꾼은 가로로 연속되도록 bucketCnt개의 벌통을 선택한다.
//두 명의 일꾼이 선택한 벌통은 서로 겹치면 안된다.

//일꾼이 가질 수 있는 버킷의 시작 좌표의 조합을 구한다.
//좌표를 구한 뒤 해당 위치부터 가로로 꿀을 채취 할 수 있는 범위를 구한다.
//두 일꾼이 채취할 수 있는 범위를 모두 구했으면
//범위의 배열을 내림차순 정렬 후 채취할 수 있는 최대양보다 작거나 같도록 하는 배열의 범위를 구한다.
//해당 범위 내에 있는 값들을 통해 꿀을 채취한다.
//이 과정에서 max값을 얻고 출력한다.

public class Solution {

    static int size; // board 크기
    static int[][] board; //board
    static int bucketCnt; // 선택할 수 있는 벌통의 개수
    static int maxHoney; //꿀 최대 채취
    static ArrayList<int[]> list;
    static boolean[][] vis;
    static int[] personA;
    static int[] personB;
    static int answer;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());


        //테스트 케이스 시작
        for(int t = 1; t <= test; t++) {
            bw.write("#"+t+" ");

            st = new StringTokenizer(br.readLine());

            size = Integer.parseInt(st.nextToken());

            // 선택할 수 있는 벌통의 개수
            bucketCnt = Integer.parseInt(st.nextToken());

            //꿀 최대 채취
            maxHoney = Integer.parseInt(st.nextToken());

            board = new int[size][size];

            //board 입력
            for(int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < size; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            personA = new int[bucketCnt];
            personB = new int[bucketCnt];
            //일꾼 2명의 벌통 시작 좌표 담는 list
            list = new ArrayList<>();
            vis = new boolean[size][size];
            //2명 일꾼 벌통 선택
            select(0, 0, 0);

            bw.write(answer+"\n");
        }//테스트 케이스 끝


        bw.flush();
        bw.close();
    }

    static void getMaxValue(int dep, int sum, int[] arr, ArrayList<Integer> list){
        if(sum > maxHoney){
            return;
        }
        if(dep == arr.length){

            int res = 0;

            for(int v : list){
                res += v*v;
            }

            max = Math.max(max, res);
            return;
        }

        list.add(arr[dep]);
        getMaxValue(dep + 1, sum + arr[dep], arr, list);

        list.remove(list.size() - 1);
        getMaxValue(dep + 1, sum, arr, list);

    }


    static void select(int dep, int x, int y) {
        if(dep == 2) {

            int personA_x = list.get(0)[0];
            int personA_y = list.get(0)[1];
            for(int idx = 0; idx < bucketCnt; idx++) {
                personA[idx] = board[personA_x][personA_y+idx];
            }

            max = 0;
            ArrayList<Integer> listA = new ArrayList<>();
            getMaxValue(0, 0, personA, listA);

            int sumA = max;

            int personB_x = list.get(1)[0];
            int personB_y = list.get(1)[1];
            for(int idx = 0; idx < bucketCnt; idx++) {
                personB[idx] = board[personB_x][personB_y+idx];
            }


            max = 0;
            ArrayList<Integer> listB = new ArrayList<>();
            getMaxValue(0, 0, personB, listB);
            int sumB = max;

            answer = Math.max(answer, sumA+sumB);
            return;
        }



        for(int row = x; row < size; row++) {
            for(int col = (row == x ? y : 0); col < size - bucketCnt + 1; col++) {
                if(vis[row][col]) continue;

                for(int idx = col; idx < (col + bucketCnt); idx++) {
                    vis[row][idx] = true;
                }

                list.add(new int[] {row, col});
                select(dep + 1, row, col);


                list.remove(list.size() - 1);

                for(int idx = col; idx < col + bucketCnt; idx++) {
                    vis[row][idx] = false;
                }

            }

        }

    }

}

