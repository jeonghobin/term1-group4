package algo.swea.d3_6808;

import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] v;
	static int win;
	static int lose;
	static int[] gu;
	static int[] min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); 
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			gu = new int[9];
			min = new int[9]; 
			
			v = new boolean[18 + 1];
			
			// gu card
			int _count = 0;
			while (st.hasMoreTokens()) {
				gu[_count] = Integer.parseInt(st.nextToken());
				v[gu[_count]] = true;
				_count++;
			}
			
			// min card
			_count = 0;
			for (int i = 1; i < v.length; i++) {
				if(v[i] == false) {
					min[_count] = i;
					_count++;
				}
			}
			
			win = 0;
			lose = 0;
			
			
			recursive(min, new int[9], new boolean[9], 0);
			
			
			System.out.println("#" + test_case + " " + win + " " + lose);
			
 			
			
			

		} // [E] test_case
	}

	private static void recursive(int[] arr, int[] sel, boolean[] v, int sIdx) {
		// basis part
		if (sel.length == sIdx) {
			int guWin = 0;
			int minWin = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] < gu[i]) {
					guWin += sel[i] + gu[i];
				} 
				
				if (sel[i] > gu[i]){
					minWin += sel[i] + gu[i];
				}
			}
			if (guWin > minWin) win++;
			if (guWin < minWin) lose++;
			return;
		}
		
		// inductive part
		for (int i = 0; i < arr.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[sIdx] = arr[i];
				recursive(arr, sel, v, sIdx + 1);
				v[i] = false;
			}
		}
	}
}
