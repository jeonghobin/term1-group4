package com.ssafy.study.beakjoon.backTracking.beak_2580_Re;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 스도쿠
 * 시작점 : (n/3)*3 //0,1,2 3,4,5 6,7,8
 * 백트래킹 -> 숫자를 차례대로 넣고 행 열 3*3 에 해당 숫자가 있는지 검사해본다. 
 * 내 생각 -> 격자판, 한 줄에서  0이 하나인 경우부터 찾아 숫자를 집어 넣는다.
 */

public class Main {
	static int[][] map;

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 0)
					list.add(new Point(r, c));
			}
		}
		// System.out.println(list.size());
		// print(map);
		solve(0);
	}

	// k : 빈좌표 index
	private static void solve(int k) {
		if (list.size() == k) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}

		int x = list.get(k).r;
		int y = list.get(k).c;

		for (int i = 1; i <= 9; i++) {
			if (check(x, y, i)) {
				map[x][y] = i;
				solve(k + 1);
				map[x][y] = 0;//왜??
			}
		}
	}

	/*
	 * 중복되는 값이 없으면 true; 아니면 false; 스토쿠 검증 - swea_1974
	 */
	public static boolean check(int r, int c, int num) {
		
		// 중복되는 값이 있는지
		// 가로 세로 검증
		for (int i = 0; i < 9; i++) {
			if(map[r][i]==num||map[i][c]==num) return false;
		}
		
		//3*3에 중복된 값이 있는지
		//속한 첫째 인덱스 추출
		int Sr = (r/3)*3;
		int Sc = (c/3)*3;
		for (int i = Sr; i < Sr+3; i++) {
			for (int j = Sc; j < Sc+3; j++) {
				if(map[i][j] == num) return false;
			}
		}

		return true;
	}
}
