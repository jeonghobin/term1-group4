package day07;

import java.io.*;
import java.util.*;

public class 이항계수1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 번째 줄
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		long answer = 0L;

		// 순열 구하기
		long p = 1L;

		// 5P2 일 때
		// 분자는 5*4*3*2*1
		// 분모는 3*2*1 -> N부터 R+1까지 곱
		for (int i = N; i > N - R; i--) {
			p = p * i % 10007;
		}

		// 조합 구하기
		long rp = 1L; // r! 구하기
		// 0! == 1, 아니면 팩토리얼 구하기
		if (R != 0) {
			for (int i = R; i > 0; i--) {
				rp = rp * i ;
			}
		}

		answer = (p / rp);

		System.out.println(answer);

	}

}
