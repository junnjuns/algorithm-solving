import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    long answer = 0;
        answer = (long)Math.pow(2, n) + 1;
	    bw.write(answer*answer+"");
	    
	    bw.flush();
	    bw.close();
	}
}
