import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();

        int answer = 0;
        int temp = 1;

        Stack<Character> stack = new Stack<>();
        for(int idx = 0; idx < str.length(); idx++){
            //현재 괄호
            char ch = str.charAt(idx);

            //시작부터 닫는 괄호면 종료
            if(stack.size() == 0 && (ch == ')' || ch == ']')){
                answer = 0;
                break;
            }

            //열리는 괄호이면 스택에 추가
            else if(ch == '(') {
                stack.add(ch);
                temp *= 2;
            }
            else if(ch == '['){
                stack.add(ch);
                temp *= 3;
            }

            //닫는 괄호일 때
            else if(ch == ')'){
                //짝이 맞으면 스택에서 꺼낸다.
                if(stack.size() != 0 && stack.peek() == '('){
                    stack.pop();
                    //가장 내부 괄호
                    if(str.charAt(idx - 1) == '('){
                        answer += temp;
                    }
                    temp /= 2;
                }
                else{
                    answer = 0;
                    break;
                }

            }
            else if(ch == ']'){
                //짝이 맞으면 스택에서 꺼낸다.
                if(stack.size() != 0 && stack.peek() == '['){
                    stack.pop();
                    //가장 내부 괄호
                    if(str.charAt(idx - 1) == '['){
                        answer += temp;
                    }
                    temp /= 3;
                }
                else{
                    answer = 0;
                    break;
                }
            }

        }

        bw.write( (stack.size() == 0 ? answer : 0)+"");

        bw.flush();
        bw.close();
    }
}
