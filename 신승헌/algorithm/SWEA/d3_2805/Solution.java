package homwork.SWEA.d3_2805;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_2805/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] ground = new int[N][N];
			
			int answer = 0;
			
			for (int i = 0; i < ground.length; i++) {
				st = new StringTokenizer(br.readLine());
				
				String[] s = st.nextToken().split("");
				for (int j = 0; j < ground[i].length; j++) {
					ground[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			int mid = N / 2;
			
			if (N == 1) {
				answer = ground[0][0];
				sb.append("#" + test_case + " " + answer + "\n");
				continue;
			}
			
			// 가운데 위까지 반복
			for (int i = 0; i <= mid; i++) { // 행 반복
				
				for (int j = mid - i; j <= mid + i; j++) {
					answer += ground[i][j];
				}
			}
			
			for (int i = mid + 1; i < N; i++) { // 행 반복
				for (int j = i - mid; j < N - (i - mid); j++) {
					answer += ground[i][j];
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		
		System.out.println(sb);
		
	}
}
