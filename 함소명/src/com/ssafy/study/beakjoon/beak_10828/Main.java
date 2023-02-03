package com.ssafy.study.beakjoon.beak_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	//스택
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if(input.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}else if(input.equals("top")) {
				if(stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.peek());
			}else if(input.equals("size")) {
				System.out.println(stack.size());
			}else if(input.equals("empty")) {
				if(stack.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			}else if(input.equals("pop")) {
				if(stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.pop());
			}
			
		}
	}

}
