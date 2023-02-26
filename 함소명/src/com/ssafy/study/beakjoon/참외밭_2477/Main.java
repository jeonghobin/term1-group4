package com.ssafy.study.beakjoon.참외밭_2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참외밭
//회전에 따른 넓이 구하는 법 -> 가장 큰 사각형 - 작은 사각형
//1.가장 긴 가로와 세로의 길이를 구한다.
//반시계 방향
//2.가장 긴 가로 옆-> 두 세로의 길이 차이가 빈 사각형의 세로가 된다.
//3.가장 긴 세로 옆-> 두 가로의 길이 차이가 빈 사각형의 가로가 된다.
public class Main {
	public static int maxX = 0;
	public static int maxY = 0;
	public static int[] lenList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 참외 개수
		lenList = new int[6];

		int idX = 0, idY = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			lenList[i] = len;

			if ((dir == 1 || dir == 2) && maxX < len) {// 동.서(가로)
				maxX = Math.max(maxX, len);
				idX = i;
			}else if ((dir == 3 || dir == 4) && maxY < len) {// 남.북(세로)
				maxY = Math.max(maxY, len);
				idY = i;
			}
		}

		// 작은 세로 구하기
		int index = lenList[gubun(idX - 1)];
		int index2 = lenList[gubun(idX + 1)];
		int minX = Math.abs(index2 - index);
//		System.out.println(minX);

		// 작은 가로 구하기
		index = lenList[gubun(idY - 1)];
		index2 = lenList[gubun(idY + 1)];
		int minY = Math.abs(index2 - index);
//		System.out.println(minY);

		int minWide = minX * minY;

		int wide = ((maxX * maxY) - minWide) * N;
		System.out.println(wide);
	}

	static int gubun(int num) {
		if (num == 6)
			num = 0;
		if (num == -1)
			num = 5;

		return num;
	}

}
