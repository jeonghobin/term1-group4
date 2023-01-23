package homwork.SWEA.d3_6958;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_6958/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			int[][] personArray = new int[N][M];
			
			int maxSum = 0;
			int maxPerson = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int nowSum = 0;
				while (st.hasMoreTokens()) {
					nowSum += Integer.parseInt(st.nextToken());
				}
				
				if (nowSum == maxSum) {
					maxPerson += 1;
				}
				
				if (nowSum > maxSum) {
					maxSum = nowSum;
					maxPerson = 1;
				}
				
			}
			sb.append("#" + test_case + " " + maxPerson + " " + maxSum + "\n");
			
		}
		
		System.out.println(sb);
	}
}
