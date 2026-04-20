import java.util.*;
import java.io.*;


public class Main
{   
    static int n;
    static int m;
    static int[] craneArr;
    static int[] boxArr;
    static int answer;
    static boolean[] vis;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        
        n = Integer.parseInt(br.readLine());
        craneArr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            craneArr[i] = Integer.parseInt(st.nextToken());
        } // crane 초기화
        
        m = Integer.parseInt(br.readLine());
        boxArr = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            boxArr[i] = Integer.parseInt(st.nextToken());
        } // box 초기화
        
        vis = new boolean[m];
        
        Arrays.sort(craneArr);
        Arrays.sort(boxArr);
        
        if(craneArr[n - 1] < boxArr[m - 1]){
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }
        
        
        int cnt = 0;
        int[] idxArr = new int[n];
        Arrays.fill(idxArr, m - 1);
        
        while(cnt != m){
            answer += 1;
            
            for(int i = n - 1; i >= 0; i--){
                
                while(idxArr[i] >= 0){
                    
                    if(vis[idxArr[i]] || craneArr[i] < boxArr[idxArr[i]]){
                        idxArr[i] -= 1;
                        continue;
                    }
                    
                    else{
                        if(craneArr[i] >= boxArr[idxArr[i]]){
                            vis[idxArr[i]] = true;
                            cnt += 1;
                            idxArr[i] -= 1;
                            break;
                        }
                    }
                    
                    
                } // while문 끝
                
            } // for문 끝
            
        } // while문 끝
        
        
        bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	
	
}