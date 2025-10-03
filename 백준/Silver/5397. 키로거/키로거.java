// 최대 100만 문자열
// 지우기 -> '-'
// 커서 위치 저장 변수 생성 (최소 0)
// 한 글자씩 반복문 진행하기
    // 문자 추가될때마다 커서 위치 + 1
    // 백스페이스 나오면 해당 위치 문제 삭제 후 커서 위치 - 1


import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    for(int t = 0; t < test; t++){
	        
	        String input = br.readLine();
	        int cursor = 0;
	        List<Character> list = new LinkedList();
	        
	        
	        for(int idx = 0; idx < input.length(); idx++){
	            char ch = input.charAt(idx);
	            
	            if(ch == '<'){
	                cursor = cursor - 1 >= 0 ? cursor - 1 : 0;
	                // System.out.println(cursor);
	            }
	            else if(ch == '>'){
	                cursor = cursor + 1 <= list.size() ? cursor + 1 : list.size();
	                // System.out.println(cursor);
	            }
	            
	            else if(ch == '-'){
	                if(cursor == 0){
	                    continue;
	                }
	                
	                cursor = cursor - 1 >= 0 ? cursor - 1 : 0;
	                list.remove(cursor);
	            }
	            else{
	                list.add(cursor, ch);
	                cursor += 1;
	            }
	            
	        }
	        
	        
	        for(char ch : list){
	            bw.write(ch+"");
	        }
	        bw.newLine();
	        
	    }
	    
	    
	    bw.flush();
	    bw.close();
	}
}
