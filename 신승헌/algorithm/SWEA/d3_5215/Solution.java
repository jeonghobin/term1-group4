package algo.swea.d3_5215;

import java.io.*;
import java.util.*;

public class Solution {
	static int maxTaste;  
	static int L;
	static int CNT = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
		    L = Integer.parseInt(st.nextToken()); // 제한 칼로리
		    maxTaste = 0;
			
		    
			int[] taste = new int[N];
			int[] cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				recursive(cal, new int[i], new int[i], 0, 0, taste);
			}
			
			System.out.println("#" + test_case + " " + maxTaste);
//			System.out.println(CNT);
			
		} // [E] test_case for
	}

	private static void recursive(int[] cal, int[] sel, int[] sel2, int idx, int sIdx, int[] taste) {
		// basis part
		if (sIdx == sel.length) {
			int addCal = 0;
			int addTaste = 0;
			for (int i = 0; i < sel.length; i++) {
				int nowCal = sel[i];
				if (addCal + nowCal <= L) {
					addCal = addCal + nowCal;
					addTaste += sel2[i];
				} else {
					break;
				}
			}
			if (maxTaste < addTaste) {
				maxTaste = addTaste;
			}
			CNT++;
//			System.out.println(Arrays.toString(sel));
			return;
			
			
		}
		
		// inductive part
		for (int i = idx; i < cal.length; i++) {
			sel[sIdx] = cal[i];
			sel2[sIdx] = taste[i];
			recursive(cal, sel, sel2, i + 1, sIdx + 1, taste);
		}
	}
}
