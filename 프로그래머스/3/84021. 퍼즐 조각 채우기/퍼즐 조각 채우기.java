// table에서 bfs 돌리고, 블록 리스트 만들기
// game_board에서 bfs 돌리고, 구멍 리스트 만들기
// 리스트 끼리 비교하여 같은 사이즈 중에서, 도형 회전하며 적합한 것 찾기
    // 도형을 0,0 기준으로 만들기 -> x,y 값에서 가장 작은 값으로 모두 빼면 0,0 기준
    // 도형 0, 90, 180, 270 으로 회전시키면서 적합한 도형 찾기

import java.util.*;
import java.io.*;

class Solution {
    
    static int size;
    static ArrayList<ArrayList<int[]>> blockList;
    static ArrayList<ArrayList<int[]>> holeList;
    static boolean[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        size = game_board.length;
        vis = new boolean[size][size];
        blockList = new ArrayList<>();
        holeList = new ArrayList<>();
        
        for(int h = 0; h < size; h++){
            for(int w = 0; w < size; w++){
                if(game_board[h][w] == 0 && !vis[h][w]){
                    
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[] {h, w});
                    bfs(h, w, game_board[h][w], list, game_board);
                }   
                
            }
        } // game_board 구멍 리스트 만들기
        
        vis = new boolean[size][size];
        
        for(int h = 0; h < size; h++){
            for(int w = 0; w < size; w++){
                if(table[h][w] == 1 && !vis[h][w]){
                    ArrayList<int[]> list = new ArrayList<>();
                    list.add(new int[] {h, w});
                    bfs(h, w, table[h][w], list, table);
                    
                }   
                
            }
        } // table 도형 리스트 만들기
        
        
        //구멍 0,0 기준으로 설정하기
        for(int i = 0; i < holeList.size(); i++){
            ArrayList<int[]> list = holeList.get(i); //구멍 한 개 꺼내기
            
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            
            for(int j = 0; j < list.size(); j++){
                int[] point = list.get(j);
                
                minX = Math.min(minX, point[0]);
                minY = Math.min(minY, point[1]);
                
            }
            
            for(int j = 0; j < list.size(); j++){
                int[] point = list.get(j);
                
                point[0] -= minX;
                point[1] -= minY;
            }
            
            sortShape(list);
        }
        
        //블럭 0,0 기준으로 설정하기
        for(int i = 0; i < blockList.size(); i++){
            ArrayList<int[]> list = blockList.get(i); //구멍 한 개 꺼내기
            
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            
            for(int j = 0; j < list.size(); j++){
                int[] point = list.get(j);
                
                minX = Math.min(minX, point[0]);
                minY = Math.min(minY, point[1]);
                
            }
            
            for(int j = 0; j < list.size(); j++){
                int[] point = list.get(j);
                
                point[0] -= minX;
                point[1] -= minY;
            }
            sortShape(list);
        }
        
        
        //도형 기준으로 순차적 확인하기
        for(int i = 0; i < blockList.size(); i++){
            ArrayList<int[]> block = blockList.get(i);
            int blockSize = block.size();
            boolean possible = false;
            
            for(int j = 0; j < holeList.size(); j++){ //구멍 리스트 확인
                ArrayList<int[]> hole = holeList.get(j);
                
                if(hole == null) continue; //이미 사용된 구멍 제외
                if(holeList.get(j).size() != blockSize) continue; //사이즈가 다른 구멍 제외
                
                // 회전하면서 완전 일치하는지 확인
                if (canFit(block, hole)){
                    answer += block.size();
                    holeList.set(j, null);
                    break; // 한 블록은 한 구멍만 채우고 끝
                }
            }
            
            
        }
        
        return answer;
    }
    
    static void sortShape(ArrayList<int[]> shape){
        Collections.sort(shape, new Comparator<int[]>() {
            
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
    }

    
    static ArrayList<int[]> rotate90(ArrayList<int[]> shape){
        
        ArrayList<int[]> rotated = new ArrayList<>();
        
        for (int[] p : shape) {
            int r = p[0];
            int c = p[1];
            rotated.add(new int[]{c, -r});
        }
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for (int[] p : rotated) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        // (0,0) 기준으로 붙이기 (위치 정보 제거)
        for (int[] p : rotated) {
            p[0] -= minX;
            p[1] -= minY;
        }
        
        sortShape(rotated);
        
        return rotated;
    }
    
    // 정렬된 좌표를 하나씩 직접 비교
    static boolean sameShape(ArrayList<int[]> a, ArrayList<int[]> b) {
        
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0]){
                 return false;   
            }
            if (a.get(i)[1] != b.get(i)[1]){
                return false;   
            }
        }
        return true;
    }
    
    static boolean canFit(ArrayList<int[]> block, ArrayList<int[]> hole){
        
        ArrayList<int[]> copyBlock = new ArrayList<>();
        for (int[] p : block){
            copyBlock.add(new int[] {p[0], p[1]});   
        } // 주소값가져서 수정하면 위험하기에 복사본 생성
        
        
        for (int i = 0; i < 4; i++) {
            if (sameShape(copyBlock, hole)){
                return true;   
            }
            copyBlock = rotate90(copyBlock); // 다음 회전 상태
        }
        return false;
        
    }
    
    
    static void bfs(int sx, int sy, int type, ArrayList<int[]> list, int[][] board){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = true;
        
        
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(type == 0){
                    if(check(nx, ny) && board[nx][ny] == 0 && !vis[nx][ny]){
                        list.add(new int[] {nx, ny});
                        dq.add(new int[] {nx, ny});
                        vis[nx][ny] = true;
                    }    
                }
                else{
                    if(check(nx, ny) && board[nx][ny] == 1 && !vis[nx][ny]){
                        list.add(new int[] {nx, ny});
                        dq.add(new int[] {nx, ny});
                        vis[nx][ny] = true;
                    }
                }
                
            }
        } // 반복문 종료 == 탐색 끝
        
        if(type == 0){
            holeList.add(list);
        }
        else{
            blockList.add(list);
        }
        
    }
    
    static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < size && y < size;
    }
}