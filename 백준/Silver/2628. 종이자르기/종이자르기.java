import java.util.*;
import java.io.*;

public class Main
{   
    
    static int width;
    static int height;
    static int cutCnt;
    
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    width = Integer.parseInt(st.nextToken());
	    height = Integer.parseInt(st.nextToken());
	    
	    cutCnt = Integer.parseInt(br.readLine());
	    
	    ArrayList<Integer> WList = new ArrayList<>();
	    ArrayList<Integer> HList = new ArrayList<>();
	    
	    WList.add(0);
	    WList.add(height);
	    
	    HList.add(0);
	    HList.add(width);
	    
	    for(int idx = 0; idx < cutCnt; idx++){
	        st = new StringTokenizer(br.readLine());
	        
	        int type = Integer.parseInt(st.nextToken());
	        int start = Integer.parseInt(st.nextToken());
	        
	        //가로 커팅
	        if(type == 0){
	            WList.add(start);
	        }
	        //세로 커팅
	        else{
	            HList.add(start);
	        }
	    } 
	              
	    Collections.sort(WList, Collections.reverseOrder());
	    Collections.sort(HList, Collections.reverseOrder());
	       
	    int Wmax = 0;
	    for(int i = 0; i < WList.size() - 1; i++){
	       Wmax = Math.max(Wmax, WList.get(i) - WList.get(i + 1));
	    }
	    
	    int Hmax = 0;
	    for(int i = 0; i < HList.size() - 1; i++){
	       Hmax = Math.max(Hmax, HList.get(i) - HList.get(i + 1));
	    }
	    
	    int answer = Wmax * Hmax;
	    bw.write(answer+"");
	    
	    bw.flush();
	    bw.close();
	}
}
