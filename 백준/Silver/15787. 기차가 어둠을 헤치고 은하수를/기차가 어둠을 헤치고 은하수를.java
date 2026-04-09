// n개의 기차
// 20개의 좌석
// m개의 명령
    // 1. i 번기차 x 좌석에 사람 태우기, 이미 있다면 X
    // 2. i 번기차 x 좌석 하차, 이미 없다면 X
    // 3. i 번기차 한 칸씩 뒤로, 20번째 좌석은 내리기
    // 4. i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. 1번째 좌석 내리기


import java.util.*;
import java.io.*;

public class Main
{   
    
    static int n; //기차의 수
    static int m; //명령의 수
    static int[] trains; //기차 담는 배열
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken());
		
		trains = new int[n];
		
		
		Set<Integer> set = new HashSet<>(); //기차 담는 set
		
		
		for(int i = 0; i < m; i++){
		    st = new StringTokenizer(br.readLine());
		    
		    int type = Integer.parseInt(st.nextToken()); // 명령어 타입
		    int trainNum = Integer.parseInt(st.nextToken()) - 1; // 기차 번호
		    
		    
		    if(type == 1){ // 1. i 번기차 x 좌석에 사람 태우기, 이미 있다면 X
		        int sitNum = Integer.parseInt(st.nextToken()) - 1;
		        trains[trainNum] = (trains[trainNum]) | (1 << sitNum);
		        
		    }
		    
		    else if(type == 2){ // 2. i 번기차 x 좌석 하차, 이미 없다면 X
		        int sitNum = Integer.parseInt(st.nextToken()) - 1;
		        trains[trainNum] = trains[trainNum] & ~ (1 << sitNum);
		    }
		    
		    else if(type == 3){ // 3. i 번기차 한 칸씩 뒤로, 20번째 좌석은 내리기
		        trains[trainNum] = trains[trainNum] << 1;
		        trains[trainNum] = trains[trainNum] & ~ (1 << 20);
		    }
		    
		    else if(type == 4){ // 4. i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. 1번째 좌석 내리기
		        trains[trainNum] = trains[trainNum] >> 1;
		    }
		    
		}
        
 
        
        for(int i : trains){
            set.add(i);
        }
        
		bw.write(set.size()+"");
		bw.flush();
		bw.close();
	}

}
