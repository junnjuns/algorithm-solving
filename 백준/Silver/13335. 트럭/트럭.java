import java.util.*;
import java.io.*;

public class Main
{   
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	
	    st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int goal = Integer.parseInt(st.nextToken());
	    int limit = Integer.parseInt(st.nextToken());
	    
	    int[]truck = new int[n]; 
	    
	    st = new StringTokenizer(br.readLine());
	    for(int idx = 0; idx < n; idx++){
	        truck[idx]= Integer.parseInt(st.nextToken());
	    }
        	    
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    int[] position = new int[n];
	    int time = 0;
	    int cur = 0; // 현재 하중
	    int idx = 0;
	    do{
	        time++;
	        
	        if(position[n-1] == goal+1){
	            break;
	        }
	        
	        if(idx < n && cur + truck[idx] <= limit){ //만약 하중 이하이면 트럭 dq에 추가(다리에 추가)
	            dq.add(idx); //트럭 index 삽입
	            cur += truck[idx]; //현재 하중에 트럭 하중 추가
	            position[idx]++;
	            idx++;
	        }
	        
	        for(int i : dq){ //다리 위 트럭 위치 1 증가
	            position[i]++;
	        }
	        
	        if(position[dq.peek()] == goal+1){ //goal을 넘으면 다리에서 꺼내기
	            int index = dq.poll();
	            
	            cur -= truck[index]; //다리에서 꺼냈으니 하중 빼주기
	            if(cur < 0){
	                cur = 0;
	            }
	        }
	        
	       
	    }while(true); //다리에서 모두 나오면 종료
	    
	    bw.write(time+"");
	    bw.flush();
	    bw.close();
	}
    
}
	