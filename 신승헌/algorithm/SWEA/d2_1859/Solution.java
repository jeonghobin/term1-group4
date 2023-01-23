package homwork.SWEA.d2_1859;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d2_1859/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] price = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			long maxPrice = price[price.length - 1];
			long count = 0l;
			long total = 0l;
			long answer = 0l;
			
			for (int i = price.length - 2; i >= 0 ; i--) {
				if (i == 0 && price[i] < maxPrice) {
					count += 1;
					total += price[i];
					answer += count * maxPrice - total;
					
				} else if (price[i] > maxPrice) {
					answer += count * maxPrice - total;
					maxPrice = price[i];
					total = 0;
					count = 0;
				} else if (price[i] < maxPrice) {
					count += 1;
					total += price[i];
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb);
		
		
	}
}
