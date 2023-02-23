package com.ssafy.study.beakjoon.beak_2206_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 벽 부수고 이동하기
 * (1,1)->(N,M)까지 최단경로 이동. 
 * 시작칸도 포함해서 센다. 벽을 한 개 까지 부수고 이동하여도 된다.불가능할 때는 -1을 출력
 * 
 * Error -> 벽을 뿌시기 전과, 벽을 뿌신 후 를 나눠 생각해야한다. -> 막다른길에서 부시는게 아니라, 쭉 길을 따라 부셔보고 탐색 해봐야한다. 
 * 방문배열 2개 써야하는건 어떻게 생각해 냈지??? -> 부시고 바로 온 경우, 부시지 않고 돌아온 경우 존재 할 수 있다.
 * 
 */
public class Main {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][][] visit;
	static int N;
	static int M;

	static class Position {
		int r, c, cnt, flag;

		public Position(int r, int c, int cnt, int flag) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.flag = flag;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", cnt=" + cnt + ", flag=" + flag + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M][2];// 벽을 부수지 않고 도착한 경우:0, 벽을 부수고 도착한 경우:1 구분

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
//		System.out.println(Arrays.deepToString(map));
		BFS(0, 0, N - 1, M - 1);
			

	}

	private static void BFS(int r, int c, int Er, int Ec) {
		Queue<Position> Q = new LinkedList<Position>();
		Q.offer(new Position(r, c, 1, 0));
		visit[r][c][0] = true;

		while (!Q.isEmpty()) {
			Position p = Q.poll();

			// 도착
			if (p.r == Er && p.c == Ec) {
				System.out.println(p.cnt);
				return;
			}

			// 도착하지 못했다면 다음칸으로 이동
			for (int i = 0; i < 4; i++) {
				int dx = p.r + dr[i];
				int dy = p.c + dc[i];
				int breaked = p.flag;// 안 부순경우 :0, 부순 경우 :1

				// 지도 밖으로 나갔다면 Q에 있는 다음 elements를 poll한다.
				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					
					
					// 안부수고 가는 경우
					if (map[dx][dy] == 0 && !visit[dx][dy][breaked]) {
						visit[dx][dy][breaked] = true;
						Q.offer(new Position(dx, dy, p.cnt + 1, breaked));
					}

					// 벽을 부수고 가는 경우 - 부순적이 없는 경우에만 //&& !visit[dx][dy][1]????
					if (map[dx][dy] == 1 && breaked==0 ) {
//						visit[dx][dy][1] = true;//제일 처음 부순것.//한개만 부시니까
						Q.offer(new Position(dx, dy, p.cnt + 1, 1));
					}
					
				}

			}
		}
		System.out.println(-1);
	}
}
