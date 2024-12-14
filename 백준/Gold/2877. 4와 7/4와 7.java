import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main
{   
    public static void main(String[] args) throws Exception {
        // 입력과 출력을 위한 BufferedReader와 BufferedWriter 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력받은 rank 값을 long 타입으로 저장
        long rank = Long.parseLong(br.readLine());
        
        // 1. 숫자의 길이 결정
        int len = 1; // 초기 자릿수는 1자리부터 시작
        long total = 0; // 이전 자릿수까지의 총 숫자 개수 누적
        
        while(true){
            // 현재 자릿수에서 가능한 숫자 수를 Math.pow를 사용하여 계산 (2^len)
            long cnt = (long)Math.pow(2, len);
            
            // total + cnt가 rank보다 크거나 같으면 현재 자릿수 내에 rank가 존재
            if(total + cnt >= rank){
                break;
            }
            
            // 그렇지 않으면 total에 cnt를 더하고, 다음 자릿수로 이동
            total += cnt;
            len += 1;
        }
        
        // 2. 해당 자릿수 내에서의 순서 결정
        long target = rank - total - 1; // 0부터 시작하는 인덱스
        
        // 3. 숫자 생성
        StringBuilder sb = new StringBuilder();
        for(int i = len - 1; i >= 0; i--){
            // 각 자리수에서 가능한 조합 수를 Math.pow를 사용하여 계산 (2^i)
            long power = (long)Math.pow(2, i);
            
            if(target >= power){
                sb.append('7'); // '7'을 선택
                target -= power; // target을 갱신
            }
            else{
                sb.append('4'); // '4'를 선택
            }
        }
        
        // 최종 숫자 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
