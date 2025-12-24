import java.io.*;
import java.util.*;

class Solution {
    
    static int SIZE = 105;
    static int[][] board;
    static int[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        //초기 board 초기화
        board = new int[SIZE][SIZE];
        vis = new int[SIZE][SIZE];
        
        // 좌표를 셀로 초기화
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for(int[] point : rectangle){
            
            int x1 = point[0] * 2;
            int y1 = point[1] * 2;
            int x2 = point[2] * 2;
            int y2 = point[3] * 2;
            
            for(int h = x1; h <= x2; h++){
                for(int w = y1; w <= y2; w++){
                    if(board[h][w] == 0){
                        board[h][w] = 1; // 테두리 초기화
                    }
                }
            }
        } // 사각형 초기화
        
        
        for(int[] point : rectangle){
            
            int x1 = point[0] * 2;
            int y1 = point[1] * 2;
            int x2 = point[2] * 2;
            int y2 = point[3] * 2;
            
            for(int h = x1 + 1; h < x2; h++){
                for(int w = y1 + 1; w < y2; w++){
                    if(board[h][w] == 1){
                        board[h][w] = 0; // 내부 지우기
                    }
                }
            }
        }
        
        bfs(characterX, characterY, itemX, itemY);
        
        answer = vis[itemX][itemY] / 2;
        
        return answer;
    }
    
    static void bfs(int sx, int sy, int itemX, int itemY){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = 1;
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            if(now[0] == itemX && now[1] == itemY){
                return;
            }
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(check(nx, ny) && board[nx][ny] == 1 && vis[nx][ny] == 0){
                    dq.add(new int[] {nx, ny});
                    vis[nx][ny] = vis[now[0]][now[1]] + 1;
                }
            }
        }
        
    }
    
    static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE;
    }
}