package algo.swea.d3_5215;

import java.io.*;
import java.util.*;

/*
 * 부분 집합
 */

public class Solution2 {
	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int maxTaste;
	static int[] taste;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
		
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			taste = new int[N];
			int[] cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			maxTaste = 0;
			recursive(cal, new boolean[N], 0, 0);
			System.out.println("#" + test_case + " " + maxTaste);
			
		} // [E] test_case
	}

	private static void recursive(int[] cal, boolean[] v, int idx, int k) {
		// basis part
		if (idx == cal.length) {
			int nowTaste = 0;
			int nowCal = 0;
			for (int i = 0; i < v.length; i++) {
				if(v[i] == true) {
					if (nowCal + cal[i] <= L) {
						nowCal = nowCal + cal[i];
						nowTaste += taste[i];
					}
				}
			}
			if (maxTaste < nowTaste) {
				maxTaste = nowTaste;
			}
			return;
		}
		
		
		// inductive part
		v[idx] = true;
		recursive(cal, v, idx+1, k+1);
		
		v[idx] = false;
		recursive(cal, v, idx+1, k);
		
	}
}
