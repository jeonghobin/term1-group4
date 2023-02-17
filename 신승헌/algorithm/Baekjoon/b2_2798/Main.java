package algo.bj.b2_2798;

import java.io.*;
import java.util.*;

/*
 * 블랙잭
 * 중복 x, 순서 x 
 * -> 조합
 */
public class Main {
	static int max = 0;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		recursive(arr, new int[3], 0, 0);
		
		System.out.println(max);
		
		 
	} // [E] main

	private static void recursive(int[] arr, int[] sel, int idx, int sIdx) {
		// basis part
		if (sIdx == sel.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			
			if (sum <= M && sum > max) {
				max = sum;
			}
			
			return;
		}
		
		// inductive part
		for (int i = idx; i < arr.length; i++) {
			sel[sIdx] = arr[i];
			recursive(arr, sel, i + 1, sIdx + 1);
		}
		
		
	}
}
