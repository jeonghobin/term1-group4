package Baekjoon.b3_2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] iArray = new int[9];

		int maxNum = 0;
		int maxIndex = 0;
		
		for (int i = 0; i < 9; i++) {
			iArray[i] = Integer.parseInt(br.readLine());
			
			if (iArray[i] > maxNum) {
				maxNum = iArray[i];
				maxIndex = i + 1;
			}
		}
		
		System.out.println(maxNum);
		System.out.println(maxIndex);
	}
}
