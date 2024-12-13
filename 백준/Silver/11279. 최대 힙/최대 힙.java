import java.util.*;
import java.io.*;

public class Main
{   
    static class Value implements Comparable<Value>{
        
        int value;
        
        public Value(int value){
            this.value = value;
        }
        
        public int compareTo(Value o){
            return -Integer.compare(this.value , o.value);
        }
    }
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int cnt = Integer.parseInt(br.readLine());
	    
	    PriorityQueue<Value> pq = new PriorityQueue<>();
	    
	    for(int idx = 0; idx < cnt; idx++){
	        int num = Integer.parseInt(br.readLine());
	        
	        if(num == 0){
	            if(pq.size() != 0){
	                bw.write(pq.poll().value+"\n");
	            }
	            else{
	                bw.write("0\n");
	            }
	        }
	        else{
	            pq.add(new Value(num));
	        }
	    }
	    
	    bw.flush();
	    bw.close();
	}
}
