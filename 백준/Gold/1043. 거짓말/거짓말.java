import java.util.*;
import java.io.*;

public class Main
{   
    
    static int personCnt;
    static int partyCnt;
    static int trueCnt;
    static int[] truePerson;
    static int joinCnt;
    static int[] joinPerson;
    static int[] parents;
    static int parent;
    
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st;
	
	st = new StringTokenizer(br.readLine());
	personCnt = Integer.parseInt(st.nextToken());
	partyCnt = Integer.parseInt(st.nextToken());
	
	st = new StringTokenizer(br.readLine());
	trueCnt = Integer.parseInt(st.nextToken()); // 진실 아는 사람 수
	
	
	if(trueCnt == 0){
	    
	    bw.write(partyCnt+"");
	    bw.flush();
	    bw.close();
	    return;
	}
	
	parents = new int[personCnt + 1];
	for(int idx = 0; idx < personCnt + 1; idx++){
	    parents[idx] = idx;
	}//초기에는 자기 자신이 부모
	
	
	//진실 아는 사람 배열
	truePerson = new int[trueCnt];
	
	for(int idx = 0; idx < trueCnt; idx++){
	    truePerson[idx] = Integer.parseInt(st.nextToken());
	}//진실 배열 초기화
	
	for(int idx = 0; idx < trueCnt - 1; idx++){
        union(truePerson[idx], truePerson[idx + 1]);	    
	} //진실 아는 사람들끼리 유니온 연산 실행
	
	
	//참가자들 배열을 가진 리스트 생성
	ArrayList<int[]> joinList = new ArrayList<>();
	
	//파티 시작
	for(int idx = 0; idx < partyCnt; idx++){
	    st = new StringTokenizer(br.readLine());
	    joinCnt = Integer.parseInt(st.nextToken()); //파티 참가자 수
	    
	    joinPerson = new int[joinCnt]; //참가자 배열
	    
	    for(int j = 0; j < joinCnt; j++){
	        joinPerson[j] = Integer.parseInt(st.nextToken());
	    }//참가자 배열 초기화
	    
	    for(int j = 0; j < joinCnt - 1; j++){
	        union(joinPerson[j], joinPerson[j + 1]);
	    }//참가자끼리 유니온 연산 실행
	    
	    joinList.add(joinPerson);
	    
	}
	
	//진실 아는 사람 대표
	parent = find(truePerson[0]);
	
	int answer = 0;
	for(int idx = 0; idx < partyCnt; idx++){
	    
	    //진실 아는 사람 대표와 참가자 대표 다르면 거짓말 가능이므로 + 1
	    if(parent != find(joinList.get(idx)[0])){
	        answer += 1;
	    }
	}
	
    bw.write(answer+"");
	bw.flush();
	bw.close();
	}
	
	static int find(int num){
	    if(parents[num] != num){
	        parents[num] = find(parents[num]);
	    }
	    return parents[num];
	}
	
	static void union(int a, int b){
	    a = find(a);
	    b = find(b);
	    
	    if(a == b){
	        return;
	    }
	    
	    if(a > b){
	        parents[a] = b;
	    }
	    else{
	        parents[b] = a;
	    }
	}
	
}
