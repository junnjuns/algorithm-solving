import java.util.*;
import java.io.*;



public class Main {
    //cost 기준으로 정렬
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }

    }

    static int size;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cnt = 1;
        while (true){
            size = Integer.parseInt(br.readLine());
            if(size == 0){
                break;
            }

            board = new int[size][size];
            dist = new int[size][size];

            //최댓값으로 초기화
            for(int idx = 0; idx < size; idx++){
                Arrays.fill(dist[idx], Integer.MAX_VALUE);
            }

            //board 초기화
            for(int row = 0; row < size; row++){
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < size; col++){
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            Dijkstra(0, 0);

            bw.write("Problem "+cnt+": "+dist[size-1][size-1]+"\n");
            cnt++;
        } //종료

        bw.flush();
        bw.close();
    }

    static void Dijkstra(int startX, int startY){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, board[startX][startY]));
        dist[startX][startY] = board[startX][startY];

        while (pq.size() != 0){
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            if(dist[x][y] < cost){
                continue;
            }

            for(int dir = 0 ; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < size && ny < size){
                    if(dist[nx][ny] > board[nx][ny] + cost){
                        dist[nx][ny] = board[nx][ny] + cost;
                        pq.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }

        }
    }
}

