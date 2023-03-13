package com.ssafy.study.beakjoon.숫자야구;

import java.io.*;
import java.util.*;

/*
 * 000~999 넣어봐서 주어진 조건을 모두 만족하는 숫자 찾기. 
 * 우선 ball 처리 하고 strike면 ball-1
 */
public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, int[]> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			map.put(num, new int[] { strike, ball });
		}

		for (int j = 111; j <= 999; j++) {
			boolean[] v = new boolean[10];
			String str = String.valueOf(j);
			boolean isUse = true;

			for (int k = 0; k < str.length(); k++) {
				if (str.charAt(k) - '0' != 0 && !v[str.charAt(k) - '0'])
					v[str.charAt(k) - '0'] = true;
				else {
					isUse = false;
					break;
				}
			}
			if (isUse)
				compare(str, map);
		}

		System.out.println(cnt);

	}

	private static void compare(String num, HashMap<String, int[]> map) {
		boolean res = false;

		for (String num2 : map.keySet()) {
			int strike = 0;
			int ball = 0;

			for (int i = 0; i < num2.length(); i++) {
				if (num.indexOf(num2.charAt(i)) > -1)
					ball++;
			}

			for (int j = 0; j < 3; j++) {
				// strike
				if (num.charAt(j) == num2.charAt(j)) {
					strike++;
					ball--;
				}
			}

			if (map.get(num2)[0] == strike && map.get(num2)[1] == ball)
				res = true;
			else {
				res = false;
				break;
			}
		}

		if (res)
			cnt++;
	}

}
