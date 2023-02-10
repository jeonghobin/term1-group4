package algo.swea.d3_7236;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 저수지 구획 크기
			int answer = 0;

			String[][] map = new String[N][N];

			int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

			// input
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken();
				}
			}
//			print(map);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = 0;
					if (map[i][j].equals("W")) {
						for (int k = 0; k < dy.length; k++) {
							int cx = i + dx[k];
							int cy = j + dy[k];

							if (cx < 0 || cx >= N || cy < 0 || cy >= N || map[cx][cy].equals("G")) {
								continue;
							}

							num += 1;

						}
					} // [E] if W

					if (num == 0) {
						num = 1;
					}

					if (answer < num) {
						answer = num;
					}
				}
			}

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case

	}

	private static void print(String[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
