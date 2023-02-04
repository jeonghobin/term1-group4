package com.ssafy.study.beakjoon.beak_10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	//덱 Deque
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if(input.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				deque.push(num);
			}else if(input.equals("top")) {
				if(deque.isEmpty())
					System.out.println("-1");
				else
					System.out.println(deque.peek());
			}else if(input.equals("size")) {
				System.out.println(deque.size());
			}else if(input.equals("empty")) {
				if(deque.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			}else if(input.equals("pop")) {
				if(deque.isEmpty())
					System.out.println("-1");
				else
					System.out.println(deque.pop());
			}
			
		}
	}

}
