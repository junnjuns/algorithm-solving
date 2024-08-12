import java.util.*;
import java.io.*;


public class Solution
{   
    
    static boolean[] youVis; //초기 나의 카드를 알기 위한 방문 배열
    static boolean[] myVis; //나의 카드 방문 배열
    static int[] myCard; //나의 카드 저장
    static int[] youCard = new int[9]; //규영 카드 저장
    static int[] myCardPermut = new int[9]; //카드 9개 순서 경우의 수 저장
    static int lose; //규영 패
    static int win; //규영 승
    
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int test  = Integer.parseInt(br.readLine());
	    
	    for(int t = 0; t < test; t++){
	        bw.write("#"+(t+1)+" ");
	        
	        win = 0;
	        lose = 0;
	        
	        youVis = new boolean[19]; //숫자 1부터 시작이기에 크기 + 1
	        myVis = new boolean[9];
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int idx = 0; idx < 9; idx++){ // 상대가 낸 카드 모두 true로 변경
	            int num = Integer.parseInt(st.nextToken());
	            youCard[idx] = num; //상대방 카드 저장
	            youVis[num] = true;
	        }
	        
	        myCard = new int[9];
	       
	        int index = 0;
	        for(int idx = 1; idx < 19; idx++){ //내 카드 저장
	            if(!youVis[idx]){
	                myCard[index++] = idx;
	            }
	        }  
	      
	        
	        permutation(0); //순열 생성 메서드, 깊이는 처음엔 0으로 시작
	        
	        bw.write(win+" "+lose+"\n");
	    
	        
	    } //테스트 케이스 끝
	    
	    bw.flush();
	    bw.close();
	}
	
	static void permutation(int depth){
	    
	    if(depth == 9){ //만약 순열이 만들어졌으면
	        int mySum = 0;
	        int youSum = 0;
	        
	        for(int idx = 0; idx < 9; idx++){
	            if(youCard[idx] > myCardPermut[idx]){
	                youSum += youCard[idx] + myCardPermut[idx];
	            }
	            else if(youCard[idx] < myCardPermut[idx]){
	                mySum += youCard[idx] + myCardPermut[idx];
	            }
	        }
	        
	        if(mySum > youSum){
	            lose++;
	        }
	        else if(mySum < youSum){
	            win++;
	        }
	        
	        return;
	    }
	    
	    for(int idx = 0; idx < 9; idx++){ //순열 구현 로직
	        if(!myVis[idx]){
	            myVis[idx] = true;
	            myCardPermut[depth] = myCard[idx];
	            permutation(depth+1);
	            myVis[idx] = false;
	        }
	    }
	}
}
