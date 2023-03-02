package month3.day01.복습;

import java.io.*;
import java.util.*;

// 수영장 복습

public class 수영장 {
	static int day, month, threeMonth, year;
	static int[] plan;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 각각 비용 저장
			st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			threeMonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			// 월별 이용 계획 저장
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			answer = year; // 연간 이용권이 최소라고 가정하고 시작
			recursive(0, 0); // 종료 조건, 가격 총합

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	private static void recursive(int count, int cost) {
		// basis part
		// 끝내는 조건
		if (count >= plan.length) {
			answer = Math.min(answer, cost);
			return;
		}

		// 가지치키
		if (cost > answer) {
			return;
		}

		// inductive part
		if (plan[count] == 0) {
			recursive(count + 1, cost);
		} else {
			recursive(count + 1, cost + day * plan[count]); // 일일 가격 더하기
			recursive(count + 1, cost + month); // 한달 가격 더하기
			recursive(count + 3, cost + threeMonth); // 세달 가격 더하기
		}

	}
}
