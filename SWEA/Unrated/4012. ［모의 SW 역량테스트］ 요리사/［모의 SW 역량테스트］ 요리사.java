import java.io.*;
import java.util.*;

class Solution{

static int food;
static int[][] board;
static int[] selectArr;
static int min;

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int test = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

    for(int t = 0; t < test; t++) { // 테스트 케이스 반복
        bw.write("#" + (t+1) + " ");

        food = Integer.parseInt(br.readLine()); //식재료 수 입력(짝수)
        
        board = new int[food][food];
        selectArr = new int[food/2];
        
        for(int h = 0; h < food; h++) {
            st = new StringTokenizer(br.readLine());
            for(int w = 0; w < food; w++) {
                board[h][w] = Integer.parseInt(st.nextToken());
            }
        } //시너지 board 입력 끝
        min = Integer.MAX_VALUE;
        combi(0, 0);
        
        bw.write(min+"\n");
    } // 테스트 케이스 반복 종료

    bw.flush();
    bw.close();
}

static void combi(int dep, int select) {
    
    if(select == food/2) {
        boolean[] vis = new boolean[food];
        int[] foodA = new int[food/2];
        int[] foodB = new int[food/2];
        int a = 0;
        for(int idx : selectArr) {
            vis[idx] = true;
            foodA[a++] = idx;
        }
        a = 0;
        for(int idx = 0; idx < food; idx++){
            if(!vis[idx]){
                foodB[a++] = idx;
            }
        }
        int sumA = 0;
        for(int h = 0; h < foodA.length; h++){
            for(int w = 0; w < foodA.length; w++){
                sumA += board[foodA[h]][foodA[w]];
            }
        }
        
        int sumB = 0;
        for(int h = 0; h < foodB.length; h++){
            for(int w = 0; w < foodB.length; w++){
                sumB += board[foodB[h]][foodB[w]];
            }
        }
        
        min = Math.min(min, Math.abs(sumA - sumB));
        
        return;
    }
    
    if(dep == food) {
        return;
    }
    
    selectArr[select] = dep;
    combi(dep + 1, select + 1);
    
    combi(dep + 1, select);
    
}
}