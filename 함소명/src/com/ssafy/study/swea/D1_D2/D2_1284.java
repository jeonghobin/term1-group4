package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

// 수도 요금 경쟁
public class D2_1284 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] list = new int[5];
			for (int i = 0; i < list.length; i++) {
				list[i] = sc.nextInt();
			}
			
			int A = 0;
			int B = 0;
			A = list[0]*list[4];
			
			if(list[4]<=list[2]) {
				B = list[1];	
			}else {
				B = list[1]+((list[4]-list[2])*list[3]);
			}
			
			int min = Math.min(A, B);
			System.out.println("#"+test_case+" "+min);
			
			
		}
	}
}
