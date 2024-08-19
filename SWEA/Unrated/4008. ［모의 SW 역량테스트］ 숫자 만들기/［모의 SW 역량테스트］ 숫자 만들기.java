import java.io.*;
import java.util.*;

            
class  Solution{
    
    static int[] operator = new int[4]; // +, -, *, /
    static int[] num;
    static int numlen;
    static int min, max;
    static int[] selectIdx; 
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    
        int test = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
    
        for(int t = 0; t < test; t++) { // 테스트 케이스 반복
            bw.write("#" + (t+1) + " ");
            
            numlen = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < 4; idx++){
                operator[idx] = Integer.parseInt(st.nextToken());
            } //연산자 입력
            
            num = new int[numlen];
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx < numlen; idx++){
                num[idx] = Integer.parseInt(st.nextToken());
            }// 수식에 사용되는 숫자 입력
            
            selectIdx = new int[numlen-1];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            permutation(0);
            
            bw.write((max-min)+"\n");
        } // 테스트 케이스 반복 종료
    
        bw.flush();
        bw.close();
    }
    static void permutation(int select){
        if(select == numlen - 1){
            int res = num[0]; //초기 값 저장
            
            for(int idx = 0; idx < select; idx++){
                if(selectIdx[idx] == 0){
                    res += num[idx+1];
                }
                else if(selectIdx[idx] == 1){
                    res -= num[idx+1];
                }
                else if(selectIdx[idx] == 2){
                    res *= num[idx+1];
                }
                else if(selectIdx[idx] == 3){
                    res /= num[idx+1];
                }
                
            }
            
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }
        
        for(int idx = 0; idx < 4; idx++){
            if(operator[idx] == 0) continue;
            
            operator[idx] -= 1;
            selectIdx[select] = idx;
            permutation(select + 1);
            operator[idx] += 1;
        }
    }
}