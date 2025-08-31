// 후보 N 명
// 마을 주민 M 명


import java.util.*;
import java.io.*;

public class Main
{   
    static class Candidate implements Comparable<Candidate>{
        int number;
        int vote;
        
        public Candidate(int number, int vote){
            this.number = number;
            this.vote = vote;
        }
        
        public int compareTo(Candidate o){
            return o.vote - this.vote;
        }
    }
    
    
    static int n;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
        n = Integer.parseInt(br.readLine()); // 후보 n 명
        
        PriorityQueue<Candidate> pq = new PriorityQueue<>();
        
        int myVote = Integer.parseInt(br.readLine());
        
        for(int idx = 1; idx < n; idx++){
            pq.add(new Candidate(idx, Integer.parseInt(br.readLine())));
        }
        
        int cnt = 0;
        
        while(!pq.isEmpty()){
            Candidate cd = pq.poll();
            
            if(myVote > cd.vote){
                break;
            }
            
            myVote += 1;
            cd.vote -= 1;
            cnt += 1;
            
            pq.add(cd);
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        	    
	}
}
