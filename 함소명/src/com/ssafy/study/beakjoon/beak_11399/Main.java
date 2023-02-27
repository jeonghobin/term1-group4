package com.ssafy.study.beakjoon.beak_11399;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		// 정렬 
		Arrays.sort(arr);
 
 
		int prev = 0;	// 이전까지의 대기시간 누적합 
		int sum = 0;	// 사람별 대기시간 총합 
				
		for(int i = 0; i < N; i++) {	
			sum += prev + arr[i];
		
			prev += arr[i];
		}
		System.out.println(sum);
	}
}
