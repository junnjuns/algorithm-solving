import java.util.*;
import java.io.*;




public class Solution {

    static int size;
    static int power;
    static int[][] board;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int test = Integer.parseInt(br.readLine());
    	
    	for(int t = 0; t < test; t++){
    	    bw.write("#"+(t+1)+" ");
    	    
    	    st = new StringTokenizer(br.readLine());
    	    size = Integer.parseInt(st.nextToken());
    	    power = Integer.parseInt(st.nextToken());
    	    
    	    board = new int[size][size];
    	    
    	    for(int h = 0; h < size; h++){
    	        st = new StringTokenizer(br.readLine());
    	        for(int w = 0; w < size; w++){
    	            board[h][w] = Integer.parseInt(st.nextToken());
    	        }
    	    } // board 입력 끝
    	    
    	    int answer = 0;
    	    for(int h = 0; h <= size-power; h++){
    	        for(int w = 0; w <= size-power; w++){
    	            answer = Math.max(answer, sumFunc(h, w));
    	        }
    	    }
    	    bw.write(answer+"\n");
    	    
    	} // 테스트 케이스 끝
    	
    	bw.flush();
    	bw.close();
    }
    static int sumFunc(int startX, int startY){
        int sum = 0;
        
        for(int h = startX; h < startX + power; h++){
            for(int w = startY; w < startY + power; w++){
                sum += board[h][w];
            }
        }
        
        return sum;
    }
}
