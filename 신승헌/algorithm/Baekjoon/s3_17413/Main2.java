package homework.Baekjoon.s3_17413;

import java.io.*;
import java.util.*;

// 이게 왜 가능함?
// for + while하면 최악 10억 번 돌지 않나요??????

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		boolean isTag = false;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			
			if (now == '<') {
				while (!stack.empty()) {
					sb.append(stack.pop());
				}
				sb.append(now);
				isTag = true;
				continue;
			}
			
			if (isTag) {
				if (now == '>') {
					isTag = false;
				}
				sb.append(now);
				continue;
			} else {
				if (now == ' ') {
					while (!stack.empty()) {
						sb.append(stack.pop());
					}
					sb.append(now);
				} else {
					stack.add(now);
				}
			}

		}
		while (!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
		
	}
}
