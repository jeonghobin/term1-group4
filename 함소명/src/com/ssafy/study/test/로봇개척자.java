package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇개척자 {

	static int N, M, MaxgetCnt, getCnt;
	static Ground[][] map, copymap;
	// 오,위,왼,아
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	static class Ground {
		int state;// 빈상태 0, 산 1, 씨심음 2, 새싹이남 3(안해주면 안됨...ㅠㅠ), 열매맺힘 4
		int K;// 씨 몇번 심었는지
		int day = 0;// 싹이 트고 지난 날
		int Dday = 0;// 열매를 맺을 날

		public void init() {
			state = 0;
			K = 1;//시작은 1번째로 싹이남!!!!!!!!!!!!!
			day = 0;
			Dday = 0;
		}

		@Override
		public String toString() {
			return "Ground [state=" + state + ", K=" + K + ", day=" + day + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());// 날짜
			MaxgetCnt = 0;
			map = new Ground[N][N];
			copymap = new Ground[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = new Ground();
					map[i][j].state = num;
					copymap[i][j] = new Ground();
					copymap[i][j].state = num;
				}
			}

			// 지형의 테두리는 언제나 산이다
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					// 초기 방향
					if (copymap[i][j].state == 1)
						continue;

					for (int dir = 0; dir < 4; dir++) {
						getCnt = 0;
						DAY(i, j, dir);
						MaxgetCnt = Math.max(MaxgetCnt, getCnt);
						initGround(); // 맵 원복 (초기화)
					}

				}
			}

//			DAY(3,3,2);
			System.out.println("#" + testCase + " " + MaxgetCnt);
		}
	}

	private static void initGround() {
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				map[i][j].init();
				map[i][j].state = copymap[i][j].state;
			}
		}
	}

	private static void DAY(int r, int c, int dir) {
		int nr = -1;
		int nc = -1;
		int d = dir;
		for (int day = 0; day < M; day++) {
			// 전진이 가능한지 먼저 확인
			boolean isMove = false;
			// 오,위,왼,아 순으로 가능한지 확인
			// 제자리에서 꺽어야한다 2->1->0->3->2
			for (int i = 0; i < 4; i++) {
				d = (i + dir + 3) % 4;// 절대방향 보정, -1을 해주는게아니라 +3을 해줘 똑같은 효과를 보자
				nr = r + dr[d];
				nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (map[nr][nc].state == 0 || map[nr][nc].state == 4) {
					isMove = true;
					break;
				}
			}

//		1) 로봇은 오전에 현재 위치에서 아래의 작업 중 하나를 수행한다.
//		- 현재 농지가 빈 농지이고 로봇이 다음 농지로 이동할 수 있는 경우 씨를 심는다.
			if(isMove && map[r][c].state==0) {
				map[r][c].state = 2;
			}
		
//		- 현재 농지가 빈 농지이고, 로봇이 다음 농지로 이동할 수 없을 경우 아무것도 하지 않고 현재 위치에서 머무른다.
//			if(map[r][c].state==0 &&!isMove) //아무것도하지 않음.
//		- 현재 농지에 곡식이 열린 경우 수확을 한다. 수확을 하면 농지는 빈 농지가 된다.
			else if(map[r][c].state==4) {
				getCnt++;
				map[r][c].state = 0;
			}

			// 움직일 수 있으니 움직인다.
			if(isMove) {
				r = nr;
				c = nc;
				dir = d;
			}

			//다음날이 넘어갈때
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if(map[i][j].state==2){//씨를 심은 경우
						map[i][j].state = 3;//다음날 싹이 난다.
						map[i][j].Dday = map[i][j].K+3;//열매를 맞을 날
						map[i][j].K++;//해당 자리에서 싹이 난 경우를 카운트한다.
					}else if(map[i][j].state == 3) {//싹이 난 경우 
						//싹이 자라나는 일수를 더해줘야한다.
						map[i][j].day++;
						if(map[i][j].day==map[i][j].Dday) {
							map[i][j].state = 4;//열매가 맺음
							map[i][j].day = 0;//초기화
						}
					}
					
					
				}
			}

		}
	}

}
