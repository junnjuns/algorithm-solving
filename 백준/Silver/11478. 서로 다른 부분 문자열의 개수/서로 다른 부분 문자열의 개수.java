
import java.util.*;
import java.io.*;

public class Main
{   
    
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    String str = br.readLine();
	    Set<String> set = new HashSet<>();
	    for(int i = 0; i < str.length(); i++){
	        for(int j = i + 1; j < str.length() + 1; j++){
	            set.add(str.substring(i, j));
	        }
	    }
	    
	    bw.write(set.size()+"");
	    
	    bw.flush();
	    bw.close();
	}
	
}
