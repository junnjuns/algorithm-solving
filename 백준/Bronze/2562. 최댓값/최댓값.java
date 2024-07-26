import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9];
        int max = arr[0];
        int idx = 0;
        
        for(int i=0; i<9; i++){
            StringTokenizer stz = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(stz.nextToken());
            if(max < arr[i]){
                max = arr[i];
                idx = i+1;
            }            
            
        }
        
        bw.write(max+"\n");
        bw.write(idx+"");
        
        bw.close();
	}
}
