package com.ssafy.study.beakjoon.알람시계_2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hh = sc.nextInt();
		int mm = sc.nextInt();

		int m = mm - 45;
		if (m < 0) {
			hh--;//0
			if(hh<0)
				hh = 23;
			mm = 60 + m;
		} else {
			mm = mm - 45;
		}

		System.out.println(hh + " " + mm);
	}

}
