package test.baekjoon.s5_2563;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[100][100];
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int xStart = Integer.parseInt(st.nextToken());
			int yStart = 100 - 10 - Integer.parseInt(st.nextToken());
			
			for (int j = xStart; j < xStart + 10; j++) {
				for (int k = yStart; k < yStart + 10; k++) {
					array[j][k] = 1;
				}
			}
			
			
		}
		
		int answer = 0;
		for (int j = 0; j < array.length; j++) {
			for (int k = 0; k < array[j].length; k++) {
				answer += array[j][k];
			}
		}
		
		System.out.println(answer);
	}
}
