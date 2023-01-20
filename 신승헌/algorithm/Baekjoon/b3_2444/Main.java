package Baekjoon.b3_2444;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 2*N -1; i++) {
			if (i < N) {
				int countingSpace = N - (i + 1);
				for (int j = 0; j < countingSpace; j++) {
					System.out.print(" ");
				}
				
				int countingStar = (i + 1) * 2 - 1;
				for (int j = 0; j < countingStar; j++) {
					System.out.print("*");
				}
				
				System.out.println();
			} else {
				int countingSpace = (i + 1 - N);
				for (int j = 0; j < countingSpace; j++) {
					System.out.print(" ");
				}
				
				int countingStar = (2*N - i -1) * 2 - 1;
				for (int j = 0; j < countingStar; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			
		}
	}
}
