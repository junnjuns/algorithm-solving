import java.util.*;
import java.io.*;




public class Main {
    
    static int len;
    static int count;
    static char[] alphabet;
    static BufferedWriter bw;
    static char[] selectArr;
    static boolean[] vis;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        len = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        
        vis = new boolean[count];
        alphabet = new char[count];
        selectArr = new char[len];
        
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < count; idx++){
            alphabet[idx] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(alphabet);
        permut(0, 0);
        
        bw.close();
    }
    
    static void permut(int select,int start) throws Exception {
        if(select == len){
            
            boolean check = false;
            int cnt = 0;
            for(char c : selectArr){
                if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u'){
                    check = true;
                    cnt++;
                }
            }
            
            if(cnt > len - 2){
                return;
            }
            
            if(check){
                for(char c : selectArr){
                    bw.write(c+"");    
                }
                bw.newLine();
            }
            return;
        }
        
        for(int idx = start; idx < count; idx++){
            if(vis[idx]) continue;
            
            
            vis[idx] = true;
            selectArr[select] = alphabet[idx];
            permut(select + 1, idx);
            vis[idx] = false;
            
        }
        
    }
    
}
