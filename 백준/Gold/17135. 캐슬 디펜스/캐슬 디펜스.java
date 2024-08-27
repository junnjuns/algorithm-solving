import java.util.*;
import java.io.*;

/*

캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다. 게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다. 
격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다.
격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.

성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 
궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다. 
각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다.
궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 
같은 적이 여러 궁수에게 공격당할 수 있다. 
공격받은 적은 게임에서 제외된다. 궁수의 공격이 끝나면, 적이 이동한다. 
적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 
모든 적이 격자판에서 제외되면 게임이 끝난다. 

게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다. 
따라서, 이 게임은 궁수의 위치가 중요하다. 
격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.

격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.

*/

//궁수 3명 배치
//모든 궁수는 동시에 공격
//D 이하인 적 중에 가장 가까운 적 공격
    //만약 가까운 적이 여럿이면 가장 왼쪽에 있는 적 공격
    //가장 가까운 적 게임에서 제외
//공격이 끝나면 적 아래로 한칸 이동
    //성이 있는 칸으로 이동하면 게임에서 제외
//모든적 게임에서 제외되면 게임 끝



public class Main {
    
    static int height;
    static int width;
    static int power; //사거리
    static int[][] board;
    static int enemy;
    static int[] bowPoint = new int[3];
    static ArrayList<int[]>[] list;
    static boolean[][] vis;
    static int[] dx = {0,-1,0};
    static int[] dy = {-1,0,1};
    static int[][] copy;
    static int copyEnemy;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        power = Integer.parseInt(st.nextToken());
        
        board = new int[height][width];
        
        for(int row = 0; row < height; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < width; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
                if(board[row][col] == 1){
                    enemy++; //적 추가
                }
            }
        } //board 입력 끝
        
        
            
        combination(0, 0); //궁수의 위치를 정하는 조합을 뽑는다.
            
        bw.write(answer+"");
        
        bw.flush();
        bw.close();
    }
    
    static void combination(int element, int select){
        if(select == 3){ //width개 중 3개를 골랐다면
            int kill = 0; // 적 삭제 count
            
            copy = new int[height][width];
            
            for (int row = 0; row < height; row++) { //copy에 board 복사
                for(int col = 0; col < width; col++){
                    copy[row][col] = board[row][col];
                }
            }
            
            copyEnemy = enemy; // 원본 적의 수 복사
            list = new ArrayList[3]; //각 궁수마다의 공격 범위 내 적의 위치를 담고있는 리스트
            
            //게임 시작
            while(copyEnemy > 0){ 
                // for(int i : bowPoint){
                //     System.out.print(i+" ");
                // }
                // System.out.println("===================");
                // for(int[] i : copy){
                //     for(int j : i){
                //         System.out.print(j+" ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();
                //가장 먼저 현재 궁수가 공격할 수 있는 적이 있는지 파악.
                //있다면 정렬 후 첫번째 삭제
                for(int idx = 0; idx < 3; idx++){
                    list[idx] = new ArrayList<int[]>(); // 0, 1, 2 번째 궁수의 list 생성
                    
                    int nowCol = bowPoint[idx]; // col 좌표
                    
                    vis = new boolean[height][width]; //각 궁수의 적을 찾을 때 마다 방문 배열 초기화
                    findEnemy(height - 1, nowCol, idx); //적의 위치를 찾는 BFS 메서드
                }
                
                for(int idx = 0; idx < 3; idx++) {
                    //만약 공격할 수 있는 범위 내 적이 있다면 적 삭제
                    if(list[idx].size() != 0){
                        
                        int x = list[idx].get(0)[0];
                        int y = list[idx].get(0)[1];
                        
                        if(copy[x][y] == 1){ //만약 삭제하려는 곳에 적이 있다면
                            kill++; // kill 추가
                            copyEnemy--; //적 감소
                            copy[x][y] = 0;
                        }
                        
                    }
                    
                } //BFS를 통해 궁수 마다 적의 위치를 담고있는 리스트 생성하고 적을 삭제함 (공격 종료)
                
                
                for(int col = 0; col < width; col++){ //가장 밑 1은 다음 게임이 되기 전 밖으로 나가기 때문에 copmyEnemy 감소 
                    if(copy[height - 1][col] == 1){
                        copyEnemy -= 1;
                    }
                }
                
                
                //격자판 한칸식 내리기
                for (int row = height - 2; row >= 0; row--) {
                    for (int col = 0; col < width; col++) {
                        copy[row + 1][col] = copy[row][col];
                    }
                }
                
                for (int col = 0; col < width; col++) {
                    copy[0][col] = 0; // 맨 윗줄 초기화
                }
                // for(int[] i : copy){
                //     for(int j : i){
                //         System.out.print(j+" ");
                //     }
                //     System.out.println();
                // }
                // System.out.println("kill: "+kill);
                // System.out.println("=================");
            } //게임 종료
            
            answer = Math.max(answer, kill);
            return;
        }
        
        if(element == width){ //모든 곳 다 확인했으면
            return;
        }
        
        bowPoint[select] = element;
        combination(element + 1, select + 1);
        
        combination(element + 1, select);
        
    }
    
    static void findEnemy(int cx, int cy, int index){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {cx, cy, 1});
        vis[cx][cy] = true;
        
        if(copy[cx][cy] == 1){ //적이 있다면
            list[index].add(new int[] {cx, cy});
            return;
        }
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
                for(int dir = 0; dir < 3; dir++){
                    int nx = now[0] + dx[dir];
                    int ny = now[1] + dy[dir];
                    
                    if(nx >= 0 && ny >= 0 && nx < height && ny < width){
                        if(vis[nx][ny] == false && now[2] < power){
                            dq.add(new int[] {nx, ny, now[2] + 1});
                            vis[nx][ny] = true;
                            
                            if(copy[nx][ny] == 1){ //만약 적이면 궁수 리스트에 위치 추가
                                list[index].add(new int[] {nx, ny});
                                return;
                            }
                        }
                        
                    }
                }
                
            
        }
        
    }
    
    
}
