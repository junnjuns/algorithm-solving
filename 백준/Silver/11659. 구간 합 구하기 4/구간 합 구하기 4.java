import java.util.*;
import java.io.*;


public class Main {

    static int number;
    static int cnt;
    static int[] numArr;
    static int[] sumArr;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	number = Integer.parseInt(st.nextToken());
    	cnt = Integer.parseInt(st.nextToken());
    	numArr = new int[number];
    	sumArr = new int[number];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int idx = 0; idx < number; idx++){
    	    numArr[idx] = Integer.parseInt(st.nextToken());
    	} // numArr 입력 끝
    	
    	sumArr[0] = numArr[0];
    	
    	for(int idx = 1; idx < number; idx++){
    	    sumArr[idx] = sumArr[idx-1] + numArr[idx];
    	}
    	
    	for(int idx = 0; idx < cnt; idx++){
    	    st = new StringTokenizer(br.readLine());
    	    int start = Integer.parseInt(st.nextToken()) - 1;
    	    int end = Integer.parseInt(st.nextToken()) - 1;
    	    
    	    if(start == 0){
    	        bw.write(sumArr[end]+"\n");
    	    }
    	    else{
    	        bw.write((sumArr[end] - sumArr[start-1])+"\n");
    	    }
    	}
        	
        
        bw.flush();
        bw.close();
    }
    
}
