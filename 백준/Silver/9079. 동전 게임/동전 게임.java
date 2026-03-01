// 모두 같은 면이 되도록 해야 함

// 가로 뒤집는 함수
// 세로 뒤집는 함수
// 대각선 뒤집는 함수

// 앞을 1 뒤를 0으로

// board 값을 이진수로 변환한다(정수)
//ㅁㅁㅁ ㅁㅁㅁ ㅁㅁㅁ
    // 함수1: 876, 543, 210
    // 함수2: 852, 741, 630
    // 함수3: 840
    // 함수4: 642
    // 4가지 함수 만들고 실행함
    // 


import java.util.*;
import java.io.*;

public class Main
{
    static char[][] board;
    static int[] vis;
    static int answer;
    static int[] masks;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		masks = new int[8];
		buildMask();
		
		for(int t = 0; t < test; t++){
		    
		    int num = 0; //초기 보드판 값(정수로 변환 한 값)
		    vis = new int[520]; //원래 512 지만, 넉넉하게 크기 설정
		    answer = -1; //초기 값
		    
		    for(int h = 0; h < 3; h++){
		        st = new StringTokenizer(br.readLine());
		        
		        for(int w = 0; w < 3; w++){
		            char ch = st.nextToken().charAt(0); //현재 상태(앞, 뒤)
		            
		            num = num << 1; // 오른쪽 칸을 만든다
		            
		            if(ch == 'H'){ // 앞이면 1로
		                num += 1; // 1로 변환
		            }
		            
		         } //내부 for문
		        
		    } // board 값 이진수로 초기화 끝
		    
		  
		    bfs(num); // 탐색 시작
		   
		    
		    
		    bw.write(answer+"\n");
		    
		} // 테스트 끝
		
		
		bw.flush();
		bw.close();
	}
	
	static void bfs(int num){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(num);
	    vis[num] = 1;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        
	        if(now == 511 || now == 0){
	            answer = vis[now] - 1;
	            return;
	        } // 모두 앞이거나 모두 뒷면이면 종료
	        
        for(int value : masks){
            int next = now ^ value; // 뒤집기 연산 실행
            if(vis[next] == 0){
                dq.add(next);
                vis[next] = vis[now] + 1;
            }
        }
	        
	    
	    }
	}
    
    static void buildMask(){
        int maskArrIdx = 0;
        int mask = 0;
        
        for(int i = 0; i < 3; i++){
            mask = 0;
            
            for(int j = 0; j < 3; j++){
                int nowIdx = 8 - (3 * i + j);
                mask = mask | (1 << nowIdx); // nowIdx만큼 왼쪽으로 밀기 (nowIdx 만큼 오른쪽에 0 생성) + OR연산으로 계속 mask 추가하기
            }
            masks[maskArrIdx++] = mask;
        } // 가로 뒤집기
        
        for(int i = 0; i < 3; i++){
            mask = 0;
            
            for(int j = 0; j < 3; j++){
                int nowIdx = 8 - (3 * j + i);
                mask = mask | (1 << nowIdx);
            }
            masks[maskArrIdx++] = mask;
        } // 세로 뒤집기
        
        mask = 0;
        for(int i = 0; i < 3; i++){
            int nowIdx = 8 - (4 * i);
            mask = mask | (1 << nowIdx);
            
        } // 대각선 뒤집기 1
        masks[maskArrIdx++] = mask;
        
        mask = 0;
        for(int i = 0; i < 3; i++){
            int nowIdx = 6 - (2 * i);
            mask = mask | (1 << nowIdx);
            
        } //대각선 뒤집기 2
        masks[maskArrIdx++] = mask;
        
    }
    
	
}
