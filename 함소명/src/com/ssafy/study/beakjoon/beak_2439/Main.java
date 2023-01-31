package com.ssafy.study.beakjoon.beak_2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			for (int j = N; j > 0; j--) {
				if(j>i)
				System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
