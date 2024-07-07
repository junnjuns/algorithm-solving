import java.util.*;
import java.io.*;

public class Solution
{   
    static int[][] board;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t=0; t<test; t++){
	        bw.write("#"+(t+1)+"\n");
	        int n = Integer.parseInt(br.readLine());
	        
	        int[][] arr = new int[n][n];
	        String[][] answer = new String[n][3]; //90, 180, 270 정보 담는 정답 배열
	        
	        for(int i=0; i<n; i++){
	            st = new StringTokenizer(br.readLine());
	            for(int j=0; j<n; j++){
	                arr[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	            for(int i=0; i<3; i++){
	                rotation(arr, n);
	                
	                for(int j=0; j<n; j++){
	                    String s = "";
	                    for(int k=0; k<n; k++){
	                        s += arr[j][k];
	                    }
	                    answer[j][i] = s;
	                }
	            }
	            
	            for(String[] s : answer){
	                for(String str : s){
	                    bw.write(str+" ");
	                }
	                bw.newLine();
	            }
	    } //테스트 케이스 끝
	    bw.flush();
	    bw.close();
	}
	
	static void rotation(int[][] arr, int n){ //90도 회전시켜주는 함수
	    int[][] temp = new int[n][n];
	    
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            temp[i][j] = arr[n-1-j][i];
	        }
	    }
	    
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            arr[i][j] = temp[i][j];
	        }
	    }
	    
	}
}
