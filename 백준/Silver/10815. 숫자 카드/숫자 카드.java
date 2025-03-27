import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static int m;
    static int[] arrA;
    static int[] arrB;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    Set<Integer> set = new HashSet<>();
	    for(int idx = 0; idx < n; idx++){
	       set.add(Integer.parseInt(st.nextToken()));
	    }
	    
	    m = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append("1 ");  
            }
            else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);
	}

}
