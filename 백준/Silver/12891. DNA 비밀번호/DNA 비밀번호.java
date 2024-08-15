import java.util.*;
import java.io.*;


public class Main
{   
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    int len = Integer.parseInt(st.nextToken());
	    int pwlen = Integer.parseInt(st.nextToken());
	    
	    String str = br.readLine();
	    int[] dna = new int[4];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int idx = 0; idx < 4; idx++){
	        dna[idx] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[] cnt = new int[4];
	    int answer = 0;
	    for(int idx = 0; idx < pwlen; idx++){
	        if(str.charAt(idx) == 'A'){
	            cnt[0]++;
	        }
	        else if(str.charAt(idx) == 'C'){
	            cnt[1]++;
	        }
	        else if(str.charAt(idx) == 'G'){
	            cnt[2]++;
	        }
	        else if(str.charAt(idx) == 'T'){
	            cnt[3]++;
	        }
	    }
	    
	    boolean check = true;
	    for(int idx =0 ; idx <4; idx++){
	        if(dna[idx] > cnt[idx]){
	            check = false;
	            break;
	        }
	    }
	    if(check) answer++;
	    
	    for(int idx = 0; idx < len - pwlen; idx++){
	        
	        if(str.charAt(idx) == 'A'){
	            cnt[0]--;
	        }
	        else if(str.charAt(idx) == 'C'){
	            cnt[1]--;
	        }
	        else if(str.charAt(idx) == 'G'){
	            cnt[2]--;
	        }
	        else if(str.charAt(idx) == 'T'){
	            cnt[3]--;
	        }
	        
	        if(str.charAt(pwlen+idx) == 'A'){
	            cnt[0]++;
	        }
	        else if(str.charAt(pwlen+idx) == 'C'){
	            cnt[1]++;
	        }
	        else if(str.charAt(pwlen+idx) == 'G'){
	            cnt[2]++;
	        }
	        else if(str.charAt(pwlen+idx) == 'T'){
	            cnt[3]++;
	        }
	        
            check = true;
	        for(int i =0 ; i <4; i++){
    	        if(dna[i] > cnt[i]){
    	            check = false;
    	            break;
    	        }
	        }
	        if(check) answer++;
	      
	    }
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
}
