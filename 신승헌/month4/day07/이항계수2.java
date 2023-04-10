package day07;

import java.io.*;
import java.util.*;

// 이항 계수로 풀어야 함
public class 이항계수2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		long[][] arr = new long[N + 1][N + 1];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				// 삼각형의 왼쪽 끝을 1로 지정
				if (j == 0) {
					arr[i][j] = 1;
				}

				// 삼각형의 오른쪽 끝을 1로 지정
				else if (i == j) {
					arr[i][j] = 1;
				}

				// 도출한 점화식을 적용
				else {
					if (i - j >= j) {						
						arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j] % 1000000007);
					} else {
						arr[i][j] = arr[i][i-j];
					}
				}
			}
		}

		System.out.println(arr[N][R]);

	} // [E] test_case

}
