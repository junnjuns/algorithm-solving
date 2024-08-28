import java.util.*;
import java.io.*;


public class Main {
    
    static int personCnt;
    static int relationCnt;
    static ArrayList<Integer>[] list;
    static boolean[] vis;
    static boolean check;
    
	static BufferedReader br; 
	static BufferedWriter bw; 
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
	    st = new StringTokenizer(br.readLine());
	    personCnt = Integer.parseInt(st.nextToken());
	    relationCnt = Integer.parseInt(st.nextToken());
	    
	    list = new ArrayList[personCnt];
	    
	    for(int idx = 0; idx < personCnt; idx++){
	        list[idx] = new ArrayList<Integer>();
	    }
	    
	    for(int idx = 0; idx < relationCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        int person1 = Integer.parseInt(st.nextToken());
	        int person2 = Integer.parseInt(st.nextToken());
	        
	        list[person1].add(person2);
	        list[person2].add(person1);
	        
	    }
	    
	    
	    for(int idx = 0; idx < personCnt; idx++){
	        vis = new boolean[personCnt];
	        check = false;
	        vis[idx] = true;
	        
	        find(idx, 0); // idx 번째 사람 부터 시작
	        
	        if(check){
	            break;
	        }
	    }
	    
	    if(check){
	        bw.write("1");
	    }
	    else{
	        bw.write("0");
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static void find(int start, int dep){
	    if(dep == 4){
	        check = true;
	        return;
	    }
	    
	    for(int idx = 0; idx < list[start].size(); idx++){
	        
	        if(vis[list[start].get(idx)] == false){
	            
	            vis[list[start].get(idx)] = true;
	            find(list[start].get(idx), dep + 1);
	            vis[list[start].get(idx)] = false;
	            
	        }
	        
	    }
	    
	}
	
    
}