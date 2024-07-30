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
		    int stuff = 0; // 물건 수
		    long money = 0; // 현재 보유 금액
		    
		    st = new StringTokenizer(br.readLine());
		    
		    int max = 0; //현재 가장 비싼 물건 값
		    
		    for(int idx = 0; idx < day; idx++){
		        arr[idx] = Integer.parseInt(st.nextToken());
		        max = Math.max(max, arr[idx]); //가장 큰 값 max에 초기화
		    } // 매매 정보 입력
		    
		    
		    for(int idx = 0; idx < day; idx++){
		        
		        if(arr[idx] < max){ // max물건보다 값싼 물건이면
		            money -= arr[idx]; //물건 값 지불
		            stuff += 1; //물건 삼
		        }
		        
		        else if(arr[idx] == max){ //max 물건 만나면 팔기
		        
		            money += arr[idx] * stuff; // 수익 : max X 물건 개수
		            stuff = 0; // 물건 팔았으니 0으로 초기화
		            
		            if(idx != day-1){ //만약 마지막 날이 아니면,
		                int changeMax = 0;
		                
		                for(int j = idx+1; j < day; j++){ // max 뒤에 max 다음으로 큰 수 찾기
		                    changeMax = Math.max(changeMax, arr[j]);   
		                }
		                
		                max = changeMax; //맥스 초기화 해주기
		            }
		            
		        }
		    }
		    
		    bw.write(money+"\n");
		}//테스트 케이스 끝
		
		bw.flush();
		bw.close();
	}
}
