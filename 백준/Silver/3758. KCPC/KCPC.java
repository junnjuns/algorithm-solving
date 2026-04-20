import java.util.*;
import java.io.*;


public class Main
{   
    
    static class Team{
        
        int id;
        int time;
        int totalScore;
        int submitCnt;
        int[] problem;
        
        public Team(int id, int time, int totalScore, int submitCnt, int[] problem){
            this.id = id;
            this.time = time;
            this.totalScore = totalScore;
            this.submitCnt = submitCnt;
            this.problem = problem;
        }
        
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        int test = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < test; t++){
            
            st = new StringTokenizer(br.readLine());
            
            int teamCnt = Integer.parseInt(st.nextToken()); // 팀의 개수
            int problemCnt = Integer.parseInt(st.nextToken()); // 문제의 개수
            int teamId = Integer.parseInt(st.nextToken()) - 1; // 나의 팀 ID
            int logCnt = Integer.parseInt(st.nextToken()); // 로그 개수
            
            Team[] teams = new Team[teamCnt];
            
            
            for(int i = 0; i < teamCnt; i++){
                teams[i] = new Team(i, 0, 0, 0, new int[problemCnt]);
            } // 팀 생성
            
            
            for(int i = 0 ; i < logCnt; i++){
                st = new StringTokenizer(br.readLine());
                
                int id = Integer.parseInt(st.nextToken()) - 1; // 팀 ID
                int problemNum = Integer.parseInt(st.nextToken()) - 1; // 문제 번호
                int score = Integer.parseInt(st.nextToken());
                
                teams[id].problem[problemNum] = Math.max(teams[id].problem[problemNum], score);
                teams[id].submitCnt += 1;
                teams[id].time = i;
                
            } // 로그 끝
            
            for(Team team : teams){
                for(int value : team.problem){
                    team.totalScore += value;
                }
            } // 각 팀마다 최종 점수 계산 끝
            
            Arrays.sort(teams, (a, b) -> {
                if(a.totalScore == b.totalScore){
                    
                    if(a.submitCnt == b.submitCnt){
                        return Integer.compare(a.time, b.time);
                    } // 최종 점수 같고, 제출 횟수 같으면 제출 시간 순으로 정렬
                    
                    return Integer.compare(a.submitCnt, b.submitCnt); // 최종 점수 같으면 제출 횟수 적은순으로 정렬
                }
                
                
                return Integer.compare(b.totalScore, a.totalScore); // 점수 내림차순 정렬
            });
            
            int answer = 0;
            
            for(int i = 0; i < teamCnt; i++){
                if(teams[i].id == teamId){
                    answer = i + 1;
                    break;
                }

            }
            bw.write(answer+"\n");
        } // 테스트 끝
        
        
		bw.flush();
		bw.close();
	}
	
	
}