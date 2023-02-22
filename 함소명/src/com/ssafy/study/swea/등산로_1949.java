package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.
 * 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능
 * 필요한 경우 지형을 깎아 높이를 1보다 작게 만드는 것도 가능
 * 가장 긴 등산로
 * 
 * 접근 -> 쭉 내려가다가 높거나 같은 것을 만나면 1~k 만큼 깍아 나가면서 높거나 같은것을 찾는다. 
 */
public class 등산로_1949 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());//최대 깍을 수 있는 깊이.
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
		}
	}

}
