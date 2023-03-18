package com.ssafy.study.beakjoon.더하기.더하기2_12101;

import java.io.*;
import java.util.*;

public class Main {
	static int num;
	static int idx;
	static int cnt;
	static String answer = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		idx = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();

		recursive(list, 0);

		System.out.println(answer.equals("") ? "-1" : answer);
	}

	private static void recursive(ArrayList<Integer> sel, int sum) {
		if (sum > num)
			return;

		if (sum == num) {
			cnt++;
			if (cnt == idx)
				for (int i = 0; i < sel.size(); i++) {
					answer += sel.get(i);
					if (i < sel.size() - 1)
						answer += "+";
				}

			return;
		}

		// 1 for문에 2,3 for문 3개 돌린것과 마찬가지.
		// 배열은 초기화되서 괜찮지만 arraylist는 돌아올때마다 마지막 숫자를 빼줘야한다.
		for (int i = 1; i <= 3; i++) {
			sel.add(i);
			recursive(sel, sum + i);
//			sel.remove(sel.size() - 1);
		}

	}

}