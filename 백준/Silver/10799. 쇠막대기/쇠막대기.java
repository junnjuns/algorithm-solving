// 레이저가 나오면 레이저 이전 막대기 개수 더하기 == 스택 크기 더하기
// 닫는 괄호 나오면 레이저 이후 막대기 개수 더하기 == 괄호당 + 1 더하기

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String str = br.readLine();
		
		ArrayDeque<Character> dq = new ArrayDeque<>();
		
		char pre = '0';
		int answer = 0;
		
		for(int i = 0; i < str.length(); i++){
		    char ch = str.charAt(i);
		    
		    if(ch == '('){
		        dq.add(ch);
		    }
		    else{
		        if(pre == '('){
		            dq.pollLast();
		            answer += dq.size();
		        } //레이저
		        else{
		            dq.pollLast();
		            answer += 1;
		        } // 막대 끝
		        
		    }
		    pre = ch;
		}
		
	    bw.write(answer+"");
        bw.flush();
        bw.close();
    }
    
}
