import java.util.*;
import java.io.*;


public class Main
{   
    
    static int total;
    static int cnt;
    static Map<String, String> map;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    total = Integer.parseInt(st.nextToken());
	    cnt = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        	    
	    for(int idx = 0; idx < total; idx++){
	        st = new StringTokenizer(br.readLine());
	        
	        map.put(st.nextToken(), st.nextToken());
	    }
	    
	    
	    for(int idx = 0; idx < cnt; idx++){
	       bw.write(map.get(br.readLine())+"\n");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	
}
