package algo.bj.s5_2167;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] S = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				S[i][j] = S[i][j-0] + Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			for (int r = startX; r <= endX; r++) {
				for (int c = startY; c <= endY; c++) {
					answer += S[r][c];
				}
			}
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
		
	}
}
