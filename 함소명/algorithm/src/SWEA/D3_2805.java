package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//2805. 농작물 수확하기
public class D3_2805 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
		

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j)-'0';//숫자 문자열을 숫자로
				}
			}

			int start = N / 2;
			int end = N / 2;

			int sum = 0;
			int center = N / 2;
			for (int i = 0; i < N; i++) {
			
				for (int j = start; j <= end; j++) {
					sum += arr[i][j];
				}

				if (i < center) {
					start = start - 1;
					end = end + 1;
				} else {
					start = start + 1;
					end = end - 1;
				}					

			}

			System.out.println("#" + test_case + " " + sum);
		}
	}
}
