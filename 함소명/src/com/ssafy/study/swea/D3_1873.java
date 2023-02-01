package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//상호의 배틀필드
public class D3_1873 {

//문자	의미
//.	평지(전차가 들어갈 수 있다.)
//*	벽돌로 만들어진 벽
//#	강철로 만들어진 벽
//-	물(전차는 들어갈 수 없다.)
//^	위쪽을 바라보는 전차(아래는 평지이다.)
//v	아래쪽을 바라보는 전차(아래는 평지이다.)
//<	왼쪽을 바라보는 전차(아래는 평지이다.)
//>	오른쪽을 바라보는 전차(아래는 평지이다.)
//	문자	동작
//	U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//	D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//	L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//	R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//	S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다. 
	// 전차가 포탄을 발사하면,
	// 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가된다.
	// 강철로 만들어진 벽에 포탄이 부딪히거나, 포탄이 맵 밖으로 나가면 아무 일도 일어나지 않는다.
//모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지???
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] dir = { -1, 1, -1, 1 };// up,down,left,rigth

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer with = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(with.nextToken());
			int W = Integer.parseInt(with.nextToken());

			String[][] map = new String[H][W];

			for (int i = 0; i < H; i++) {
				StringTokenizer inputMap = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = inputMap.nextToken();
					if (map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<")
							|| map[i][j].equals(">")) {
						Location loc = new Location(0, i, j);
						if (map[i][j].equals("^"))
							loc.setDirection(0);
						if (map[i][j].equals("v"))
							loc.setDirection(1);
						if (map[i][j].equals("<"))
							loc.setDirection(2);
						if (map[i][j].equals(">"))
							loc.setDirection(3);
					}
				}
			}

			int M = Integer.parseInt(br.readLine());
			String[] move = new String[M];
			StringTokenizer inputMove = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				move[i] = inputMove.nextToken();
				//.	평지(전차가 들어갈 수 있다.)
				//*	벽돌로 만들어진 벽
				//#	강철로 만들어진 벽
				//-	물(전차는 들어갈 수 없다.)
//				U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//				D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//				L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//				R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//				S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다. 
				if(move[i].equals("U")) {
					
					
				}
				
			}
			
			for (int i = 0; i < M; i++) {
				move[i] = inputMove.nextToken();
			}
			
			

		}

	}

}

class Location {
	int direction;
	int currentX;
	int currentY;

	public Location(int dir, int x, int y) {
		// TODO Auto-generated constructor stub
		this.direction = dir;
		this.currentX = x;
		this.currentY = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}
}
