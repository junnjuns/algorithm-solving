// 빈 병 a개를 가져다 주면 b개의 콜라를 준다.
// n개의 빈병이 있다.
class Solution {
    static int answer;
    
    public int solution(int a, int b, int n) {
        
        
        func(a, b, n);
        
        return answer;
    }
    
    static void func(int a, int b, int n){
        if(n < a){
            return;
        }
        
        answer += (n / a) * b;
        n = (n / a) * b + (n % a);
        func(a, b, n);
        
    }
}