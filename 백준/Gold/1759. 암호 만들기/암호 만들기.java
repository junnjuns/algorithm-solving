//  최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성


import java.util.*;
import java.io.*;

public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n, m;
    static char[] elementArr;
    static char[] selectArr;
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    elementArr = new char[m];
	    selectArr = new char[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int idx = 0; idx < m; idx++){
	        elementArr[idx] = st.nextToken().charAt(0);
	    }
	    
	    Arrays.sort(elementArr);
	    
	    func(0, 0);
	    
	    bw.flush();
	    bw.close();
	    
    }
    
    static void func(int depth, int start) throws Exception {
        if(depth == n){
            int cnt = 0;
            
            for(char ch : selectArr){
                for(char vw : vowel){
                    if(ch == vw){
                        cnt += 1;
                    }
                }
            }
            
            if(cnt > 0 && cnt <= n - 2 ){
                for(char ch : selectArr){
                    bw.write(ch+"");
                }
                bw.newLine();
            }
            
            return;
        }
        
        for(int idx = start; idx < m; idx++){
            
            selectArr[depth] = elementArr[idx];
            func(depth + 1, idx + 1);
        }
        
        
        
    }
    
}