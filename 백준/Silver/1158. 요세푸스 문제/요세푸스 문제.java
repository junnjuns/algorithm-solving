import java.util.*;
import java.io.*;

public class Main
{
    static int n, k;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		for(int idx = 0; idx < n; idx++){
		    dq.add(idx + 1);
		}
		
		int cnt = 0;
		bw.write("<");
		while(dq.size() != 1){
		    
		    int num = dq.poll();
		    cnt += 1;
		    
		    if(cnt == k){
		        cnt = 0;
		        bw.write(num+", ");
		    }
		    else{
		        dq.add(num);
		    }
		    
		}
		bw.write(dq.poll()+">");
		
		bw.flush();
		bw.close();
		
	}
}
