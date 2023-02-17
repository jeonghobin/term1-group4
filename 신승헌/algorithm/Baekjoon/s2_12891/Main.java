package algo.bj.s2_12891;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken()); // 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 뽑을 비밀번호 길이

		st = new StringTokenizer(br.readLine());
		String[] data = st.nextToken().split("");

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // A C G T
		}
		
		int answer = 0;

		// 초기 문장
		int[] arrNow = new int[4];
		int minusIdx = 0;
		for (int i = 0; i < P; i++) {

			if (data[i].equals("A")) {
				arrNow[0]++;
			}
			if (data[i].equals("C")) {
				arrNow[1]++;
			}
			if (data[i].equals("G")) {
				arrNow[2]++;
			}
			if (data[i].equals("T")) {
				arrNow[3]++;
			}

			if (i == P - 1) {
				for (int j = 0; j < arrNow.length; j++) {
					if (arr[j] > arrNow[j]) {
						break;
					}

					if (j == arrNow.length - 1) {
						answer += 1;
					}
				}
			}

		}

		// 반복
		for (int i = P; i < S; i++) {
			// 이전 비밀번호의 가장 앞의 값 빼기
			if (data[minusIdx].equals("A")) {
				arrNow[0]--;
			}
			if (data[minusIdx].equals("C")) {
				arrNow[1]--;
			}
			if (data[minusIdx].equals("G")) {
				arrNow[2]--;
			}
			if (data[minusIdx].equals("T")) {
				arrNow[3]--;
			}
			minusIdx += 1;

			if (data[i].equals("A")) {
				arrNow[0]++;
			}
			if (data[i].equals("C")) {
				arrNow[1]++;
			}
			if (data[i].equals("G")) {
				arrNow[2]++;
			}
			if (data[i].equals("T")) {
				arrNow[3]++;
			}

			for (int j = 0; j < arrNow.length; j++) {
				if (arr[j] > arrNow[j]) {
					break;
				}

				if (j == arrNow.length - 1) {
					answer += 1;
				}
			}
		}

		System.out.println(answer);
	}
}
