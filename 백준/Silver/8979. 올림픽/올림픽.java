import java.util.*;
import java.io.*;

public class Main
{
    static int countryCnt;
    static int target;
    static int[][] arr;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        countryCnt = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        
        arr = new int[countryCnt + 1][3];
        
        for(int i = 0; i < countryCnt; i++){
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            
            arr[country][0] = Integer.parseInt(st.nextToken()); //금
            arr[country][1] = Integer.parseInt(st.nextToken()); //은
            arr[country][2] = Integer.parseInt(st.nextToken()); //동
        }
        
        //target 보다 큰 나라 counting
        int cnt = 1;
        
        for(int i = 1; i < countryCnt + 1; i++){
            if(i == target){
                continue;
            }
            
            //금 더 많을 때
            if(arr[i][0] > arr[target][0]){
                cnt += 1;
            }
            
            // 금 같을 때
            else if(arr[i][0] == arr[target][0]){
                
                //은 더 많을 때
                if(arr[i][1] > arr[target][1]){
                    cnt += 1;
                }    
                // 은 같을 때
                else if(arr[i][1] == arr[target][1]){
                    //동 더 많을 때
                    if(arr[i][2] > arr[target][2]){
                        cnt += 1;
                    }    
                }
                
            }
                
        }
        
        bw.write(cnt+"");
	    bw.flush();
	    bw.close();
	}
	
}
