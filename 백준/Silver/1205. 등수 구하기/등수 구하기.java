import java.util.*;
import java.io.*;

public class Main
{
    static int nowCnt;
    static int newScore;
    static int size;
    static int[] scoreArr;
       
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        nowCnt = Integer.parseInt(st.nextToken());
        newScore = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        
        if(nowCnt == 0){
            System.out.print(1);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        
        scoreArr = new int[size]; // 점수 배열
        
        for(int idx = 0; idx < nowCnt; idx++){
            scoreArr[idx] = Integer.parseInt(st.nextToken());
        }
        
        
        if(nowCnt == size && scoreArr[size - 1] >= newScore){
            System.out.print(-1);
            return;
        }
        
        int cnt = 0;
        for(int n : scoreArr){
            if(n > newScore){
                cnt += 1;
            }
        }
        
        bw.write((cnt + 1)+"");
        
	    bw.flush();
	    bw.close();
	}
	
	
}
