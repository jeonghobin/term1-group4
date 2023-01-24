package homwork.SWEA.d2_1974;

import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[][] sudoku = new int[9][9];
			
			for (int i = 0; i < sudoku.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < sudoku[i].length; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 1;
			
			for (int i = 0; i < sudoku.length; i++) {
				int[] check = new int[10];
				for (int j = 0; j < sudoku[i].length; j++) {
					check[sudoku[i][j]] += 1;
					if (check[sudoku[i][j]] > 1) {
						answer = 0;
					}
				}
			}
			
			for (int i = 0; i < sudoku.length; i++) {
				int[] check = new int[10];
				for (int j = 0; j < sudoku[i].length; j++) {
					check[sudoku[j][i]] += 1;
					if (check[sudoku[j][i]] > 1) {
						answer = 0;
					}
				}
			}
			
			if (answer != 0) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int X = i * 3;
						int Y = j * 3;
						int[] check = new int[10];
						for (int ii = X; ii < X+3; ii++) {
							for (int jj = Y; jj < Y+3; jj++) {
								check[sudoku[ii][jj]] += 1;
								if (check[sudoku[ii][jj]] > 1) {
									answer = 0;
								}
							}
						}
					}
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
			
		}
		System.out.println(sb);
	}
}
