package algo.swea.d4_1861;

import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map;
	static boolean[][] v;
	static int minStart;
	static int maxTotalRoom;
	static int startNum;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			v = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			startNum = 1000 * 1000;
			minStart = 1000 * 1000;
			maxTotalRoom = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (v[i][j] == false) {
						startNum = map[i][j];
						dfs(i, j, 0);
					}

				}
			}
			System.out.println("#" + test_case + " " + minStart + " " + maxTotalRoom);

		} // [E] test_case
	}

	private static void dfs(int i, int j, int count) {
		v[i][j] = true;
		count++;

		int now = map[i][j];
		for (int k = 0; k < dx.length; k++) {
			int cx = i + dx[k];
			int cy = j + dy[k];
			if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length && map[cx][cy] == now + 1) {
				v[cx][cy] = true;

				dfs(cx, cy, count);
			}
		}
		if (maxTotalRoom < count) {
			minStart = startNum;
			maxTotalRoom = count;
		}
		if (maxTotalRoom == count && startNum <= minStart) {
			minStart = startNum;
			maxTotalRoom = count;
		}
	}
}
