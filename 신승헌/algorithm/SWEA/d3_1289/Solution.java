package homwork.SWEA.d3_1289;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_1289/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			String[] original = st.nextToken().split("");
			int[] now = new int[original.length];
			int[] compare = new int[original.length];
			
			for (int i = 0; i < original.length; i++) {
				compare[i] = Integer.parseInt(original[i]);
				now[i] = 0;
			}
			
			int answer = 0;
			
			for (int i = 0; i < original.length; i++) {
				if (compare[i] == now[i]) {
					continue;
				} else {
					answer += 1;
					now[i] = compare[i];
					for (int j = i + 1; j < compare.length; j++) {
						now[j] += 1;
						now[j] %= 2;
					}
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb);
		
	}
}
