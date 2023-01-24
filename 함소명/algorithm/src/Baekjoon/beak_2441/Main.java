package Baekjoon.beak_2441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(j<i)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
