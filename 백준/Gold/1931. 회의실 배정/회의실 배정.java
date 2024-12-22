import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int cnt = Integer.parseInt(br.readLine());
		int[][] meeting = new int[cnt][2];

		for (int idx = 0; idx < cnt; idx++) {
			st = new StringTokenizer(br.readLine());
			meeting[idx][0] = Integer.parseInt(st.nextToken());
			meeting[idx][1] = Integer.parseInt(st.nextToken());
		} // 회의 입력 끝

		// 만약 종료 시간이 같다면 시작시간 느린거 먼저
		Arrays.sort(meeting, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

		int answer = 1;
		int index = 0;
		for (int idx = 1; idx < cnt; idx++) {
			if (meeting[index][1] <= meeting[idx][0]) {
				answer += 1;
				index = idx;
			}
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();

	}

}
