package com.ssafy.study.beakjoon.색종이_2567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 색종이 2
 * 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 붙인다
 * 둘레는?? -> 색종이에 1을 넣고 상하 좌우가 비어 있으면 그 개수 만큼이 둘레..!
 */
public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 주어진 색종이 수
		
		int[][] board = new int[102][102];
		for (int i = 0; i < N; i++) {// 색종이를 붙인 위치
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(st.nextToken());// 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
			int X = Integer.parseInt(st.nextToken());// 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리

			for (int j = X; j < X+10; j++) {
				for (int k = Y; k < Y+10; k++) {
					if (j <= 100 && k <= 100)
						board[j][k] = 1;
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (board[i][j] == 1) {
					for (int k = 0; k < 4; ++k) {
						int r = i + dx[k];
						int c = j + dy[k];
						if (r>=0 && r<=101 && c>=0 && c<=101 && board[r][c] == 0)
							answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
