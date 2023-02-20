package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

//두개의 숫자열
public class D2_1959 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max = 0;
			int Xsize=sc.nextInt();
			int Ysize=sc.nextInt();
			
			int[] X = new int[Xsize];
			for(int i=0; i<Xsize; i++) {
				X[i] = sc.nextInt();
			}
			
			int[] Y = new int[Ysize];
			for(int i=0; i<Ysize; i++) {
				Y[i] = sc.nextInt();
			}
			
			int Msize = Math.max(Xsize, Ysize);
			if(Msize==Xsize) {
				int move = Xsize-Ysize;
				for(int i=0; i<=move; i++) {
					int sum =0;
					for(int j=0; j<Ysize; j++) {
						int gob = X[j+i] * Y[j];
						sum += gob;
					}
					if(sum >= max)
						max = sum;
				}
			}else {
				int move = Ysize-Xsize;
				for(int i=0; i<=move; i++) {
					int sum =0;
					for(int j=0; j<Xsize; j++) {
						int gob = X[j] * Y[j+i];
						sum += gob;
					}
					if(sum >= max)
						max = sum;
				}
			}
			
			
			System.out.println("#"+test_case+" "+max);
		}
	}

}
