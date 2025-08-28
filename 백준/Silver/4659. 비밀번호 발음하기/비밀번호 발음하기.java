// 모음 최소 하나 반드시 포함
// 모음 3개 연속 오면 안됨
// 자음 3개 연속 오면 안됨
// 같은 글자가 연속으로 두번 오면 안됨.
    // 단 =, ee와 oo는 허용
    
    
// 문자열 하나씩 확인하면서 나아가기
    // 앞뒤 확인하면서 연속된 같은 글자 판단
    // 자음 변수 나올때마다 자음 cnt + 1, 모음 cnt = 0 -> 만약 3이 된다면 실패
    // 모음 변수 나올때마다 모음 cnt + 1, 자음 cnt = 0 -> 만약 3이 된다면 실패
    // 한번이라도 모음 나왔다면 boolean 변수 true


import java.util.*;
import java.io.*;

public class Main
{
    static char[] arr = {'a', 'e', 'i', 'o', 'u'};
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        while(true){
            String str = br.readLine();
            
            if(str.equals("end")){
                break;
            } // 종료 조건
            
            int consonantCnt = 0; //자음 카운팅 변수
            int vowelCnt = 0; //모음 카운팅 변수
            boolean existVowel = false;
            boolean possible = true;
            char pre = ' ';
            
            for(int idx = 0; idx < str.length(); idx++){
                char now = str.charAt(idx);
                
                //연속으로 같은 글자 일 때 실패 (e 와 o 제외)
                if(pre == now){
                    if(!(pre == 'e' && now == 'e') && !(pre =='o' && now =='o')){
                        possible = false;
                        break;
                    }
                }
                
                //모음이면 true 자음이면 false
                boolean check = false;
                
                // 한번이라도 모음 나왔다면 boolean 변수 true
                    for(char ch : arr){
                        if(ch == now){
                            check = true;
                            existVowel = true;
                        }
                    }
                
                // 모음일 때
                if(check){
                    vowelCnt += 1;
                    consonantCnt = 0;
                    if(vowelCnt == 3){
                        possible = false;
                        break;
                    }
                }
                //자음일 때
                else{
                    consonantCnt += 1;
                    vowelCnt = 0;
                    if(consonantCnt == 3){
                        possible = false;
                        break;
                    }
                }
                
                pre = now;
            }
            
            if(!existVowel){
                possible = false;
            }
            if(possible){
                bw.write("<"+ str + ">" + " is acceptable.\n");
            }
            else{
                bw.write("<"+ str + ">" + " is not acceptable.\n");
            }
            
        }
        
        
        bw.flush();
        bw.close();
        
    }
}
