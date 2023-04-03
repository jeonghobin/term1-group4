package month4.day03;

import java.io.*;
import java.util.*;

public class 사람네트워크2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = Integer.MAX_VALUE;

			// 한줄에 모두 입력
			st = new StringTokenizer(br.readLine());

			// 첫 번째 인자 (인원 수)
			int n = Integer.parseInt(st.nextToken());
			int INF = 99999999;

			int[][] map = new int[n][n];

			// 나머지 인자 (인접 행렬)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0) {
						map[i][j] = INF;
					}
				}
			}

			// 플로이드 워셜 : 경출도
			for (int k = 0; k < n; k++) { // 경유
				for (int i = 0; i < n; i++) { // 출발
					// 경우-출발이 동일한 경우 pass
					if (k == i)
						continue;
					for (int j = 0; j < n; j++) { // 도착
						// 출발-도착, 경유-도착이 동일한 경우 pass
						if (i == j || j == k)
							continue;

						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}

			int[] cc = new int[n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != INF) {
						cc[i] += map[i][j];
					}
				}
				if (cc[i] < answer) {
					answer = cc[i];
				}
			}

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}
}
