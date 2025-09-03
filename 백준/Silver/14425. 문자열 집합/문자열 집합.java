
import java.util.*;
import java.io.*;

public class Main
{   
    
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken()); // 10,000
	    int m = Integer.parseInt(st.nextToken()); // 10,000
	    
	    Set<String> set = new HashSet<>();
	    
	    for(int idx = 0; idx < n; idx++){
	        set.add(br.readLine());
	    }
	    
	    int answer = 0;
	    for(int idx = 0; idx < m; idx++){
	        if(set.contains(br.readLine())){
	            answer += 1;
	        }
	    }
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
}
