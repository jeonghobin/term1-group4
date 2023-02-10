package algo.swea.d2_2001;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 파리채 크기
			
			int max = 0;
			
			int[][] map = new int[N+1][N+1];
			for (int i = 1; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < map[i].length; j++) {
					map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
				}
			}
			
			int now;
			
			for (int i = 1; i <= N - M + 1; i+=1) {
				
				for (int j = 1; j <= N - M + 1; j++) {
					now = 0;
					for (int k = 0; k < M; k++) {
						now += map[i+k][j+M-1] - map[i+k][j-1];
					}
					if (now > max) {
						max = now;
					}
				}

			}
			
			System.out.println("#" + test_case + " " + max);
			
			
		} // [E] test_case
	}
}
