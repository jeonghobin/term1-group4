package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Subway_solution {
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
							if(d+N-1 == a)continue;//a,d가 인접하면 해가 될 수 없다.
							//타당도 값을 구해서 최댓값 업데이트
							int val = mul(a,b)+mul(c,d);
							if(maxVal < val) maxVal = val;
							val = mul(a,d)+mul(c,b);
							if(maxVal < val) maxVal = val;
						}
					}
				}
			}
			
			System.out.println("#" + testCase + " " + maxVal);
		}

	}

	private static int mul(int a, int b) {
		int temp = num[a]+num[b];
		
		return temp*temp;
	}
}
