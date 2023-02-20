package com.ssafy.study.beakjoon.DFS_BFS.beak_2606;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * 바이러스
 * DFS, BFS 뭐든 상관 없을듯.
 */
public class Main {
	static int[][] arr;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		DFS(new boolean[N + 1], 1);
//		BFS(new boolean[N + 1], 1);
		System.out.println(cnt);
	}
	
	
	
	
	public static void DFS(boolean[] v, int k) {
		Stack<Integer> stack = new Stack();
		stack.push(k);
		v[k] = true;

		while (!stack.isEmpty()) {
			int current = stack.pop();
			
			for (int i = 1; i < arr.length; i++) {
				if (!v[i] && arr[current][i] == 1) {
					v[i] = true;
					stack.push(i);
//					System.out.print(i + " ");
					cnt++;
				}
			}
		}
	}

	public static void BFS(boolean[] v, int k) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(k);
		v[k] = true;

		while (!Q.isEmpty()) {
			int current = Q.poll();
			for (int i = 1; i < arr.length; i++) {
				if (!v[i] && arr[current][i] == 1) {
					v[i] = true;
					Q.add(i);
//					System.out.print(i + " ");
					cnt++;
				}
			}
		}

	}

}
