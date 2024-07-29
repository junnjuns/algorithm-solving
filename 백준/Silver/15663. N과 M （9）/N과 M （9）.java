import java.util.*;
import java.io.*;

public class Main{
    
    static BufferedWriter bw;
    static boolean[] used;
    static int n,m;
    static int[] ans;
    static int[] arr;
    static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++){
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(arr);
	    
	    
	    
	    ans = new int[m];
	    used = new boolean[n];
	    
	    func(0);
	    
	    
	    bw.flush();
	    bw.close();
    }
    
    static void func(int k) throws Exception{
        if(k == m){
            for(int i=0; i<m; i++){
                bw.write(ans[i]+" ");
            }
            bw.newLine();
            return;
        }
        
        int before = -1;
        for(int i=0; i<n; i++){
            if(before != arr[i]){
                if(used[i] == false){
                    used[i] = true;
                    ans[k] = arr[i];
                    before = arr[i];
                    func(k+1);
                    used[i] = false;
                }
            }
        }
    }
}


