package com.ssafy.study.beakjoon.beak_11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	//요세푸스 문제
	//큐 사용
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		
		int[] arr = new int[N];
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while (queue.size() > 0) {
			for (int i = 0; i < C-1; i++) {
				queue.offer(queue.poll());
			}
			
			arr[N-queue.size()] = queue.poll();
		}
		
		String str = Arrays.toString(arr);
		str= str.replace("[", "<");
		str= str.replace("]", ">");
		System.out.println(str);
	}
}
