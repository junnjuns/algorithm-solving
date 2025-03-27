
class Solution {
    
    static int height;
    static int width;
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        height = park.length;
        width = park[0].length;
        
        
        for(int idx = 0; idx < mats.length; idx++){
            int now = mats[idx];
            
            for(int h = 0; h < height; h++){
                for(int w = 0; w < width; w++){
                    
                    if(park[h][w].equals("-1")){
                        if(h <= height - now && w <= width - now){
                            boolean check = true;
                            
                            for(int i = h; i < h + now; i++){
                                for(int j = w; j < w + now; j++){
                                    
                                    if(!park[i][j].equals("-1")){
                                        check = false;
                                        break;
                                    }
                                }
                            }//for문 끝
                            if(check){
                                answer = Math.max(answer, now);
                            }
                        }
                    }
                }
            }             
        }
   
        
        
        return answer;
    }
}