package Jungol.p1707;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N][N];
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int nowDirection = 0;
		int nowX = 0;
		int nowY = -1;
		int nowNumber = 1;
		
		for (int i = 0; i < N * N; i++) {
			// 배열 범위를 벗어나는 경우 + 이동할 곳에 이미 숫자가 존재하는 경우
			if (nowX + dx[nowDirection] == N || nowY + dy[nowDirection] == N ||
					nowX + dx[nowDirection] == -1 || nowY + dy[nowDirection] == -1 ||
					array[nowX + dx[nowDirection]][nowY + dy[nowDirection]] != 0) {
				nowDirection = (nowDirection + 1) % 4;
			}
			
			nowX += dx[nowDirection];
			nowY += dy[nowDirection];
			
			array[nowX][nowY] = nowNumber;
			nowNumber += 1;
		}
		
		// output
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sb.append(array[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
