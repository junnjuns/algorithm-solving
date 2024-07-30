import java.util.*;
import java.io.*;

public class Solution {
	
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < test; t++){
		    bw.write("#"+(t+1)+" ");
		    
		    int day = Integer.parseInt(br.readLine()); // 총 매매 일수
		    int[] arr = new int[day]; // 각 일마다 물건 가격 저장
		    long money = 0; // 현재 보유 금액
		    
		    st = new StringTokenizer(br.readLine());
		    
		    for(int idx = 0; idx < day; idx++){
		        arr[idx] = Integer.parseInt(st.nextToken());
		    }
		    
		    int max = arr[day-1]; //현재 가장 비싼 물건 값
		    
		    for(int idx = day-2; idx >= 0; idx--){
		        if(arr[idx] >= max){
		            max = arr[idx];
		        }
		        else{
		            money += max - arr[idx];
		        }
		    }
		    
		    bw.write(money+"\n");
		}//테스트 케이스 끝
		
		bw.flush();
		bw.close();
	}
}
