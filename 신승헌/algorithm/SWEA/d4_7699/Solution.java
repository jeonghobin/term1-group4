package algo.swea.d4_7699;

import java.io.*;
import java.util.*;

public class Solution {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static char[][] map;
	static boolean[][] v;
	static Map<Character, Integer> counter;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); // 행
			int C = Integer.parseInt(st.nextToken()); // 열

			map = new char[R][C];
			v = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				String row = st.nextToken();
				for (int j = 0; j < C; j++) {
					map[i][j] = row.charAt(j);
				}
			}

//			print();
//			
//			char c = (char)65;
//			System.out.println(c);
//		
//			counter.put((char)65, 1);
//			counter.get('A');

			counter = new HashMap<>();

			for (int i = 65; i < 65+26; i++) {
				counter.put((char) i, 0);
			}

			answer = 0;

			dfs(0, 0, 0);

			if (R==1 && C==1) answer = 1;
			
			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	private static void dfs(int x, int y, int nowWatch) {
		// basis part
		char nowChar = map[x][y];
		if (counter.get(nowChar) >= 1)
			return;

		// inductive part
		for (int i = 0; i < dx.length; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length && v[cx][cy] == false) {
				nowWatch++;
				counter.put(nowChar, counter.get(nowChar) + 1);
				answer = Math.max(answer, nowWatch);
				v[x][y] = true;
				dfs(cx, cy, nowWatch);
				v[x][y] = false;
				counter.put(nowChar, counter.get(nowChar) - 1);
				nowWatch--;
			}
		}

	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
