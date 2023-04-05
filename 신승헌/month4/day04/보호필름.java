package day04;

import java.io.*;
import java.util.*;

public class 보호필름 {

	static int D, W, K;
	static int[][] map;
	static int[] check;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()); // 두께
			W = Integer.parseInt(st.nextToken()); // 가로 크기
			K = Integer.parseInt(st.nextToken()); // 합격기준
			check = new int[W];
			answer = Integer.MAX_VALUE;

			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			print(map);
			int flag = checkPass(map);
//			System.out.println(Arrays.toString(check));

			// 약품 투여없이 통과라면
			if (flag == 1) {
				answer = 0;
			} else {
				v = new boolean[D];
				recursive(0);
			}

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	static boolean[] v;

	private static void recursive(int count) {
		// basis
		if (count == v.length) {
			int[][] copyMap = new int[D][W];

			int nowCount = 0; // 현재 투입할 약품의 개수
			for (int i = 0; i < v.length; i++) {
				if (v[i] == true) {
					nowCount++;
				}
			}

			// 맵 복사
			copy(map, copyMap);
			// 약품A 투여
			drug(copyMap, nowCount);
			

			return;
		}

		// inductive
		v[count] = true;
		recursive(count + 1);
		v[count] = false;
		recursive(count + 1);

	}

	private static void drug(int[][] copyMap, int nowCount) {
		for (int i = 0; i < copyMap.length; i++) {
			if (v[i] == false)
				continue;
			Arrays.fill(copyMap[i], 0);
		}
		
		int ok = checkPass(copyMap);
		if (ok == 1) {
			answer = Math.min(answer, nowCount);
			return;
		}
		
		for (int i = 0; i < copyMap.length; i++) {
			if (v[i] == false)
				continue;
			Arrays.fill(copyMap[i], 1);
			
			ok = checkPass(copyMap);
			if (ok == 1) {
				answer = Math.min(answer, nowCount);
				return;
			}
		}
		
		
	}

	private static void copy(int[][] map, int[][] copyMap) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

	}

	private static int checkPass(int[][] map) {
		// 체크 함수 부를 때 마다 초기화
		Arrays.fill(check, 0);
		for (int y = 0; y < map[0].length; y++) {
			int cnt = 0;
			int before = -1;
			for (int x = 0; x < map.length; x++) {
				if (map[x][y] != before) {
					if (cnt > check[y]) {
						check[y] = cnt;
					}
					before = map[x][y];
					cnt = 1;
				} else {
					cnt++;
				}
			}
			// 마지막에 갱신
			if (cnt > check[y]) {
				check[y] = cnt;
			}
		}

		// 검사를 통과했는지 체크
		int flag = 1; // 1이면 통과, 0이라면 불통과
		for (int i = 0; i < check.length; i++) {
			if (check[i] < K) {
				flag = 0;
				break;
			}
		}

		return flag;

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