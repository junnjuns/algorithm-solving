import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static Map<String, Integer> map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int test = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < test; t++){
            n = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            
            int answer = 1;
            
            for(int idx = 0; idx < n; idx++){
                st = new StringTokenizer(br.readLine());
                
                String name = st.nextToken();
                String type = st.nextToken();
                
                if(!map.containsKey(type)){
                    map.put(type, 1);
                }
                else{
                    map.put(type ,map.get(type) + 1);
                }
            } //map 초기화 끝
            
            Collection<Integer> values = map.values();
            List<Integer> list = new ArrayList<>(values);
            
            for(int i : list){
                answer *= i+1;
            }
            bw.write((answer-1)+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}
