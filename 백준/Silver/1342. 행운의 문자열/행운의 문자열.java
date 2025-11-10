import java.util.*;
import java.io.*;

public class Main
{   
    
    static String str;
    static Map<Character, Integer> map;
    static int answer;
    static char[] elementArr;
    static int[] counts;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
	    
	    
	    str = br.readLine();
	    
	    map = new HashMap<>();
	    
	    for(int i = 0; i < str.length(); i++){
	        char ch = str.charAt(i);
	        
	        int num = map.containsKey(ch) == true ? map.get(ch) + 1 : 1;
	        
	        map.put(ch, num);
	    }
	    
	    elementArr = new char[map.size()];
	    counts = new int[map.size()];
	    int index = 0;
	    for(Map.Entry<Character, Integer> m : map.entrySet()){
	        elementArr[index] = m.getKey();
	        counts[index] = m.getValue();
	        index += 1;
	    }
	    
	    
	    func(counts, -1, str.length());
	    
	    bw.write(answer+"");
	    bw.flush();
	    bw.close();
	}
	
	static void func(int[] counts, int lastIdx, int len) throws Exception {
	    if(len == 0){
	        
	        answer += 1;
	        return;
	    }
	    
        for(int i = 0; i < elementArr.length; i++){
            if(i == lastIdx) continue;
            if(counts[i] <= 0) continue;
            
            counts[i] -= 1; 
            func(counts, i, len - 1);
            counts[i] += 1;
        }
	    
	}
	
}
