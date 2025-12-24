import java.util.*;
import java.io.*;

public class Main
{
    static int SIZE = 101;
    static int[][] board;
    static int n, m;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		board = new int[SIZE][SIZE];
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for(int i = 0; i < n; i++){
		    st = new StringTokenizer(br.readLine());
		    
		    int x1 = Integer.parseInt(st.nextToken());
		    int y1 = Integer.parseInt(st.nextToken());
		    int x2 = Integer.parseInt(st.nextToken());
		    int y2 = Integer.parseInt(st.nextToken());
		    
		    for(int w = x1; w < x2 + 1; w++){
		        for(int h = y1; h < y2 + 1; h++){
		            board[w][h] += 1;       
		        }
		    }
		}
		
		for(int[] arr : board){
		    for(int value : arr){
		        if(value > m){
		            answer += 1;
		        }
		    }
		}
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}
