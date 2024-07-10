import java.util.*;
import java.io.*;

public class Main
{   
    static int n;
    static boolean[] vis;
    static ArrayList<Integer>[] list;
    static int start;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        vis = new boolean[n];
        list = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            int jump1 = i + num;
            int jump2 = i - num;
            
            if(jump1 >=0 && jump1<n){
                list[i].add(jump1);
            }
            if(jump2 >=0 && jump2<n){
                list[i].add(jump2);
            }
        }
        
        start = Integer.parseInt(br.readLine()) - 1;
        
        bfs(start);
        
        int cnt = 0;
        for(boolean b : vis){
            if(b == true){
                cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
    static void bfs(int start){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        vis[start] = true;
        
        while(dq.size() != 0){
            int now = dq.poll();
            
            for(int i=0; i<list[now].size(); i++){
                if(vis[list[now].get(i)] == false){
                    dq.add(list[now].get(i));
                    vis[list[now].get(i)] = true;
                }
            }
        }
    }
    
}