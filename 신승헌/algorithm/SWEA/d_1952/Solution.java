package algo.swea.d_1952;

import java.io.*;
import java.util.*;

public class Solution {
	static int day, month, monthThree, year;
	static int[] plan;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			monthThree = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			plan = new int[12];
			for (int i = 0; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			answer = year; // 1년권 가격을 최소로 잡고 시작
			recursive(0, 0);
			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	private static void recursive(int mon, int cost) {
		// basis part
		if (mon >= 12) {
			answer = Math.min(answer, cost);
			return;
		}

		// inductive part
		recursive(mon + 1, cost + plan[mon] * day); // 1일권 가격
		recursive(mon + 1, cost + month); // 1일권 가격
		recursive(mon + 3, cost + monthThree); // 1일권 가격

	}
}
