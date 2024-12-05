import java.util.*;
import java.io.*;

public class Main {
    
    
    static int direction;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<int[]> pos;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        
        String order = br.readLine();
        
        direction = 2; // 남쪽방향
        pos = new ArrayList<>();
        pos.add(new int[] {0, 0});
        
        
        int minX = 0;
        int minY = 0;
        
        int maxX = 0;
        int maxY = 0;
        
        for(int idx = 0 ; idx < order.length(); idx++){
            char ch = order.charAt(idx);
            
            if(ch == 'F'){
                int[] now = pos.get((pos.size() - 1));
                
                int nx = now[0] + dx[direction];
                int ny = now[1] + dy[direction];
                
                pos.add(new int[] {nx, ny});
                
                minX = Math.min(minX, nx);
                minY = Math.min(minY, ny);
                
                maxX = Math.max(maxX, nx);
                maxY = Math.max(maxY, ny);
                
            }
            else if(ch == 'L'){
                direction = (direction - 1) < 0 ? direction = 3 : (direction - 1);
                
            }
            else if(ch == 'R'){
                direction = (direction + 1) > 3 ? direction = 0 : (direction + 1);
            }
            
        }
        
        int row = (maxX - minX) + 1;
        int col = (maxY - minY) + 1;
        
        char[][] board = new char[row][col];
        
        for(int[] arr : pos){
            int nx = arr[0] - minX;
            int ny = arr[1] - minY;
            
            board[nx][ny] = '.';
        }
        
        for(int h = 0; h < row; h++){
            for(int w = 0; w < col; w++){
                if(board[h][w] != '.'){
                    board[h][w] = '#';
                }
            }
        }
        
        
        for(char[] arr : board){
            for(char ch : arr){
                bw.write(ch+"");
            }
            bw.write("\n");
        }
        
        
        bw.flush();
        bw.close();
    }
}
