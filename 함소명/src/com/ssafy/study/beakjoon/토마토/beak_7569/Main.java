package  com.ssafy.study.beakjoon.토마토.beak_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, level;
	static int[][][] box;
	static ArrayList<Point> tomato = new ArrayList<>();
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Point {
		int r, c, h, cnt;

		public Point(int r, int c, int h, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", h=" + h + ", cnt=" + cnt + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[N][M][H];

		boolean isFull = true;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[i][j][h] = Integer.parseInt(st.nextToken());

					if (box[i][j][h] == 1)
						tomato.add(new Point(i, j, h, 0));
					if (box[i][j][h] == 0)
						isFull = false;
				}
			}
		}

		if (isFull)
			System.out.println(0);
		else
			BFS();

	}

	private static void BFS() {
		Queue<Point> Q = new LinkedList<>();

		for (Point point : tomato) {
			Q.offer(new Point(point.r, point.c, point.h, 0));
		}

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			level = Math.max(level, p.cnt);
//			print(box);

			// 4��
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && box[nr][nc][p.h] == 0) {
					box[nr][nc][p.h] = 1;
					Q.add(new Point(nr, nc, p.h, p.cnt + 1));
				}
			}

			int upH = p.h + 1;
			int downH = p.h - 1;

			// �Ʒ�
			if (downH >= 0 && box[p.r][p.c][downH] == 0) {
				box[p.r][p.c][downH] = 1;
				Q.add(new Point(p.r, p.c, downH, p.cnt + 1));
			}

			// ��
			if (upH < H && box[p.r][p.c][upH] == 0) {
				box[p.r][p.c][upH] = 1;
				Q.add(new Point(p.r, p.c, upH, p.cnt + 1));
			}

		}

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][h] == 0)
						level = -1;
				}
			}
		}

		System.out.println(level);
	}

	private static void print(int[][][] box2) {
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(box2[i][j][h] + " ");
				}
				System.out.println();
			}
		}
		System.out.println(level);
		System.out.println();
	}

}
