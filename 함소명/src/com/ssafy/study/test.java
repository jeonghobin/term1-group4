package com.ssafy.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	static int N, min;
	static int map[][];
	static Node apple[];

	// 우,하,좌,상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	/**
	 * dir : 방향 
	 * cur : 꺽은 횟수 
	 * level : BFS 지나간 거리
	 *
	 */
	static class Node {
		int r, c, dir, cur, level;

		public Node(int r, int c, int dir, int cur, int level) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cur = cur;
			this.level = level;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dir=" + dir + ", cur=" + cur + ", level=" + level + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("apple.txt")));		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			apple = new Node[11];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0)
						apple[map[i][j]] = new Node(i, j, 0, 0, 0);
				}
			}

			BFS();

			System.out.println("#" + tc + " " + min);

		}

	}

	private static void BFS() {
		int appleIdx = 0;
		int curve = 0;
		apple[0] = new Node(0, 0, 0, 0, 0);
		int min = Integer.MAX_VALUE;

		Queue<Node> Q = new LinkedList<>();
		Q.add(apple[appleIdx]);// 오른쪽부터 시작
		
		while (apple[appleIdx + 1] != null) {
			
			int level = Integer.MAX_VALUE;

			L: while (!Q.isEmpty()) {

				Node p = Q.poll();

				if (p.level > level) 
					break;
				
				int dir = p.dir;
				for (int cnt = 0; cnt < 4; cnt++) {// 4번 돌리기 위함.
					dir = dir % 4;

					// 갈수있는데까지 회전시켜보기

					int dx = p.r + dr[dir];
					int dy = p.c + dc[dir];

					if (dx >= 0 && dy >= 0 && dx < N && dy < N) {

						if (p.dir != dir) {
							// 제자리에서 한번만 돌릴 수 있다.
							int cha = Math.abs(p.dir - dir);
							if (cha < 2)
								Q.add(new Node(dx, dy, dir, p.cur + 1, p.level + 1));
						} else {
							Q.add(new Node(dx, dy, dir, p.cur, p.level + 1));
						}

						if (dx == apple[appleIdx + 1].r && dy == apple[appleIdx + 1].c) {

							level = p.level + 1;
							min = Math.min(p.cur, min);
						
							Q = new LinkedList<>();
							Q.offer(new Node(apple[appleIdx+1].r, apple[appleIdx+1].c, dir, min, 0));

							System.out.println(min);
							break L;
						}
					}

					dir++;
				}
			}

			appleIdx++;
		}

		System.out.println(curve);
	}

}
