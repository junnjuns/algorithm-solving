// 계란 (내구도, 무게)
// 계란끼리 치면 계란의 '무게'만큼 '내구도'가 감소한다.
// 왼쪽부터 오른쪽으로 차례대로 계란을 들고 깨지지 않은 계란들 중 아무거나 1개 친다.



import java.util.*;
import java.io.*;

public class Main
{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Egg[] elementArr;
    static int answer;
    static int cnt;
    
    static class Egg{
        int life;
        int weight;
        
        public Egg(int life, int weight){
            this.life = life;
            this.weight = weight;
        }
    }
    
    
    
	public static void main(String[] args) throws Exception {
	    
	    StringTokenizer st;
	    
	    n = Integer.parseInt(br.readLine());
	    
	    elementArr = new Egg[n];
	    
	    for(int idx = 0; idx < n; idx++){
	        st = new StringTokenizer(br.readLine());
	        
	        Egg egg = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	        elementArr[idx] = egg;
	    }
	    
	    func(0);
	    
	    bw.write(answer+"");
	    
	    bw.flush();
	    bw.close();
	    
    }
    
    static void func(int getEgg){
        
        if(getEgg == n){ // 마지막 계란이 왼쪽이면 끝.
            
            answer = Math.max(answer, cnt);
            return;
        }
        
        if(elementArr[getEgg].life <= 0 || cnt >= n - 1){
            func(getEgg + 1);
            return;
        }
        
        
        for(int idx = 0; idx < n; idx++){
            if(getEgg == idx || elementArr[idx].life <= 0) continue; //자기 자신 or 이미 깨져있다면 다음으로.
            
            boolean brokenA = false;
            boolean brokenB = false;
            
            elementArr[getEgg].life -= elementArr[idx].weight;
            elementArr[idx].life -= elementArr[getEgg].weight;
            if(elementArr[getEgg].life <= 0){
                cnt += 1;   
                brokenA = true;
            }
            if(elementArr[idx].life <= 0){
                cnt += 1;
                brokenB = true;
            } 
            
            func(getEgg + 1);
            
            if(brokenA) cnt -= 1;
            if(brokenB) cnt -= 1;
            elementArr[getEgg].life += elementArr[idx].weight;
            elementArr[idx].life += elementArr[getEgg].weight;
            
        }
    }
    
}