import java.util.*;
import java.io.*;



class Solution {
	
	static int size;
	static String direction;
	static int[][] board;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine()); //테스트 케이스 입력
		
		for(int t = 0; t < test; t++){
		    bw.write("#"+(t+1)+"\n");
		    
		    st = new StringTokenizer(br.readLine());
		    size = Integer.parseInt(st.nextToken()); // board 크기 입력 받음
		    direction = st.nextToken(); //방향 입력 받음
		    
		    board = new int[size][size];
		    
		    for(int h = 0; h < size; h++){
		        st = new StringTokenizer(br.readLine());
		        for(int w = 0 ; w < size; w++){
		            board[h][w] = Integer.parseInt(st.nextToken());
		        }
		    } //board 입력
		    
		    if(direction.equals("left")){
		        moveLeft();
		    }
		    else if(direction.equals("right")){
		        moveRight();
		    }
		    else if(direction.equals("up")){
		        moveUp();
		    }
		    else if(direction.equals("down")){
		        moveDown();
		    }
		    
		    for(int[] i : board){
		        for(int j : i){
		            if(j < 0){
		                bw.write((j*-1)+" ");
		            }
		            else{
		                bw.write(j+" ");    
		            }
		            
		        }
		        bw.newLine();
		    }
		    
		    
		} //테스트 케이스 끝
		
		
		bw.flush();
		bw.close();
	}
	static void moveUp(){
	    
	    for(int w = 0; w < size; w++){
	        
	        for(int h = 1; h < size; h++){ // 1부터 size - 1 순서로 확인 (위에서 부터 밑으로)
	            if(board[h][w] != 0){ //현재 시작 값이 0이 아닐때만 올라감
	                
	                int nowH = h; //현재 위치
	                int nextH = h-1; //다음 볼 위치
	                
	                while(true){ //0이 아닌 값을 만날때까지 위로 직진
	                    
	                    if(nextH >= 0){ //조건 : board 범위 내
    	                    if(board[nextH][w] != 0){ //만약 위로 가면서(다음으로 볼 곳에) 값이 있을 떄
    	                        
    	                        if(board[nextH][w] == board[nowH][w]){ //같은 타일 만났을 때
    	                           board[nextH][w] += board[nowH][w];
    	                           board[nowH][w] = 0;
    	                           board[nextH][w] *= -1;
    	                        }
    	                        
    	                        break;
    	                    }
    	                    else{ //만약 위로 가면서 값이 없을 때
    	                        board[nextH][w] = board[nowH][w]; //현재 값 다음 위치로 이동
    	                        board[nowH][w] = 0; //현재 자리 0으로 초기화
    	                        nextH--;
    	                        nowH--;
    	                    }
	                    }
	                    
	                    else{//범위를 벗어나면 종료
	                        break;
	                    }
	                    
	                }
	                
	            }
	        }    
	    }
	}
	
	static void moveDown(){
	    
	    for(int w = 0; w < size; w++){
	        
	        for(int h = size-2; h >= 0; h--){ // 1부터 size - 1 순서로 확인 
	            if(board[h][w] != 0){ //현재 시작 값이 0이 아닐때만 올라감
	                
	                int nowH = h; //현재 위치
	                int nextH = h+1; //다음 볼 위치
	                
	                while(true){ //0이 아닌 값을 만날때까지 
	                    
	                    if(nextH < size){ //조건 : board 범위 내
    	                    if(board[nextH][w] != 0){ //만약 다음으로 볼 곳에 값이 있을 떄
    	                        
    	                        if(board[nextH][w] == board[nowH][w]){ //같은 타일 만났을 때
    	                           board[nextH][w] += board[nowH][w];
    	                           board[nowH][w] = 0;
    	                           board[nextH][w] *= -1;
    	                        }
    	                        
    	                        break;
    	                    }
    	                    else{ //만약 값이 없을 때
    	                        board[nextH][w] = board[nowH][w]; //현재 값 다음 위치로 이동
    	                        board[nowH][w] = 0; //현재 자리 0으로 초기화
    	                        nextH++;
    	                        nowH++;
    	                    }
	                    }
	                    
	                    else{//범위를 벗어나면 종료
	                        break;
	                    }
	                    
	                }
	                
	            }
	        }    
	    }
	}
	
	static void moveRight(){
	    
	    for(int h = 0; h < size; h++){
	        
	        for(int w = size-2; w >= 0; w--){ 
	            if(board[h][w] != 0){ 
	                
	                int nowW = w; //현재 위치
	                int nextW = w+1; //다음 볼 위치
	                
	                while(true){ //0이 아닌 값을 만날때까지 
	                    
	                    if(nextW < size){ //조건 : board 범위 내
    	                    if(board[h][nextW] != 0){ //만약 다음으로 볼 곳에 값이 있을 떄
    	                        
    	                        if(board[h][nextW] == board[h][nowW]){ //같은 타일 만났을 때
    	                           board[h][nextW] += board[h][nowW];
    	                           board[h][nowW] = 0;
    	                           board[h][nextW] *= -1;
    	                        }
    	                        break;
    	                    }
    	                    else{ //만약 값이 없을 때
    	                        board[h][nextW] = board[h][nowW]; //현재 값 다음 위치로 이동
    	                        board[h][nowW] = 0; //현재 자리 0으로 초기화
    	                        nextW++;
    	                        nowW++;
    	                    }
	                    }
	                    
	                    else{//범위를 벗어나면 종료
	                        break;
	                    }
	                    
	                }
	                
	            }
	        }    
	    }
	}
	
	static void moveLeft(){
	    
	    for(int h = 0; h < size; h++){
	        
	        for(int w= 1; w < size; w++){ 
	            if(board[h][w] != 0){ 
	                
	                int nowW = w; //현재 위치
	                int nextW = w-1; //다음 볼 위치
	                
	                while(true){ //0이 아닌 값을 만날때까지 
	                    
	                    if(nextW >= 0){ //조건 : board 범위 내
    	                    if(board[h][nextW] != 0){ //만약 다음으로 볼 곳에 값이 있을 떄
    	                        
    	                        if(board[h][nextW] == board[h][nowW]){ //같은 타일 만났을 때
    	                           board[h][nextW] += board[h][nowW];
    	                           board[h][nowW] = 0;
    	                           board[h][nextW] *= -1;
    	                        }
    	                        break;
    	                    }
    	                    else{ //만약 값이 없을 때
    	                        board[h][nextW] = board[h][nowW]; //현재 값 다음 위치로 이동
    	                        board[h][nowW] = 0; //현재 자리 0으로 초기화
    	                        nextW--;
    	                        nowW--;
    	                    }
	                    }
	                    
	                    else{//범위를 벗어나면 종료
	                        break;
	                    }
	                    
	                }
	                
	            }
	        }    
	    }
	}
}
