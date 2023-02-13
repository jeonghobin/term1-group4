package com.ssafy.study.beakjoon.beak_2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//탑
//일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고 -> 5 6 4 5
//각 탑의 꼭대기에 레이저 송신기를 설치 -> 레이저는 왼쪽에서 오른쪽으로 발사
//하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능(기둥에 맞아도 가능)
//ex) 6, 9, 5, 7, 4 반대 방향(왼쪽 방향)으로 동시에!! 레이저 신호를 발사한다고 하자 -> 4->7->9
//각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성
//수신하는 탑이 존재하지 않으면 0을 출력
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		int[] answer = new int[N];

		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				//앞이 n 보다 크면 수신
				if(stack.peek()[0] > n) {
					//수신
					answer[i - 1] = stack.peek()[1];
					break;
				}else {
					//수신X
					//더 작으면 어차피 쓸모 없음.
					answer[i - 1] = 0;
					stack.pop();
//					break;
				}
			}

			if (stack.isEmpty())
				answer[i - 1] = 0;

			stack.push(new int[] { n, i });
		}

		for (int i = 0; i < answer.length; i++) {
			bw.write(answer[i] + " ");
		}
		bw.flush();
		bw.close();
	}

}
