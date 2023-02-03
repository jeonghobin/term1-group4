package com.ssafy.study.beakjoon.beak_10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	//제로 
	//스택 -> 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			if(M==0)
				stack.pop();
			else
				stack.push(M);
		}
		
		int sum = 0;
		for (Integer integer : stack) {
			sum += integer;
		}

		System.out.println(sum);
	}

}
