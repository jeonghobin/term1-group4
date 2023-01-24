package homework.Baekjoon.b1_2999;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String s = st.nextToken();
		
		int R = 0;
		int C = 0;
		
		char[][] matrix;
		
		// R, C 구하기
		for (int i = s.length(); i > 0; i--) {
			int tempC = s.length() / i;
			if (tempC * i == s.length() && tempC >= i) {
				R = i;
				C = tempC;
				break;
			}
		}
		matrix = new char[R][C];
		
		int idx = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				matrix[j][i] = s.charAt(idx);
				idx++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(matrix[i][j]);
			}
		}
		
		System.out.println(sb);
		
		
	}
}
