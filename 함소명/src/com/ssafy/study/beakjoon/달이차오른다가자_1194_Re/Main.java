package com.ssafy.study.beakjoon.달이차오른다가자_1194_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//3차원 방문배열만으로는 통과되지 않는다. -> 퍼지면서 이동할때 한쪽이 키를 가지면 다른쪽도 키를 가진 줄 앎. 
// 비트마스킹 사용!!
// a&b -> AND 연산 : 둘 다 켜져 있는 경우
// a|b -> OR 연산 : 해당 비트가 둘 중 하나라도 켜져 있는 경우
/*
	열쇠 a -> 000001 -> 십진수 : 1
	열쇠 b -> 000010 -> 십진수 : 2
	열쇠 c -> 000100 -> 십진수 : 4
	열쇠 d -> 001000 -> 십진수 : 8
	열쇠 e -> 010000 -> 십진수 : 16
	열쇠 f -> 100000 -> 십진수 : 32
	//(1)현재 열쇠 정보와 획득한 열쇠 정보를 or연산 해주면 -> 획득한 열쇠정보를 포함한 열쇠정보를 얻을 수 있다. ex)000001+000010=000011
	//(2)문을 열 수있는지 확인 -> 문(000010 B)+열쇠(000011 a,b) => 000010 B만 나오게 됨
 */
public class Main {
	static int N, M, Ans = Integer.MAX_VALUE;
	static char[][] map;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	private static class Point {
		int r, c, cnt, key;

		public Point(int r, int c, int cnt, int key) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", key=" + key + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		Point current = null;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == '0')
					current = new Point(i, j, 0, 0);
			}
		}

		BFS(current);
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}

	private static void BFS(Point current) {
		Queue<Point> Q = new LinkedList<>();
		boolean[][][] v = new boolean[N][M][64];//111111까지 64
		ArrayList<Point> savekey = new ArrayList<>();
		Q.add(current);
		v[current.r][current.c][0] = true;

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			if (map[p.r][p.c] == '1') {
				Ans = Math.min(Ans, p.cnt);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				int nkey = p.key;

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc][nkey] && map[nr][nc] != '#') {
					// 키를 만났을 경우 키를 습득한다
					if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						//(1)참고
						nkey = nkey | (1 << (map[nr][nc] - 'a'));
					}
					// 문을 만났을 경우 키의 여부를 확인하고 그에 따라 이동한다
					if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						// >0 키가 있다면 
						// == 0 키가 없다면 continue 해서 이동하지 못하게 한다
						//(2)참고
						if ((nkey & (1 << (map[nr][nc] - 'a'))) == 0) {
							continue;
						}
					}
					v[nr][nc][nkey] = true;
					Q.add(new Point(nr, nc, p.cnt + 1, nkey));
				}
			}

		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}