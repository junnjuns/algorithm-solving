// 길이 64 cm 있음
// 길이가 X인 막대 만들기


import java.util.*;
import java.io.*;

public class Main
{   
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		int n = Integer.parseInt(br.readLine());
		
        int answer = Integer.bitCount(n);
        
		bw.write(answer+"");
		
		bw.flush();
		bw.close();
	}

}
