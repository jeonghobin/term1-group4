package com.ssafy.study.beakjoon.beak_2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참외밭
class Direction {
	int dir;
	int len;

	public Direction(int dir, int len) {
		super();
		this.dir = dir;
		this.len = len;
	}
}

public class Main {

	// up,right,down,left
	int[] dc = { -1, 0, 1, 0 };
	int[] dr = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Direction[] dc = new Direction[T];
		for (int i = 0; i < dc.length; i++) {
			dc[i] = new Direction(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		DFS();
	}

	public static void DFS() {
		// TODO Auto-generated method stub

	}
}
