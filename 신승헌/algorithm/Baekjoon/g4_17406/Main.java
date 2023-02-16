package algo.bj.g4_17406;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int K = Integer.parseInt(st.nextToken()); // 회전 횟수
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			// 1) -1 : 1,1부터 시작하는 위치 변경
			// 2) -1/+1 : for문 돌릴 때 위치 조정을 위해서
			int startX = r - s -1 -1;
			int startY = c - s -1 -1;
			int endX = r + s -1 + 1;
			int endY = c + s -1 + 1;

	
			for (int j = 0; j < ((r+s) - (r-s)) / 2  ; j++) {
				startX += 1;
				startY += 1;
				endX -= 1;
				endY -= 1;
				
				int temp = arr[startX][startY];
				int x = startX;
				int y = startY;
				int rotate = 0;
				int cx = x;
				int cy = y;
				while (true) {
					cx += dx[rotate];
					cy += dy[rotate];
					if (cx == startX && cy == startY) {
						arr[cx][cy] = temp;
						break;
					}
					if ( cx < startX || cx > endX || cy < startY || cy > endY) {
						cx -= dx[rotate];
						cy -= dy[rotate];
						rotate = (rotate + 1) % 4;
						continue;
					}

					int now = arr[cx][cy];
					arr[cx][cy] = temp;
					temp = now;
				}
			}
			
		}
		
		int minRow = Integer.MAX_VALUE;
		
		for (int j = 0; j < arr.length; j++) {
			int nowRow = 0;
			for (int k = 0; k < arr[0].length; k++) {
				nowRow += arr[j][k];
			}
			if (minRow > nowRow) {
				minRow = nowRow;
			}
		}
		
		
		print(arr);
		System.out.println(minRow);
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
