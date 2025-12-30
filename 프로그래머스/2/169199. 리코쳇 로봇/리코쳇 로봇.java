//최단거리 == BFS

import java.util.*;
import java.io.*;

class Solution {
    
    static int height, width;
    static char[][] map;
    static boolean[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = -1;
    static int tx, ty;
    
    public int solution(String[] board) {
        
        
        height = board.length;
        width = board[0].length();
        map = new char[height][width];
        vis = new boolean[height][width];
        int sx = 0, sy = 0;
        
        for(int h = 0; h < height; h++){
            for(int w = 0; w < width; w++){
                map[h][w] = board[h].charAt(w);
                if(map[h][w] == 'R'){
                    sx = h;
                    sy = w;
                } //시작 좌표 저장
                
                if(map[h][w] == 'G'){
                    tx = h;
                    ty = w;
                } //시작 좌표 저장
            }
        } //보드 초기화
        
        bfs(sx, sy);
        
        return answer;
    }
    
    static void bfs(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy, 0});
        vis[sx][sy] = true;
        
        while(dq.size() != 0 ){
            int[] now = dq.poll();
            
            if(tx == now[0] && ty == now[1]){
                answer = now[2];
                return;
            }
            
                for(int dir = 0; dir < 4; dir++){
                    int nx = now[0];
                    int ny = now[1];
                    
                    
                    
                    while(true){
                        nx += dx[dir];
                        ny += dy[dir];
                        
                        if(!isPossible(nx, ny) || map[nx][ny] == 'D'){
                            nx -= dx[dir];
                            ny -= dy[dir];

                            if(vis[nx][ny]) break;

                            dq.add(new int[] {nx, ny, now[2] + 1});
                            vis[nx][ny] = true;
                            
                            break;
                        } //범위 밖 or 벽 만나면 종료
                        
                    }
                
                } // for문 끝
            
            }
            
         
    }
     static boolean isPossible(int x, int y){
        return x >= 0 && y >= 0 && x < height && y < width;
    }   
}
