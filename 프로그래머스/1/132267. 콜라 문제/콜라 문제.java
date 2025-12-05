// 빈 병 a개를 가져다 주면 b개의 콜라를 준다.
// n개의 빈병이 있다.
class Solution {
    
    public int solution(int a, int b, int n) {
    
        if(n < a){
            return 0;
        }
        
        int get  = (n / a) * b;
        int next = get + (n % a);
        
        
        return get + solution(a, b, next);
    }
    
}