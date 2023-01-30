package com.ssafy.study.LSJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//빌딩
//빌딩을 세울 수 있는 구획은 B, 공원 조성단지는 G
//빌딩을 세울 때 인접한 구획에 공원 조성 단지 G가 있다면, 2층 높이로 세울수 있다.
//빌딩을 세울 때 인접한 구획에 공원 조성 단지 G가 없다면, 현 위치의 가로 위치에 있는 빌딩구획 B와 세로 위치의 빌딩 구획 B의 수를 더한 크기만큼 빌딩을 세울 수 있다
//가장 높은 빌딩 높이를 출력하라.
public class problem_13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			String[][] build = new String[N][N];
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					build[i][j] = str.nextToken();// 한글자씩
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (build[i][j].equals("B"))
						if (!round(i, j, build))
							arr[i][j] = 2;
						else
							arr[i][j] = sum(i, j, build);
				}
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > max)
						max = arr[i][j];
				}
			}

			System.out.println("#" + test_case + " " + max);

		}
	}

	static int[] lt = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] rt = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static Boolean round(int l, int r, String[][] arr) {
		boolean answer = true;
		for (int i = 0; i < 8; i++) {
			if (l + lt[i] >= 0 && l + lt[i] < arr.length && r + rt[i] >= 0 && r + rt[i] < arr.length && arr[l + lt[i]][r + rt[i]].equals("G"))
				answer = false;
		}

		return answer;
	}

	public static Integer sum(int l, int r, String[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[l][i].equals("B"))
				sum++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][r].equals("B"))
				sum++;
		}
		return sum - 1;
	}

}
