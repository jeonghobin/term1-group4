package algo.swea.d2_1989;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;

			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			Stack<Character> stack = new Stack<>();

			if (s.length() % 2 == 0) {
				for (int i = 0; i < s.length() / 2; i++) {
					stack.add(s.charAt(i));
				}
				for (int i = s.length() / 2; i < s.length(); i++) {
					if (stack.pop() != s.charAt(i)) {
						break;
					}

					if (i == s.length() - 1) {
						answer = 1;
					}
				}
			} else {
				for (int i = 0; i < s.length() / 2; i++) {
					stack.add(s.charAt(i));
				}
				for (int i = s.length() / 2 + 1; i < s.length(); i++) {
					if (stack.pop() != s.charAt(i)) {
						break;
					}

					if (i == s.length() - 1) {
						answer = 1;
					}
				}
			}

			System.out.println("#" + test_case + " " + answer);
		} // [E] test_case

	}
}
