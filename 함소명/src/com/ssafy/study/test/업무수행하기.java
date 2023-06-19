package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 업무수행하기 {
	static int N, result;
	static int[] times;
	static ArrayList<Integer>[] work;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			times = new int[N + 1];
			work = new ArrayList[N + 1];
			v = new boolean[N + 1];

			// 초기화
			for (int i = 1; i <= N; i++) {
				work[i] = new ArrayList<>();
			}

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				times[i] = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				if (count != 0)
					for (int j = 0; j < count; j++) {
						work[i].add(Integer.parseInt(st.nextToken()));
					}
			}

//			System.out.println(Arrays.toString(work));

			result = -1;

			findMinTime();

			System.out.println(result);

		}
	}

	private static void findMinTime() {
		int[] time = new int[N + 1];//i번째를 김수석이 도와줬을 경우 시간 저장할 배열


		//업무가 완료 될 수 있는지 확인
		if (!isCompleted()) {
			result = -1;
		} else {
			//최소 업무시간 출력
			for (int i = 1; i <= N; i++) {
				result = Math.min(result, time[i]);
			}
		}
	}

	private static boolean isCompleted() {
		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				return false;
			}
		}
		return true;
	}

}
