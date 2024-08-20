import java.util.*;
import java.io.*;

 

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int fruitCnt = Integer.parseInt(st.nextToken()); //과일 개수 입력
        int bird = Integer.parseInt(st.nextToken()); //스네이크 버드 길이 입력
        int[] fruit = new int[fruitCnt]; //과일 배열 생성
        
        st = new StringTokenizer(br.readLine());
        
        for(int idx = 0; idx < fruitCnt; idx++){
            fruit[idx] = Integer.parseInt(st.nextToken());
        } //과일 입력
        
        Arrays.sort(fruit); //과일 오름차순 정렬
        
        for(int now : fruit){
            if(now <= bird){ //만약 과일의 높이가 bird 보다 작거나 같으면 bird 높이 1 증가
                bird += 1; 
            }
            else{ //만약 나보다 큰 높이이면 바로 종료
                break;
            }
        }
        
        bw.write(bird+"");
        bw.flush();
        bw.close();
    }
}