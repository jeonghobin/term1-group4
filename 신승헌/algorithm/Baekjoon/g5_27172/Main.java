package test.baekjoon.g5_27172;

import java.io.*;
import java.util.*;

public class Main {
	public static int isGcd(int A, int B) {
		if (A % B == 0) {
			return -1;
		} else if (B % A == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		int[] answer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == j) {
					continue;
				}
				answer[i] += isGcd(array[i], array[j]);
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
	}
}
