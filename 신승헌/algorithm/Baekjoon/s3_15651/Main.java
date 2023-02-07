package algo.bj.s3_15651;

import java.io.*;
import java.util.*;

/*
 * 중복 가능
 * 순서 상관 없음
 * 중복 순열
 */
public class Main {
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 자연수 최대
		int M = Integer.parseInt(st.nextToken()); // 수열 길이
		
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			
		}
		
		recursive(arr, new int[M], 0);
		
		System.out.println(sb);
		
	}

	private static void recursive(int[] arr, int[] select, int sIdx) {
		// basis part
		if (sIdx == select.length) {
			for (int i = 0; i < select.length; i++) {
				sb.append(select[i] + " ");
				
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			select[sIdx] = arr[i];
			recursive(arr, select, sIdx + 1);
			
		}
		
	}
}
