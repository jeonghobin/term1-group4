package com.ssafy.study.beakjoon.beak_2438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 영식이와 친구들
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// 시계방향으로 1부터 N까지 적혀있는 자리에 앉는다
		// 일단 1번 자리에 앉은 사람이 공을 받는다.
		// 한 사람이 공을 M번 받았으면 게임은 끝난다. (지금 받은 공도 포함하여 센다.)
		// 공을 던질 때, 현재 공을 받은 횟수가 홀수번이면 -> 시계 방향으로 L번째 있는 사람에게, 짝수번이면 -> 반시계 방향으로 L번째 있는
		// 사람에게 공을 던진다.
		// 공을 총 몇번 던지는지 구하시오.(입력 순서 : N, M, L )

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int idx = 0;
		int[] list = new int[N];
		while (list[idx] < M) {
			
			list[idx] = list[idx] + 1;
			
			if (list[idx] == M)
				break;
			
			cnt++;
			
			if (list[idx] % 2 == 0) {// 짝수 0-2 =-2 //-7 ->-2 ->3
				idx = idx - L;
				if (idx < 0)
					idx = N-Math.abs(idx % N);
				
			} else {// 홀수
				idx = idx + L;
				if (idx >= N)
					idx = idx % N;
			}
		}

		System.out.println(cnt);
	}

}
