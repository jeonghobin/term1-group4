package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleEatGame {
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
						MaxApple =Math.max(map[i][j], MaxApple);
				}
			}

			//r,c,dir,cnt,apple
			recursive(0,0,0,0,1);

			System.out.println("#" + testCase + " " + Ans);
		}

	}

	private static void recursive(int r, int c, int d, int cnt, int apple) {
		if (apple-1 == MaxApple) {
		    Ans = Math.min(cnt, Ans);
		    return;
		}

		
		int nr = r+dr[d];
		int nc = c+dc[d];
		
		//1.90도 꺽은 방향에 사과가 있으면 회전
		//2.벽을 만나면 회전
		if(check(r,c,d,apple)||(nr<0||nr>=N||nc<0||nc>=N)) {
			int nd = (d+1)%4;
			recursive(r, c, nd, cnt+1, apple);
			return;
		}
		
		//1. 사과를 만난경우
		if(map[r][c]==apple) {
			recursive(r, c, d, cnt, apple+1);
		//2. 사과가 없는 경우 갈길가기
		} else recursive(nr, nc, d, cnt, apple);
		
		
	}

	private static boolean check(int r, int c, int d, int apple) {
		d = (d+1)%4;
		while (r>=0&&r<N&&c>=0&&c<N) {
			
			r+=dr[d];
			c+=dc[d];
			
			if(r>=0&&r<N&&c>=0&&c<N) {
				if(map[r][c]==apple) return true;
			}
		}
		
		return false;
	}

	
}
