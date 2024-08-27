import java.util.*;
import java.io.*;


public class Main {
    
    static int person[];
    static int personCnt;
    static ArrayList<Integer>[] list;
    static int test;
    static ArrayDeque<Integer> dq;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        personCnt = Integer.parseInt(st.nextToken());
        test = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[personCnt + 1];
        person = new int[personCnt + 1];
        
        person[0] = -1;
        
        for(int idx = 0; idx <=personCnt; idx++){
            list[idx] = new ArrayList<Integer>();
        }
        
        for(int idx = 0; idx < test; idx++){
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            
            list[person1].add(person2);
            person[person2]++;
        }
        
        dq = new ArrayDeque<>();
        
        for(int idx = 1; idx <= personCnt; idx++){
            if(person[idx] == 0){
                dq.add(idx);
            }
        }
        
        sortFunc();
        
        
        
        bw.flush();
        bw.close();
    }
    
    static void sortFunc() throws Exception{
        
        while(dq.size() != 0){
            int now = dq.poll();
            
            bw.write(now+" ");
            ArrayList<Integer> num = list[now];
            
            for(int idx = 0; idx< num.size(); idx++){
                person[num.get(idx)] -= 1;
                if(person[num.get(idx)] == 0){
                    dq.add(num.get(idx));
                }
            }
            
        }
        
    }
    
}
