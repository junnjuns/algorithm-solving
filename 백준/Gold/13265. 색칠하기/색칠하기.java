import java.util.*;
import java.io.*;

//방문한 곳이 0 이거나 자기와 반대되는 색상이어야 한다.
    //0일 때 음수로 바꾸고 통과
    //자기랑 반대일 때 통과
    //자기랑 같을 때 종료

public class Main
{   
    
    static int circleCnt; //1 ~ 1000
    static int lineCnt; //1 ~ 100,000
    static List<Integer>[] list;
    static int[] vis;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    int test = Integer.parseInt(br.readLine());
	    
	    
	    //테스트 케이스 시작
	    for(int t = 0; t < test; t++){
	        st = new StringTokenizer(br.readLine());
	        
	        circleCnt = Integer.parseInt(st.nextToken());
	        lineCnt = Integer.parseInt(st.nextToken());
	        
	        list = new ArrayList[circleCnt + 1];
	        
	        for(int idx = 0; idx < circleCnt + 1; idx++){
	            list[idx] = new ArrayList<>();
	        }
	        
	        //직선의 대한 정보 입력
	        for(int idx = 0; idx < lineCnt; idx++){
	            st = new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            
	            list[x].add(y);
	            list[y].add(x);
	        }
	        
	        boolean answer = true;
	        //시뮬 시작
	        for(int idx = 1; idx < circleCnt + 1; idx++){
	            
	            //1번 원부터  시작
	            boolean result = bfs(idx);
	            
	            if(!result){
	                answer = false;
	                break;
	            }
	            
	        }//원들 모두 확인
	        
	        if(answer){
	            bw.write("possible\n");
	        }
	        else{
	            bw.write("impossible\n");
	        }
	        
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	static boolean bfs(int start){
	    ArrayDeque<Integer> dq = new ArrayDeque<>();
	    dq.add(start);
	    
	    vis = new int[circleCnt + 1];
	    vis[start] = 1;
	    
	    while(dq.size() != 0){
	        int now = dq.poll();
	        
	        for(int idx = 0; idx < list[now].size(); idx++){
	            int next = list[now].get(idx); //이어진 다음 원
	            
	            if(vis[next] == 0){
	                dq.add(next);
	                vis[next] = vis[now] == 1 ? -1 : 1;
	            }
	            else if(vis[next] == vis[now]){
	                return false;
	            }
	        }
	    } //반복문 끝
	    
	    return true;
	}
}
