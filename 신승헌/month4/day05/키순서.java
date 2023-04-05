package day05;

import java.io.*;
import java.util.*;

/*
 * Goal : 자신의 키순서를 알고 있는 학생 수
 * 
 * 정점 : 학생
 * 간선 : 학생 간 키 관계 -> 일부만 주어짐
 *   -> 가중치 : x
 *   -> 방향성 : o
 * 	 ex) 1 -> 5 : 1보다 5가 키가 크다
 * 		 1은 5보다 작다
 * 
 * 그래프 표현
 *   정점 중심 표현
 *     - 인접 행렬
 *     - 인접 리스트
 *   간선 중심 표현 
 *     - 간선 리스트
 *
 * 인접 행렬로 문제를 풀었을 때 크고 작은 정보를 하나에 담을 수 있음
 * a[i][j] : i->j i보다 j가 키가 큼
 * a[j][i] : j->i j보다 i가 키가 작음
 * 나보다 키가 작은 정점의 개수와, 나보다 키가 큰 정점의 개수를 모두 더했을 때 (n-1)이라면 순서를 구할 수 있음
 * 
 * 인접 리스트는 나보다 작은 사람을 관리하는 리스트와, 나보다 큰 사람을 관리하는 리스트 둘 다 만들어야 함
 */

public class 키순서 {

	static int N, M;

	static int[][] map; // 인접 행렬

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			// 두 번째 줄
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());

			int INF = 99999; // 무한한 값

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(map[i], INF);
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				map[start][end] = 1;
			}

			// 플로이드 워셜 : 경출도
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					// 경우-출발이 동일한 경우
					if (k == i)
						continue;
					for (int j = 0; j < N; j++) {
						if (i == j || j == k)
							continue;
						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}

			int answer = 0;
			int[] count = new int[N];
			// i와 관계가 있는 인원을 찾음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 행에 연관된 값이 있는 경우 : i보다 큰 j가 존재하는 경우
					if (map[i][j] != INF) {
						count[i] = count[i] + 1;
					}
					// 열에 연관된 값이 있는 경우 : j보다 작은 i가 존재하는 경우
					if (map[j][i] != INF) {
						count[i] = count[i] + 1;
					}
				}
			}

			// i와 관계 있는 인원이 N-1이라면 i는 모든 인원과 관계를 가지는 것임
			for (int i = 0; i < N; i++) {
				if (count[i] == N - 1) {
					answer++;
				}
			}

			System.out.println("#" + test_case + " " + answer);
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
