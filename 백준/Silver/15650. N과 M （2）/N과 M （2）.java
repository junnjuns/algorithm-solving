import java.util.*;
import java.io.*;


// element 개수 받음
// element 중 몇개를 선택할 지 받음
// element 배열 생성
// 조합 메서드 실행
//      depth가 끝에 다다르면(모두 select 했으면) 종료
//      그렇지 않으면,
//      idx + 1: 현재 위치 이후의 요소들만을 대상으로 조합을 생성
//      => 중복 없이 고유한 조합을 생성할 수 있다.


public class Main {


    static int num; // 1부터 num까지 element
    static int cnt; // cnt개 select
    static int[] elementArr; //element 저장 배열
    static int[] selectArr; //생성한 조합 저장 배열
    
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    
    	st = new StringTokenizer(br.readLine());
    
    	num = Integer.parseInt(st.nextToken());
    	cnt = Integer.parseInt(st.nextToken());
    
    	elementArr = new int[num];
    	selectArr = new int[cnt];
    
    	for (int idx = 0; idx < num; idx++) {
    		elementArr[idx] = idx + 1;
    	} // elementArr 생성
    
    	combination(0, 0); // 조합 생성 메서드
    
    	bw.flush();
    	bw.close();
    }

    static void combination(int depth, int start) throws Exception {
    	if (depth == cnt) { // 종료조건. cnt개 모두 골랐을 때 종료
    		for (int value : selectArr) {
    			bw.write(value + " ");
    		}
    		bw.newLine();
    		return;
    	}
    
    	for (int idx = start; idx < num; idx++) {
    		selectArr[depth] = elementArr[idx];
    		combination(depth + 1, idx + 1); // idx + 1: 현재 위치 이후의 요소들만을 대상으로 조합을 생성
    	}
    
    }
}
