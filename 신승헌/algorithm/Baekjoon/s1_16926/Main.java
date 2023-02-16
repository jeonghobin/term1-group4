package algo.bj.s1_16926;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 가로
		int M = Integer.parseInt(st.nextToken()); // 세로
		int R = Integer.parseInt(st.nextToken()); // 회전

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int startX = -1;
		int startY = -1;
		int endX = N + 1;
		int endY = M + 1;

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// 안쪽까지 돌아야하는 개수 == (짧은거/2)회
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			startX++;
			startY++;
			endX--;
			endY--;

			int cx = startX;
			int cy = startY;
			int rotate = 0;

			// 회전을 해야하는 횟수
			for (int _j = 0; _j < R; _j++) {
				int back = arr[cx][cy];
				while (true) {
					if (cx + dx[rotate] < startX || cx + dx[rotate] >= endX || cy + dy[rotate] < startY
							|| cy + dy[rotate] >= endY) {
						rotate = (rotate + 1) % 4;
					}

					cx = cx + dx[rotate];
					cy = cy + dy[rotate];
					int temp = arr[cx][cy];
					arr[cx][cy] = back;
					back = temp;

					if (cx == startX && cy == startY) {
						break;
					}

				}
			}

		}
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}

	}
}
