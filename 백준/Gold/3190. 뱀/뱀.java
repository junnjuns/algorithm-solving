import java.io.*;
import java.util.*;


public class Main
{
    static int n;
    static int[][] board;
    static ArrayDeque<String[]> info;
    static int[] dx = {0,1,0,-1}; //0,1,2,3  == 우,하,좌,상
    static int[] dy = {1,0,-1,0};
    static int answer;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		int appleCnt = Integer.parseInt(br.readLine()); //사과 갯수
		
		for(int idx=0; idx<appleCnt; idx++){    //사과의 위치 입력
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken())-1;
		    int y = Integer.parseInt(st.nextToken())-1;
		    board[x][y] = 1;
		}
		
		int snakeCnt = Integer.parseInt(br.readLine()); //뱀 방향 전환 횟수
		
		info = new ArrayDeque<>();   //뱀 방향 전환 정보 담는 큐
		for(int idx=0; idx<snakeCnt; idx++){
		    st = new StringTokenizer(br.readLine());
		    info.add(new String[]{st.nextToken(), st.nextToken()}); //몇초 뒤, 어느 방향으로 전환하는지
		}
		
		start(0,0);
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	static void start(int col, int row){
        ArrayDeque<int[]> snake = new ArrayDeque<>(); //뱀의 위치 좌표 담는 큐
        snake.add(new int[] {col, row});
        board[col][row] = -1;
        int time = 0;
        int way = 0; //오른쪽 방향
        
        while(true){
            time++; //현재 시간
            int[] now = snake.peek();
            int x = now[0] + dx[way];
            int y = now[1] + dy[way];
            
            if(x<0 || y<0 || x>=n || y>=n || board[x][y] == -1){ //보드 밖으로 넘어가면 종료
                answer = time;
                break;
            }
            
            else{
                if(board[x][y] == 0){ //사과 없을 떄 큐 삭제 후 추가
                    snake.addFirst(new int[] {x,y});
                    board[x][y] = -1;
                    int[] tail = snake.pollLast();
                    board[tail[0]][tail[1]] = 0;
                    
                }
                else if(board[x][y] == 1){
                    snake.addFirst(new int[] {x,y});
                    board[x][y] = -1;
                }
            }
            
        
            if (!info.isEmpty() && Integer.parseInt(info.peek()[0]) == time) { // 방향 바꿔야 할 때
                String[] snakeInfo = info.poll();
                String dir = snakeInfo[1];
                
                if(dir.equals("D")){    //오른쪽 방향
                    way += 1;
                    if(way > 3){
                        way = 0;
                    }
                }
                else{   //왼쪽 방향
                    way -= 1;
                    if(way < 0){
                        way = 3;
                    }
                }
            }
        }//while 문 끝
        
    }
}
	
