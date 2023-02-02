package com.ssafy.study.beakjoon.beak_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


// 다시!!!!
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] arrN = new int[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arrN);

		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st3.nextToken());

		StringTokenizer st4 = new StringTokenizer(br.readLine());
		int[] arrM = new int[M];
		for (int i = 0; i < N; i++) {
			arrM[i] = Integer.parseInt(st4.nextToken());
		}
		Arrays.sort(arrM);

		
		for (int i = 0; i < arrM.length; i++) {
			int start = 0;
			int end = N - 1;
			int cnt = 0;
			int mid = N / 2;

			while (start <= end) {
				mid = (start + end) / 2;

				if (arrN[mid] > arrM[i]) {// 중간 위치 값이 비교값 보다 크면 start 위치의 값 +1
					start = mid + 1;
				} else if (arrN[mid] < arrM[i]) {// 중간 위치 값이 비교값 보다 작으 end 위치의 값 -1
					end = mid - 1;
				}else {
					cnt = 1;
					break;
				}
				
			}
			arrM[i] = cnt;
		}

		System.out.println(Arrays.toString(arrM));
	}

}
