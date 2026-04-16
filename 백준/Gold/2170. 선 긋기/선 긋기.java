import java.util.*;
import java.io.*;


public class Main
{   
    static class Node{
        int start;
        int end;
        
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    static int n;
    static int answer;
    static Node[] arr;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
				
		arr = new Node[n];
		
		for(int i = 0; i < n; i++){
		    st = new StringTokenizer(br.readLine());
		    int start = Integer.parseInt(st.nextToken());
		    int end = Integer.parseInt(st.nextToken());
		    
		    arr[i] = new Node(start, end);
		} // 초기화

		
        Arrays.sort(arr, (a, b) -> {
            if(a.start != b.start){
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        });
        
        
        for(int idx = 0; idx < n; idx++){
            
            int start = arr[idx].start;
            int end = arr[idx].end;
            
            int nextIdx = idx + 1; //다음 인덱스
            
            while(nextIdx < n){
                
                if(end >= arr[nextIdx].start && end <= arr[nextIdx].end){ // 겹치면 end 초기화
                    end = arr[nextIdx].end;
                }
                
                else if(end < arr[nextIdx].start){
                    nextIdx -= 1;
                    break;
                }
                nextIdx += 1;
            } // while문 종료
            
            idx = nextIdx;
            answer += end - start;
            
            
        } //for문 종료
		
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}
