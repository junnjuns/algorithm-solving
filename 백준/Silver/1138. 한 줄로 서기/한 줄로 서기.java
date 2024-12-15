import java.util.*;
import java.io.*;


public class Main
{   
    
    static int num;
    static int[][] arr;
    static int[] answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    num = Integer.parseInt(br.readLine());
	    
	    arr = new int[num][2];
        answer = new int[num];
        
        st = new StringTokenizer(br.readLine());
        
	    for(int idx = 0; idx < num; idx++){
	        arr[idx][0] = idx + 1; //사람 번호
	        arr[idx][1] = Integer.parseInt(st.nextToken()); //더 큰 사람 수
	    }
	    
	    Arrays.sort(arr, (o1, o2) -> {
	        if(o1[1] == o2[1]){
	            return o1[0] - o2[0];
	        }
	        return o1[1] - o2[1];
	    });
	    //Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]); 
	    
	    
	    
	    for(int idx = 0; idx < num; idx++){
	        
	        int result = check(idx ,arr[idx][0]);
	        
	        if(result == arr[idx][1]){
	            answer[idx] = arr[idx][0];
	        }
	        else{
	            int changeIdx = idx - (result - arr[idx][1]); //원래 위치 값
	            int temp = answer[changeIdx];
	            
	            for(int j = num - 1; j > changeIdx; j--){
	                answer[j] = answer[j - 1];
	            }
	            answer[changeIdx] = arr[idx][0];
	        }
	    }
	    
	    for(int i : answer){
	        bw.write(i+" ");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static int check(int end, int value){
	    
	    int result = 0;
	    for(int idx = 0; idx < end; idx++){
	        //나보다 큰 사람 수 찾기
	        if(answer[idx] > value){
	            result += 1;
	        }
	    }
	    
	    return result;
	}
}
