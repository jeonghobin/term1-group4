package algo.swea.d2_1954;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int nowNum = 1;
			int[][] arr = new int[N][N];
			
			int cx = 0; // 시작  x 위치
			int cy = -1; // 시작  y 위치
			int rotateNow = 0; // 이동 방향
			
			while (true) {
				if (nowNum > N * N) {
					break;
				}
				
				if (cx + dx[rotateNow] < 0 || cx + dx[rotateNow] >= N ||
					cy + dy[rotateNow] < 0 || cy + dy[rotateNow] >= N ||
					arr[cx + dx[rotateNow]][cy + dy[rotateNow]] != 0) {
					rotateNow = (rotateNow + 1) % 4;
				}
				
				cx = cx + dx[rotateNow];
				cy = cy + dy[rotateNow];
				
				arr[cx][cy] = nowNum;
				nowNum++;
			}
			
			System.out.print("#" + test_case + "\n");
			print(arr);
			
			
		} // [E] test_case
	}

	private static void print(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}
