package month3.day01;

import java.io.*;
import java.util.*;

public class 이분탐색_수찾기1920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 비교 대상 숫자 개수
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 존재 여부 확인 할 숫자 개수

		int answer;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int checkNum = Integer.parseInt(st.nextToken());
			answer = 0;

			int start = 0; // 배열의 시작 위치
			int end = arr.length - 1; // 배열의 끝 위치

			while (start <= end) {
				int mid = (start + end) / 2; // 배열의 중간 위치

				// 찾으려는 값보다 배열에 들어가 있는 값이 더 작다면
				if (checkNum > arr[mid]) {
					start = mid + 1;
				}

				// 찾으려는 값보다 배열에 들어가 있는 값이 더 크다면
				if (checkNum < arr[mid]) {
					end = mid - 1;
				}

				// 찾으려는 값과 배열에 들어간 값이 같다면
				if (checkNum == arr[mid]) {
					end = arr[mid];
					answer = 1;
					break;
				}

			}
			System.out.println(answer);

		}

	}
}
