package com.ssafy.study.beakjoon.beak_1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//요세푸스 문제
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// n명
		int k = sc.nextInt();// k번째

		Queue<Integer> Q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			Q.offer(i);
		} 

		System.out.print("<");
		while (!Q.isEmpty()) {

			for (int i = 0; i < k - 1; i++) {
				int a = Q.poll();
				Q.offer(a);
			}

			System.out.print(Q.poll());

			if (!Q.isEmpty())
				System.out.print(", ");
		}
		
		System.out.print(">");
	}

}
