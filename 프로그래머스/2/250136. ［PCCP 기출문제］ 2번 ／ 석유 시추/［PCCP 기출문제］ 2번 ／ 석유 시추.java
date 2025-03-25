import java.util.*;

class Solution {
    
    static int row, col; 
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Map<Integer, Integer> map = new HashMap<>();
    static int[][] board;
    
    
    public int solution(int[][] land) {
        
        row = land.length;
        col = land[0].length;
        
        int answer = 0;
              
        board = new int[row][col];
        int cnt = 1;
        for(int w = 0; w < col; w++){
            
            for(int h = 0; h < row; h++){
                if(land[h][w] != 0 && board[h][w] == 0){
                    map.put(cnt, bfs(h, w, land, cnt));
                    cnt += 1;
                }
            }
            
            
        }
        
        Map<Integer, Set<Integer>> ms = new HashMap<>();
        
        
        for(int w = 0; w < col; w++){
            
            Set<Integer> set = new HashSet<>();
            
            for(int h = 0; h < row; h++){
                if(board[h][w] != 0){
                    set.add(board[h][w]);    
                }
                
            }
            ms.put(w, set);
        } 
        
        for(Map.Entry<Integer, Set<Integer>> m : ms.entrySet()){
            
            int result = 0;
            for(Integer i : m.getValue()){
                result += map.get(i);
            }
            answer = Math.max(answer, result);
        }
        
        
        return answer;
    }
    
    static int bfs(int sx, int sy, int[][] land, int cnt){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        board[sx][sy] = cnt; //그룹 아이디
        
        int value = 1;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            for(int dir = 0 ; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(nx >= 0 && ny >= 0 && nx < row && ny < col){
                    if(board[nx][ny] == 0 && land[nx][ny] == 1){
                        dq.add(new int[] {nx, ny});
                        board[nx][ny] = cnt;
                        value += 1;
                        
                    }
                    
                }
            }
            
        }
        
        return value;
    }
    
    
}