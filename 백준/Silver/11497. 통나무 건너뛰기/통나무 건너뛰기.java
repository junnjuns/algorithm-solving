import java.util.*;
import java.io.*;


public class Main
{   
    static int n;
    static int[] arr;
    static int answer;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        int test = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < test; t++){
            answer = 0;
            
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            } // 배열 초기화
            
            Arrays.sort(arr); // 정렬
            
            int[] resArr = new int[n];
            

            for(int i = 0; i < n / 2; i++){
                resArr[i] = arr[i * 2];
                resArr[n - 1 - i] = arr[i * 2 + 1];
            }
            resArr[n / 2] = arr[n - 1];
            
            for(int i = 0; i < n; i++){
                answer = Math.max(answer, Math.abs(resArr[(i + 1) % n] - resArr[i]));
            }
            
            bw.write(answer+"\n");
        } // 테스트 케이스 종료
        
        
		bw.flush();
		bw.close();
	}
	
	
}