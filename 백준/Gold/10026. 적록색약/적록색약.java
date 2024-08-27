import java.util.*;
import java.io.*;





public class Main {
    
    static int boardSize;
    static char[][] board;
    static boolean[][] vis;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
        
    static BufferedWriter bw; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        boardSize = Integer.parseInt(br.readLine());
        
        board = new char[boardSize][boardSize];
        
        for(int row = 0; row < boardSize; row++){
            String str = br.readLine();
            for(int col = 0; col < boardSize; col++){
                board[row][col] = str.charAt(col);
            }
        }
        
        int answer = 0;
        vis = new boolean[boardSize][boardSize];
        for(int row = 0; row < boardSize; row++){
            for(int col = 0; col < boardSize; col++){
                if(vis[row][col] == false){
                    move(row, col);
                    answer++;
                }
            }
        }
        bw.write(answer+" ");
        
        for(int row = 0; row < boardSize; row++){
            for(int col = 0; col < boardSize; col++){
                if(board[row][col] == 'G'){
                    board[row][col] = 'R';
                }
            }
        }
       
        answer = 0;
        vis = new boolean[boardSize][boardSize];
        for(int row = 0; row < boardSize; row++){
            for(int col = 0; col < boardSize; col++){
                if(vis[row][col] == false){
                    move(row, col);
                    answer++;
                }
            }
        }
        bw.write(answer+" ");
        
        bw.flush();
        bw.close();
    }
    
    
    static void move(int sx, int sy){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {sx, sy});
        vis[sx][sy] = true;
        char curCh = board[sx][sy];
        
        while(dq.size() != 0){
            int[] now = dq.poll();
            
            
            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                
                if(nx >= 0 && ny >= 0 && nx < boardSize && ny < boardSize){
                    if(vis[nx][ny] == false && board[nx][ny] == curCh){
                        dq.add(new int[] {nx, ny});
                        vis[nx][ny] = true;
                    }
                }
                
            }
            
        }
    }
    
}
