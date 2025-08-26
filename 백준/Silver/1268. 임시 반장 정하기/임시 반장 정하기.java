//반의 학생수 3 이상 1000 이하

import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int[][] board;
    static int[] cnt;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][5];
        
        for(int student = 0; student < n; student++){
            st = new StringTokenizer(br.readLine());
            for(int grade = 0 ; grade < 5; grade++){
                board[student][grade] = Integer.parseInt(st.nextToken());
            }
        } //입력 끝
        
        
        cnt = new int[n];
        
        //학생
        for(int student = 0; student < n - 1; student++){
            
            //다른 학생
            for(int other = student + 1; other < n; other++){
                //학년
                for(int grade = 0; grade < 5; grade++){
                    
                    //같은반 일 때
                    if(board[student][grade] == board[other][grade]){
                        cnt[student] += 1;
                        cnt[other] += 1;
                        break;
                    }
                    
                    
                }
            }
        }
        int answer = 0;
        for(int student = 1; student < n; student++){
            //같은 값 여러개일 때,가장 작은 번호만 출력이기에 초과일때만 조건 설정
            if(cnt[student] > cnt[answer]){
                //임시반장 초기화
                answer = student;
            }
        }
        bw.write((answer+1)+"");
        bw.flush();
        bw.close();
        
    }
}
