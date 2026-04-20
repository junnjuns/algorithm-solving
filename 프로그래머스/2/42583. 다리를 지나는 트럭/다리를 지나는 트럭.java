// 대기 큐
// 다리 큐
// 전체 시간

import java.util.*;


class Solution {
    
    static int answer;
    static int time;
    static int total;
    static int cnt;
        
    static ArrayDeque<Integer> waitDq = new ArrayDeque<>();
    static ArrayDeque<int[]> runDq = new ArrayDeque<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        for(int i = 0; i < truck_weights.length; i++){
            waitDq.add(truck_weights[i]);
        } // 대기 큐
        
        
        while(waitDq.size() != 0 || runDq.size() != 0){
            time += 1; //현재 시간
            
            //만약 다리 큐에 버스가 있다면
            if(runDq.size() != 0){
                int[] runNow = runDq.peek();
                
                // 현재 시간 - 들어온 시간 == bridge_length 일 때 다리 큐 poll
                if(time - runNow[1] == bridge_length){
                    runNow = runDq.poll(); //다리 큐 제거
                    total -= runNow[0]; // 다리 무게 감소
                    cnt -= 1; //다리 트럭 개수 감소
                    //System.out.println(time +" "+ runNow[1]);
                }
            }
            
            
            //만약 대기큐에 버스가 있다면 다리에 들어갈 수 있는지 확인하기
            if(waitDq.size() != 0){
                
                // cnt가 bridge_length 미만인지 확인
                // 현재 total + 대기 버스 무게가 weight 이하인지 확인
                if(cnt < bridge_length && total + waitDq.peek() <= weight){
                    int next = waitDq.poll();// 대기 큐에서 버스 추출하고 다리 큐에 추가
                    total += next; // 다리 무게 추가
                    runDq.add(new int[] {next, time}); //다리 큐 추가
                    cnt += 1; //다리 트럭 개수 추가
                }
            }
            
        } //대기 큐, 다리 큐 모두 비어있으면 종료
        
        
        
        return time;
    }
}