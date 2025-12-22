import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] vis;
    static int h, w;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        h = maps.length;
        w = maps[0].length;
        
        vis = new int[h][w];
        
        bfs(0, 0, maps);
        
        return vis[h - 1][w - 1] == 0 ? -1 : vis[h - 1][w - 1];
    }
    
    static void bfs(int sx, int sy, int[][] maps){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = 1;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            if(now[0] == h - 1 && now[1] == w - 1){
                return;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if(check(nx, ny) && maps[nx][ny] == 1 && vis[nx][ny] == 0){
                    dq.add(new int[] {nx, ny});
                    vis[nx][ny] = vis[now[0]][now[1]] + 1;
                }
            }
        }
        
    }
    
    static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < h && y < w;
    }
    
}