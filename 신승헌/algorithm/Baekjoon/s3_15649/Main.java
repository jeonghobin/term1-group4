package algo.bj.s3_15649;

import java.io.*;
import java.util.*;

/*
 * 중복 x
 * 순서 상관 있음
 * -> 순열
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 자연수 최대 값
		int M = Integer.parseInt(st.nextToken()); // 구할 수열 길이

		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;

		}

		recursive(arr, new boolean[N], new int[M], 0);

	}

	// 배열, 선택 여부, 선택된 숫자 선택된 숫자 인덱스
	private static void recursive(int[] arr, boolean[] v, int[] select, int sIdx) {
		// basis part
		// select가 모두 가득 찬 경우 
		if (sIdx == select.length) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}

		// inductive part
		for (int i = 0; i < arr.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				select[sIdx] = arr[i];
				recursive(arr, v, select, sIdx + 1);
				v[i] = false;
			}
		}
	}
}
