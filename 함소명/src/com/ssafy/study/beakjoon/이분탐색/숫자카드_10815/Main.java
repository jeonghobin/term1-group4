package com.ssafy.study.beakjoon.이분탐색.숫자카드_10815;

import java.io.*;
import java.util.*;

//숫자 카드
//이분 탐색 사용
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		st = new StringTokenizer(br.readLine());
		int N2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr2 = new int[N2];
		for (int i = 0; i < N2; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());

			// 중간 값보다 크다면 +1, 작다면 -1
			int start = 0;
			int end = N - 1;
			int mid = 0;

			int num = 0;
			while (start <= end) {
				mid = (start + end) / 2;

				if (arr[mid] < arr2[i]) { // 중간값보다 크다면
					start = mid + 1;
				} else if (arr[mid] > arr2[i]) { // 중간값보다 작다면
					end = mid - 1;
				} else { // 중간값과 같다면
					num = 1;
					break;
				}
			}
			// m이 없는 경우
			arr2[i] = num;
		}

		// 시간복잡도 O(n2) 시간초과
//		for (int i = 0; i < arr2.length; i++) {
//			int num = 1;
//			for (int j = 0; j < arr1.length; j++) {
//				if(arr2[i]==arr1[j]) {
//					num = 0;
//					break;
//				}
//			}
//			arr2[i] = num;
//		}

		for (int j : arr2) {
			System.out.print(j + " ");
		}

	}
}
