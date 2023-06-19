package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleEatGame_Re {
	static int N, Ans, minCnt, MaxApple;
	static int[][] map;
	// 오른쪽으로 가다 회전(0), 아래로 가다 회전(1), 왼쪽으로 가다 회전(2), 위로 가다 회전(3)
	// 오,아,왼,위 아,왼,위,오 왼,위,오,아 위,오,아,왼
	// 오,아,왼,위
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	// 시작위치는 좌측상단 고정
	// 오직 오른쪽으로만 회전가능, 90도씩 회전가능, 한자리에서는 한번만 회전 가능, 사과를 먹음과 동시에 회전 가능
	// 사과를 다 먹으려면 최소 몇번의 회전이 필요한가?
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			MaxApple = 0;
			Ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						MaxApple = Math.max(map[i][j], MaxApple);
				}
			}

			// r,c,cnt,dir,apple
			recursive(0, 0, 0, 0, 1);

			System.out.println("#" + testCase + " " + Ans);
		}

	}

	private static void recursive(int r, int c, int cnt, int dir, int apple) {
		if (MaxApple == apple-1) {
			Ans = Math.min(cnt, Ans);
			return;
		}

		int nr = r + dr[dir];
		int nc = c + dc[dir];

		int d = (dir + 1) % 4;
		// 90도 꺽어서 검사해보고 사과가 있으면 꺽는다, 벽을 만나면 꺽는다.
		if ((nr < 0 || nr >= N || nc < 0 || nc >= N)||check(r,c,d,apple)) {
			recursive(r, c, cnt + 1, d, apple);
			return;//***********리턴이 없으면 안됨.
		}
		

		// 사과 있으면 먹기
		if (map[r][c] == apple) {
			recursive(r, c, cnt, dir, apple + 1);
		}else// 없으면 지나간다.
			recursive(nr, nc, cnt, dir, apple);

	}

	private static boolean check(int r, int c, int dir, int apple) {
		int nr = r;
		int nc = c;
		while(nr>=0&&nr<N&&nc>=0&&nc<N) {
			nr+=dr[dir];
			nc+=dc[dir];
			if((nr>=0&&nr<N&&nc>=0&&nc<N)&&map[nr][nc]==apple) {
				return true;
			}
		}
		return false;
	}

}
