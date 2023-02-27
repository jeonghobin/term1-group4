package com.ssafy.study.beakjoon.설탕배달_2839_Re;

import java.util.Scanner;

/*
 * 설탕 배달
 * 정확하게 N킬로그램을 배달해야 한다
 * 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * 정확히 N킬로그램을 만들 수 없다면 -1 출력.
 * 
 * -> 그리디. 큰걸 우선순위로 작은것들을 껴넣을때, 작은것들로도 되는지 확인할 때, 
 * 작은걸 빼서 큰걸로 나눠지는지 계속 확인한다.
 */
public class Main {
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();

		int m = 0;
		while (true) {
			if (M % 5 == 0) {
				m += M / 5;
				break;
			} else {
				M -= 3;// 3을빼서 본다.
				m++;
			}
			
			if (M < 0) {
				m = -1;
				break;
			}
		}
		
		System.out.println(m);
	}

}
