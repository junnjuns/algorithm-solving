import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        String input = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(int idx = 0; idx < input.length(); idx++){
            char ch = input.charAt(idx);
            
            if(ch == 'X'){
                cnt += 1;
            }
            else{
                
                if(cnt % 2 != 0){
                    System.out.print(-1);
                    return;
                }
                else{
                    for(int i = 0; i < cnt / 4; i++){
                        sb.append("AAAA");
                    }
                    if(cnt % 4 != 0){
                        sb.append("BB");
                    }
                }
                cnt = 0;
                sb.append(".");
            }
        }
        if(cnt % 2 != 0){
            System.out.print(-1);
            return;
        }
        for(int i = 0; i < cnt / 4; i++){
            sb.append("AAAA");
        }
        if(cnt % 4 != 0){
            sb.append("BB");
        }
        
        bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	}
    
}
