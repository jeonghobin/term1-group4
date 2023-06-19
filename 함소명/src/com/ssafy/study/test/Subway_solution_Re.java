package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Subway_solution_Re {
	private static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			num = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			int maxVal = 0;
			//정점 4개를 선택, 정점 사이가 인접하면 안된다.(조합)
			//타당도 값을 구해서 최댓갑 업데이트
			for (int a = 0; a < N-6; a++) {
				for (int b = a+2; b < N-4; b++) {
					for (int c = b+2; c < N-2; c++) {
						for (int d = c+2; d < N; d++) {
							//a와 d는 인접하면 안된다.
							if(a==(d+1)%N) continue;
							//타당도 구하기
							int value = (num[a]+num[b])*(num[a]+num[b])+(num[c]+num[d])*(num[c]+num[d]);
							maxVal = Math.max(maxVal, value);
							value = (num[a]+num[d])*(num[a]+num[d])+(num[c]+num[b])*(num[c]+num[b]);
							maxVal = Math.max(maxVal, value);
						}
					}
				}
			}
		
			System.out.println("#" + testCase + " " + maxVal);
		}

	}

}
