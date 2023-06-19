package day09;

import java.util.*;
import java.io.*;

public class 스타트와링크 {

	static int[][] map;

	static int team1[];
	static int N;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 번째 줄
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		team1 = new int[N / 2];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); // 나머지 줄
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursive(0, 0);

		System.out.println(answer);

	}

	private static void recursive(int cnt, int start) {
		// basis
		if (cnt == team1.length) {
//			System.out.println(Arrays.toString(team1));

			int[] team2 = new int[N / 2];
			int idx1 = 0;
			int idx2 = 0;
			for (int i = 0; i < N; i++) {
				if (idx1 <= (N / 2) - 1 && team1[idx1] == i) {
					idx1++;
				} else {
					team2[idx2] = i;
					idx2++;
				}
			}

			int teamPow1 = 0;
			for (int i = 0; i < team1.length - 1; i++) {
				for (int j = i; j < team1.length; j++) {
					teamPow1 += map[team1[i]][team1[j]];
					teamPow1 += map[team1[j]][team1[i]];
				}
			}

			int teamPow2 = 0;
			for (int i = 0; i < team2.length - 1; i++) {
				for (int j = i; j < team2.length; j++) {
					teamPow2 += map[team2[i]][team2[j]];
					teamPow2 += map[team2[j]][team2[i]];
				}
			}

			answer = Math.min(answer, Math.abs(teamPow1 - teamPow2));

			return;
		}

		// inductive
		for (int i = start; i < N; i++) {
			team1[cnt] = i;
			recursive(cnt + 1, i + 1);
			team1[cnt] = 0;
		}

	}
}
