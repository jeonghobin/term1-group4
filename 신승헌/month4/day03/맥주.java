package month4.day03;

import java.io.*;
import java.util.*;

// 경유비를 최소로 하는 문제로 볼 수도 있음
public class 맥주 {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 편의점 개수
			int N = n + 2;

			map = new int[N][N];

			int[] inputX = new int[N]; // 사용자 입력 저장
			int[] inputY = new int[N];

			int INF = 9999999; // 절대값

			// 나머지 줄
			// 맨 앞 : 집 | 맨 뒤 : 패스티벌 좌표
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				inputX[i] = Integer.parseInt(st.nextToken());
				inputY[i] = Integer.parseInt(st.nextToken());
			}

			// 맨해튼 거리 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 자기 자신까지 거리는 0
					if (i == j) {
						map[i][j] = 0;
						continue;
					}
					map[i][j] = Math.abs(inputX[i] - inputX[j]) + Math.abs(inputY[i] - inputY[j]);
					if (map[i][j] > 1000) {
						map[i][j] = INF;
					}
				}
			}

//			print(map);

			// 플로이드 워셜 : 경출도
			for (int k = 0; k < N; k++) { // 경유지
				for (int i = 0; i < N; i++) { // 출발지
					// 경유지와 출발지가 같다면 pass
					if (k == i)
						continue;
					for (int j = 0; j < N; j++) { // 도착지
						// 출발-경유, 경유-도착이 같다면 pass
						if (i == k || k == j)
							continue;
						// 출발지에서 도착지까지의 거리가, 출발-경유 + 경유-도착보다 오래 걸린다면 갱신
						if (map[i][j] > map[i][k] + map[k][j]) {
							// 갱신된 거리가 2000이하라면 (한번에 갈 수 있는 거리라면)
							if (map[i][k] + map[k][j] <= 2000) {
								map[i][j] = 1000;
							}
						}
					}
				}
			}

//			print(map);

			if (map[0][N - 1] <= 1000) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
