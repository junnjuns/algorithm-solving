
import java.util.*;
import java.io.*;

public class Main {

    static boolean[][][] vis;
    static int A,B,C;
    static PriorityQueue<Integer> pq;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        vis = new boolean[A + 1][B + 1][C + 1];
        pq = new PriorityQueue<>();
        
        bfs();
        
        while(pq.size() != 0){
            bw.write(pq.poll()+" ");
        }
        
        bw.flush();
        bw.close();
    }
    
    
    static void bfs(){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0, 0, C});
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            int a = now[0];
            int b = now[1];
            int c = now[2];
            
            if(vis[a][b][c] == true){
                continue;
            }
            vis[a][b][c] = true;
            
            if(a == 0){
                pq.add(c);
            }
            
            //A -> 
            if(a + b > B){ //넘치는 경우
                dq.add(new int[] { a - (B - b), B , c});
            }
            else{ //안 넘치는 경우
                dq.add(new int[] {0, a + b, c});
            }
            
            
            if(a + c > C){ //넘치는 경우
                dq.add(new int[] { a - (C - c), b , C});
            }
            else{ //안 넘치는 경우
                dq.add(new int[] {0, b, a + c});
            }
            
            //B ->
            if(b + a > A){ //넘치는 경우
                dq.add(new int[] { A, b - (A - a) , c});
            }
            else{ //안 넘치는 경우
                dq.add(new int[] {b + a, 0, c});
            }
            
            
            if(b + c > C){ //넘치는 경우
                dq.add(new int[] { a, b - (C - c) , C});
            }
            else{ //안 넘치는 경우
                dq.add(new int[] {a, 0, b + c});
            }
            
            
            //C -> 
            if(c + a > A){ //넘치는 경우
                dq.add(new int[] { A, b , c - (A - a)});
            }
            else{ //안 넘치는 경우
                dq.add(new int[] {c + a, b, 0});
            }
            
            
            if(c + b > B){ //넘치는 경우
                dq.add(new int[] { a, B , c - (B - b)});
            }
            else{ //안 넘치는 경우
                dq.add(new int[] {a, c + b, 0});
            }
            
        }
    }
}
