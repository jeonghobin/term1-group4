package algo.bj.s4_2567;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int arr[][] = new int[101][101];

		int N = Integer.parseInt(st.nextToken());

//		int[] x = new int[N];
//		int[] y = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int r = x; r < x + 10; r++) {
				for (int c = y; c < y + 10; c++) {
					arr[r][c] = 1;
				}
			}
		}

//		print(arr);

		int answer = 0;
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					for (int k = 0; k < dy.length; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];

						if (cx >= 0 && cx < arr.length && cy >= 0 && cy < arr.length) {
							if (arr[cx][cy] == 0) {
								answer++;
							}
						} else {
							answer++;
						}
					}
				}
			}
		}
		System.out.println(answer);

	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
