class Solution {
    
    static int[][] board;
    static boolean[] used;
    static boolean[] up;
    static boolean[] down;
    static int cnt;
    static int size;
    public int solution(int n) {
        
        size = n;
        board = new int[n][n];
        used = new boolean[n];
        up = new boolean[2 * n - 1]; //아래서 위
        down = new boolean[2 * n - 1]; //위에서 아래
        
        
        for(int w = 0; w < n; w++){
            used[w] = true;
            down[0 - w + n - 1] = true;
            up[w] = true;
            
            //1번째부터 밑으로 시작
            run(1);
            
            used[w] = false;
            down[0 - w + n - 1] = false;
            up[w] = false;
        }
        
        return cnt;
    }
    
    static void run(int height){
        if(height == size){
            cnt += 1;
            return;
        }
        
        for(int w = 0; w < size; w++){
            if(!used[w] && !down[height - w + size - 1] && !up[height + w]){
                used[w] = true;
                down[height - w + size - 1] = true;
                up[height + w] = true;
                
                run(height + 1);

                used[w] = false;
                down[height - w + size - 1] = false;
                up[height + w] = false;
            }
        }

        
    }
    
}