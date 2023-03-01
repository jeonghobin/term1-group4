package month3.day01;

import java.io.*;
import java.util.*;

public class 이분탐색_기본 {
	public static void main(String[] args) throws Exception {
		int[] arr = {9, 1, 3, 5, 7, 8};

		Arrays.sort(arr); // 정렬

		int search = 8;

		int answer = 0; // 베열 내 있으면 1 없으면 0 반환
		int start = 0; // 배열의 시작 위치
		int end = arr.length - 1; // 배열의 끝 위치
		

		System.out.print("탐색 순서 : ");
		while (start <= end) {
			int mid = (start + end) / 2; // 배열의 중간 위치
			System.out.print(mid + " ");

			// 찾으려는 값보다 배열에 들어가 있는 값이 더 작다면
			if (search > arr[mid]) {
				start = mid + 1; // 현재 중간 값보다 오른쪽에 있다는 뜻
			}

			// 찾으려는 값보다 배열에 들어가 있는 값이 더 크다면
			if (search < arr[mid]) {
				end = mid - 1; // 현재 중간 값보다 왼쪽에 있다는 뜻
			}

			// 찾으려는 값과 배열에 들어간 값이 같다면
			if (search == arr[mid]) {
				end = arr[mid];
				answer = 1;
				break;
			}

		}
		System.out.println();
		System.out.println(answer); // 1

	}
}