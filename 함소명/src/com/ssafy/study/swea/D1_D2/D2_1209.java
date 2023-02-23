package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

//Sum (각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값)
public class D2_1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T=sc.nextInt();
			int[][] list = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					int num = sc.nextInt();
					list[i][j] = num;
				}
			}
			
			int max = 0;
			for(int i=0; i<100; i++) {
				int sum = 0;
				for(int j=0; j<100; j++) {
					sum += list[i][j];
				}
				if(sum >= max)
					max = sum;
			}
			
			for(int j=0; j<100; j++) {
				int sum = 0;
				for(int i=0; i<100; i++) {
					sum += list[i][j];
				}
				if(sum >= max)
					max = sum;
			}
			
			for(int j=0; j<100; j++) {
				int sum = 0;
				for(int i=0; i<100; i++) {
					if(i==j) {
						sum += list[i][j];
					}
				}
				if(sum >= max)
					max = sum;
			}
			
			
			System.out.println("#"+test_case+" "+max);
		}
	}

}
