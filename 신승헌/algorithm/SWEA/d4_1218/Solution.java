package algo.swea.d4_1218;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
//		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			int _data = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			Stack<Character> stack = new Stack<>();
			int answer = 1;
			
			L:for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				
				switch (now) {
				case '(':
				case '[':
				case '{':
				case '<':
					stack.push(now);
					break;
				case ')':
					if ('(' == stack.pop()) {
						break;
					} else {
						answer = 0;
						break L;
					}
				case ']':
					if ('[' == stack.pop()) {
						break;
					} else {
						answer = 0;
						break L;
					}
				case '}':
					if ('{' == stack.pop()) {
						break;
					} else {
						answer = 0;
						break L;
					}
				case '>':
					if ('<' == stack.pop()) {
						break;
					} else {
						answer = 0;
						break L;
					}

				}
				
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
	}
}
