// 어떤 지원자라도 서류와 면접 점수 모두 떨어진다면 불가
    // 둘 중 하나라도 높으면 가능



import java.util.*;
import java.io.*;


public class Main
{   
    
    static int test;
    static int n;
    static int[][] arr;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        test = Integer.parseInt(br.readLine());

        
        for(int t = 0; t < test; t++){
            
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                
            } //초기화 끝
            
            Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); //서류 등수 오름차순
            
            int answer = 1;
            int max = arr[0][1]; //면접 점수
            
            for(int i = 1; i < n; i++){
                if(max > arr[i][1]){
                    max = arr[i][1];
                    answer += 1;
                }
            }
            bw.write(answer+"\n");
                
        } // test 끝
        
		bw.flush();
		bw.close();
	}
}
