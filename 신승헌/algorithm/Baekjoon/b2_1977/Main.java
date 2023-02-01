package test.baekjoon.b2_1977;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int min = -1;
		int answer = -1;
		
		for (int i = 1; i <= 100; i++) {
			if (i * i > N) {
				break;
			}
			
			if (i * i < M) {
				continue;
			}

			// 제일 처음 들어오면 최소값 지정
			if (answer == -1) {
				answer = 0;
				min = i * i;
			}
			answer += i * i;
			
		}
		
		
		System.out.println(answer);
		if (answer == -1) {
			return;
		}
		System.out.println(min);
		
		
	}
}
