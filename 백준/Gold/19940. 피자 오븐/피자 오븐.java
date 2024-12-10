import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄: 테스트 케이스의 수 T
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int test = 0; test < T; test++) {
            // 각 테스트 케이스마다 시간 N 입력
            int N = Integer.parseInt(br.readLine());
            int[] buttons = new int[5]; // [ADDH, ADDT, MINT, ADDO, MINO]
            
            int sixties = N / 60;
            int rem = N % 60;
            
            int tens = rem / 10;
            int ones = rem % 10;
            
            // 조건에 따른 조정
            if(ones > 5){
                tens += 1;
                ones -= 10;
            }
            if(tens > 3){
                sixties += 1;
                tens -= 6;
            }
            if(tens < 0 && ones == 5){
                tens += 1;
                ones -= 10;
            }
            
            // 버튼 배열에 값 할당
            buttons[0] = sixties; // ADDH
            
            if(tens >= 0){
                buttons[1] = tens; // ADDT
            }
            else{
                buttons[2] = Math.abs(tens); // MINT
            }
            
            if(ones >= 0){
                buttons[3] = ones; // ADDO
            }
            else{
                buttons[4] = Math.abs(ones); // MINO
            }
            
            // 결과를 StringBuilder에 추가
            sb.append(buttons[0]).append(" ")
              .append(buttons[1]).append(" ")
              .append(buttons[2]).append(" ")
              .append(buttons[3]).append(" ")
              .append(buttons[4]).append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb.toString());
    }
}
