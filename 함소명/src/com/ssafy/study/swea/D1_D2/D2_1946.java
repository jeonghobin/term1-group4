package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

//간단한 압축 풀기
public class D2_1946 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int cnt = 0;
			System.out.println("#" + test_case);
			
			for (int i = 0; i < N; i++) {
				String ch = sc.next();
				int num = sc.nextInt();
				
				for (int j = 0; j < num; j++) {
					System.out.print(ch);
					cnt++;
					if(cnt==10) {
						cnt = 0;
						System.out.println();
					}
				}
			}
			System.out.println();
		}
	}

}
