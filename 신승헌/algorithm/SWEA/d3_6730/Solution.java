package homwork.SWEA.d3_6730;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_6730/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[] block = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < block.length; i++) {
				block[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxUp = 0;
			int maxDown = 0;
			
			for (int i = 0; i < block.length -1; i++) {
				int nowUp = 0;
				int nowDown = 0;
				if (block[i] > block[i + 1]) {
					nowDown = block[i] - block[i + 1];
					
					if (maxDown < nowDown) {
						maxDown = nowDown;
					}
				}
				
				if (block[i] < block[i + 1]) {
					nowUp = block[i + 1] - block[i];
					
					if (maxUp < nowUp) {
						maxUp = nowUp;
					}
				}	
			}
			sb.append("#" + test_case + " " + maxUp + " " + maxDown + "\n");
		}
		System.out.println(sb);
	}
}
