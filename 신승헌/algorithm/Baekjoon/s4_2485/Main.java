package test.baekjoon.s4_2485;

import java.io.*;
import java.util.*;

public class Main {
	public static int gcd(int A, int B) {
		if (A < B) {
			int temp = B;
			B = A;
			A = temp;
		}

		int C = A % B;

		if (C == 0) {
			return B;
		}

		return gcd(B, C);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] array = new int[N - 1];

		st = new StringTokenizer(br.readLine());

		int before = Integer.parseInt(st.nextToken()); // 이전 나무 위치
		for (int i = 0; i < array.length; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken()); // 현재 나무 위치

			array[i] = now - before; // 나무 간 거리
			before = now;
		}

		int G = array[0]; // 최대 공약수
		for (int i = 1; i < array.length; i++) {
			G = gcd(G, array[i]);
		}

		int answer = 0;

		// array[]에는 거리 차가 있으므로, 그걸 최대 공약수로 나누면 개수가 나오지 않을까?
		for (int i = 0; i < array.length; i++) {
			answer += array[i] / G - 1;
		}

		System.out.println(answer);

	}
}
