import java.util.*;
import java.io.*;

public class Solution
{   
    static int size;
    static int[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int dir;
    static ArrayList<int[]> list;
    static int coreCnt;
    static int[] dirArr;
    static int answer;
    static int countLen;
    static int answerCoreCnt;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t = 0; t < test; t++){ 
	        bw.write("#"+(t+1)+" ");
	        
	        size = Integer.parseInt(br.readLine());
	        
	        list = new ArrayList<>();
	        board = new int[size][size];
	        for(int h = 0; h < size; h++){
	            st = new StringTokenizer(br.readLine());
	            for(int w = 0; w < size; w++){
	                board[h][w] = Integer.parseInt(st.nextToken());
	                if(h != 0 && h != size-1 && w != 0 && w != size-1 && board[h][w] != 0 ){ 
                        list.add(new int[] {h, w});
                    }
	            }
	        } //board 입력 끝
	        answer = Integer.MAX_VALUE;
	        answerCoreCnt = 0;
	        func(0, 0, 0); // 현재 깊이, 현재 연결 코어 수, 현재 길이
            	       
            bw.write(answer+"\n"); 
	    }// 테스트 케이스 끝
	    
	    
	    bw.flush();
	    bw.close();
	}
	
	static void func(int dep, int coreCnt, int len){
	    if(dep == list.size()){
	        
            if(coreCnt > answerCoreCnt || (coreCnt == answerCoreCnt && len < answer)){
                answerCoreCnt = coreCnt;
                answer = len;
            }
	        return;
	    }
	    
	    int x = list.get(dep)[0];
	    int y = list.get(dep)[1];
	    
	    for(int k = 0 ; k < 4; k++){
	        
	        int curLen = 0;
	        int nx = x;
	        int ny = y;
	        
	        while(true){
	            nx += dx[k];
	            ny += dy[k];
	            
	            if(nx >= 0 && ny >= 0 && nx < size && ny < size){
	                if(board[nx][ny] != 0){
	                    curLen = 0;
	                    break;
	                }
	                else if(board[nx][ny] == 0){
	                    curLen++;
	                }
	            }
	            else{
	                break;
	            }
	            
	        }
	        if(curLen != 0){ //갈 수 있는 방향
	            
	            for(int idx = 0; idx < curLen; idx++){
    	            int dirX = x + (dx[k] * (idx+1));
    	            int dirY = y + (dy[k] * (idx+1));
    	            board[dirX][dirY] = -1;
	            }
	            
	            func(dep + 1, coreCnt + 1, len + curLen);
	            
	            for(int idx = 0; idx < curLen; idx++){
    	            int dirX = x + (dx[k] * (idx+1));
    	            int dirY = y + (dy[k] * (idx+1));
    	            board[dirX][dirY] = 0;
	            }
	        }
	    }
	    
	    
	    func(dep + 1, coreCnt, len); //연결 안 했을 때
	}
}
