package com.ssafy.study.swea.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 오! 나의 여신님
 * 수연이의 위치는 ‘S’, 여신의 공간은 ‘D’, 돌의 위치는 ‘X’, 악마는 ‘*’로 주어진다.
 * 안전 지역에 도달하는 최소 시간 = 최단거리 DFS
 * "악마의 손아귀" 스킬은 매 초마다 상하좌우 인접해있는 영역들을 부식시키며 확장
 */

public class D5_7793 {

	static char[][] map;
	static int N;
	static int M;
	static int cnt;
	static boolean success;
	static Stack<Position> move;
	static Queue<Position> devil;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static class Position {
		int r, c = 0;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			move = new Stack<Position>();
			devil = new LinkedList<Position>();
			map = new char[N][M];
			success = false;
			cnt = 0;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					
					// 수연이 현재 위치
					if(map[i][j]=='S') move.push(new Position(i, j));
					if(map[i][j]=='*') devil.offer(new Position(i, j));
				}
			}

			BFS();

			if (success)
				System.out.println("#" + test_case + " " + cnt);
			else
				System.out.println("#" + test_case + " " + "GAME OVER");

		}
	}

	private static void BFS() {
		
		L : while (!move.isEmpty()) {
			Position p = move.pop();
			
			//수연 움직임
			for (int j = 0; j < 4; j++) {
				int dx = p.r + dr[j];
				int dy = p.c + dc[j];

				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					//여신을 만나면 끝
					if(map[dx][dy] == 'D') {
						cnt++;
						success = true;
						break L;
					}
					
					if (map[dx][dy] == '.') {
						cnt++;
						//'.'왔던길 되돌려주기 하면 시간초과
						//'-'로 갔다 왔음 표시
						map[p.r][p.c] = '-';//방문함.
						map[dx][dy] = 'S';//현재 위치 표시
						move.push(new Position(dx, dy));
					}
				}
			}
			
			//악마 하나하나 영역 확장
			for (int i = 0; i < devil.size(); i++) {
				Position d = devil.poll();
				for (int j = 0; j < 4; j++) {
					int dx = d.r + dr[j];
					int dy = d.c + dc[j];

					if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
						if (map[dx][dy] == '.'||map[dx][dy] == '-') {
							map[p.r][p.c] = 'X';//방문함.
							map[dx][dy] = '*';
							devil.offer(new Position(dx, dy));
						}
						
						//만약 악마가 수연이 만나면 게임 종료
						if (map[dx][dy] == 'S') {
							map[dx][dy] = '*';
							break L;
						}
					}
				}
			}
			
			System.out.println(Arrays.deepToString(map));
		}
	}
}
