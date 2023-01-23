package homwork.SWEA.d2_1940;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d2_1940/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int totalSpeed = 0;
			int totalDistance = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int speedControl = Integer.parseInt(st.nextToken());
				int addSpeed = 0; // 가감속도
				
				if (speedControl == 1) {
					addSpeed = Integer.parseInt(st.nextToken());
					
				} else if (speedControl == 2) {
					addSpeed = 0 - Integer.parseInt(st.nextToken());
				}
				
				totalSpeed += addSpeed;
				if (totalSpeed <= 0) {
					totalSpeed = 0;
				}
				totalDistance = totalDistance + totalSpeed;
			}
			
			sb.append("#" + test_case + " " + totalDistance + "\n");
		}
		System.out.println(sb);
	}
}
