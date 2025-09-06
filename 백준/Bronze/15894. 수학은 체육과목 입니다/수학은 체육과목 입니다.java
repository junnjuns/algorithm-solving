
import java.util.*;
import java.io.*;

public class Main
{   
    
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    long n = Integer.parseInt(br.readLine());
	    
	    
	    bw.write(n * 4+"");
	    bw.flush();
	    bw.close();
	}
	
}

