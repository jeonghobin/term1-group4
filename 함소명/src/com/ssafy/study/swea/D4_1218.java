package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호 짝짓기
public class D4_1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			Stack<Character> stack = new Stack<Character>();
			boolean v = true;
			for (int i = 0; i < N; i++) {
				char ch = str.charAt(i);

				switch (ch) {
				case '(':
				case '[':
				case '{':
				case '<':
					stack.push(ch);
					break;
				case ')':
					if (stack.peek() == '(')
						stack.pop();
					else
						v = false;
					break;
				case ']':
					if (stack.peek() == '[')
						stack.pop();
					else
						v = false;
					break;
				case '}':
					if (stack.peek() == '{')
						stack.pop();
					else
						v = false;
					break;
				case '>':
					if (stack.peek() == '<')
						stack.pop();
					else
						v = false;
					break;
				}
//            System.out.println(stack);
			}

			if (stack.isEmpty() && v) {
				System.out.println("#" + test_case + " " + "1");
			} else
				System.out.println("#" + test_case + " " + "0");
		}

	}
}
