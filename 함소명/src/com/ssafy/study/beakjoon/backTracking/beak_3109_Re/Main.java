package com.ssafy.study.beakjoon.backTracking.beak_3109_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 빵집
 * 빵집이 있는 곳은 R*C 격자로 표현할 수 있다. 첫째 열은 근처 빵집의 가스관이고, 마지막 열은 원웅이의 빵집
 * 건물이 있는 경우에는 파이프를 놓을 수 없다. 파이프라인 최대 개수는?
 * 접근 -> 깊이 우선 탐색 DFS
 * 열 0에 행 쭉 시작점 - 열 c에 행 쭉 마침점
 * 방문배열 굳이 처리하지 않아도됨.
 * 방향이 한방향으로 쭉 가야함. 파이브가 설치되면 방문처리.
 * flag?? 속도향상?
 */
public class Main {
	static int[][] map;
	static  int R,C;
	static int Ans = 0;
	// 우상, 우, 우하
	static int [] dr= {-1,0,1};
	static int [] dc= {1,1,1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			String str = sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c]=str.charAt(c);
			}
		}
		
		for (int r = 0; r < R; r++) {
			flag = false;
			solve(r,0);
		}
		
		//print(map);
		System.out.println(Ans);
	}
	
	private static void solve(int r, int c) {
		// 속도향상
		if(flag) {
			return;
		}
		// c -> C 까지 가보자
		// basis part
		if(c==C-1) {
			Ans++;
			flag = true;
			return;
		}
		
		// inductive part
		for (int d = 0; d < 3; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0&&nr<R&&nc>=0&&nc<C&&map[nr][nc]=='.'&&!flag) {
				map[nr][nc]='x';
				solve(nr,nc);
				
			}
		}
	}
}
