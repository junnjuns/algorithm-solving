import java.util.*;
import java.io.*;

public class Main
{   
    static class Info implements Comparable<Info>{
        int left;
        int right;
        int sum;
        
        public Info(int left, int right, int sum){
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
        
        public int compareTo(Info o1){
            return this.sum - o1.sum;
        }
    }
    
    static int n;
    static int[] arr;
    static PriorityQueue<Info> pq = new PriorityQueue<>();
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
	    st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < n ; idx++){
		    arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		Arrays.sort(arr);
		
		binary(0, n - 1);
		
		Info info = pq.poll();
		bw.write(arr[info.left]+" "+arr[info.right]);
		
		bw.flush();
		bw.close();
	}
	
	static void binary(int left, int right){
	    if(left >= right){
	        
	        return;
	    }
	    
	    int result = Math.abs(arr[left] + arr[right]);
	    
	    pq.add(new Info(left, right, result));
	    
	    if(arr[left] + arr[right] <= 0){
	        binary(left + 1, right);
	    }
	    else{
	        binary(left, right - 1);
	    }
	   
	}
	
}
