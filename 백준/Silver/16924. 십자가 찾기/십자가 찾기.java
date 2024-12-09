import java.util.*;
import java.io.*;

public class Main {   
    static int row;
    static int col;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {1, -1, 0, 0}; // 하, 상, 우, 좌
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        
        board = new char[row][col];
        vis = new boolean[row][col];
        
        for(int h = 0; h < row; h++){
            String str = br.readLine();
            for(int w = 0; w < col; w++){
                board[h][w] = str.charAt(w);
            }
        }
        
        // 최대 길이부터 확인하기 위해 그리드를 중간에서부터 확장하는 방식으로 순회할 필요는 없지만,
        // 모든 중심점을 순회하며 가능한 최대 길이를 찾습니다.
        for(int h = 0; h < row; h++){
            for(int w = 0; w < col; w++){
                if(board[h][w] == '*'){
                    int maxCnt = getMaxCrossLength(h, w);
                    if(maxCnt > 0){
                        list.add(new int[] {h + 1, w + 1, maxCnt});
                        markCross(h, w, maxCnt);
                    }
                }
            }
        }
        
        // 모든 '*'가 커버되었는지 확인
        boolean isPossible = true;
        outer:
        for(int h = 0; h < row; h++){
            for(int w = 0; w < col; w++){
                if(board[h][w] == '*' && !vis[h][w]){
                    isPossible = false;
                    break outer;
                }
            }
        }
        
        if(isPossible){
            bw.write(list.size() + "\n");
            for(int[] cross : list){
                bw.write(cross[0] + " " + cross[1] + " " + cross[2] + "\n");
            }
        }
        else{
            bw.write("-1");
        }
        
        bw.flush();
        bw.close();
    }
    
    // 주어진 위치에서 가능한 최대 십자가 길이를 반환합니다.
    static int getMaxCrossLength(int x, int y){
        int cnt = 0;
        while(true){
            boolean possible = true;
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir] * (cnt + 1);
                int ny = y + dy[dir] * (cnt + 1);
                if(!isValid(nx, ny)){
                    possible = false;
                    break;
                }
            }
            if(possible){
                cnt++;
            }
            else{
                break;
            }
        }
        return cnt;
    }
    
    // 주어진 위치와 길이로 십자가를 마킹합니다.
    static void markCross(int x, int y, int cnt){
        vis[x][y] = true; // 중심점 마킹
        for(int dir = 0; dir < 4; dir++){
            for(int k = 1; k <= cnt; k++){
                int nx = x + dx[dir] * k;
                int ny = y + dy[dir] * k;
                vis[nx][ny] = true;
            }
        }
    }
    
    // 주어진 위치가 그리드 내에 있고 '*'인지 확인합니다.
    static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < row && y < col && board[x][y] == '*';
    }
}
