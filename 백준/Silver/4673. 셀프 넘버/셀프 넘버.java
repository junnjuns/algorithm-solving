import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] vis = new boolean[10001];
		
		for(int i=1; i<10001; i++){
		    
		    int n = i;
		    int num = i;
		    
		    
		    while(n != 0){
		        num += (n % 10);
		        n /=10;
		    }
		    
		    if(num < 10001){
		        vis[num] = true;
		    }
		    
		}
		
		
		for(int i=1; i<10001; i++){
		    if(!vis[i])
		        bw.write(i+"\n");
		}

		
		bw.flush();
		bw.close();
	}
}
