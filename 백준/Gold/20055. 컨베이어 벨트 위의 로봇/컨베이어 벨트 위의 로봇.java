// 첫째 줄에 N, K가 주어진다. 둘째 줄에는 A1, A2, ..., A2N이 주어진다.

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
        st = new StringTokenizer(br.readLine());	    
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] hp = new int[n*2];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n*2; i++){
            hp[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] exist = new boolean[n]; // n개 위에 로봇 존재 여부 확인
        int answer = 0;
        while(true){
            answer++;
            
            int temp = hp[2*n-1];
            for(int i = 2*n-1; i > 0; i--){
                hp[i] = hp[i-1];
            }
            hp[0] = temp;
            
            
            for(int i = n-1; i > 0; i--){
                exist[i] = exist[i-1];
            }
            exist[0] = false; // 시작 초기에 로봇 항상 없음.
            exist[n-1] = false; //마지막 부분엔 로봇 항상 없앰
            
            for(int i = n-1; i > 0; i--){
                exist[n-1] = false; //마지막은 항상 없앤다.
                if(exist[i-1] == true){ //로봇 존재할 때
                    if(exist[i] == false && hp[i] > 0){
                        exist[i-1] = false;
                        exist[i] = true;
                        hp[i]--;
                    }
                }
            }
            
            if(hp[0] > 0){
                exist[0] = true;
                hp[0]--;
            }
            
            int cnt = 0;
            for(int i : hp){
                if(i == 0){
                    cnt++;
                }
            }
            
            if(cnt >= k){
                break;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
	}
}
