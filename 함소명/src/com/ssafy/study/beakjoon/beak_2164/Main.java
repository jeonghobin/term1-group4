package com.ssafy.study.beakjoon.beak_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 	1(제일 위) 부터 N(제일 아래)까지의 번호가 붙어 있으며
 * 카드가 한 장 남을 때까지 반복
 * 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다 -> Queue
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	
		Queue<Integer> Q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			Q.offer(i);
		}
		while (Q.size()>1) {
			Q.poll();
			int poll = Q.poll();
			Q.offer(poll);
		}
		System.out.println(Q.poll());

	}

}
