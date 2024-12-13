import java.util.*;
import java.io.*;

public class Main
{
    static int col;
    static int row;
    static int storeCnt;
    static int dir;
    static int dist;
    static int[] load;
    static int[] stores;
    static int answer;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    col = Integer.parseInt(st.nextToken());
	    row = Integer.parseInt(st.nextToken());
	    
	    load = new int[2 * col + 2 * row];
	    
	    storeCnt = Integer.parseInt(br.readLine());
	    stores = new int[storeCnt];
	    
	    for(int idx = 0; idx < storeCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        int direction = Integer.parseInt(st.nextToken());
	        int distance = Integer.parseInt(st.nextToken());
	        
	        //북
	        if(direction == 1){
	            load[distance] = idx + 1;
	            stores[idx] = distance;
	        }
	        //남
	        else if(direction == 2){
	            load[col + row + col - distance] = idx + 1;
	            stores[idx] = col + row + col - distance;
	        }
            //서	        
	        else if(direction == 3){
	            load[2 * col + 2 * row - distance] = idx + 1;
	            stores[idx] = 2 * col + 2 * row - distance;
	        }
	        //동
	        else if(direction == 4){
	            load[col + distance] = idx + 1;
	            stores[idx] = col + distance;
	        }
	        
	    }
	    
	    
	    st = new StringTokenizer(br.readLine());
	    dir = Integer.parseInt(st.nextToken()); // 1 2 3 4 : 북 남 서 동
	    dist = Integer.parseInt(st.nextToken());
	    int distance = 0;
	    
	    	        //북
	        if(dir == 1){
	            load[dist] = -1;
	            distance = dist;
	        }
	        //남
	        else if(dir == 2){
	            load[col + row + col - dist] = -1;
	            distance = col + row + col - dist;
	        }
            //서	        
	        else if(dir == 3){
	            load[2 * col + 2 * row - dist] = -1;
	            distance = 2 * col + 2 * row - dist;
	        }
	        //동
	        else if(dir == 4){
	            load[col + dist] = -1;
	            distance = col + dist;
	        }
	        
	    
	   for(int idx = 0 ; idx < stores.length; idx++){
            answer += Math.min(Math.abs(distance - stores[idx]) , 2 * col + 2 * row - Math.abs(distance - stores[idx]));        
	    }
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
}
