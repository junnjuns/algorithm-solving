import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int next = 1;
		StringBuilder sb = new StringBuilder();
		
		for(int idx = 0; idx < n; idx++){
		    int num = Integer.parseInt(br.readLine());
		    
		    if(next <= num){
		        for(int j = next; j <= num; j++){
		            dq.add(next);
		            sb.append("+\n");
		            next += 1;
		            
		        }
		    }
		    
		    if(dq.isEmpty() || dq.pollLast() != num){
		        System.out.print("NO");
		        return;
		    }
		    
		    sb.append("-\n");
		}
		
		
		System.out.println(sb.toString());
		
		bw.flush();
		bw.close();
		
	}
}
