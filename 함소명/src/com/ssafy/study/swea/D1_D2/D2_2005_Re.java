package com.ssafy.study.swea.D1_D2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//파스칼의 삼각형
public class D2_2005_Re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z=1; z<t+1; z++) {
		int n = sc.nextInt();

		System.out.println("#" + z);
		System.out.println("1");
		int[] arr = new int[2];
		int[] copy = new int[2];
		
		for (int i = 2; i < n + 1; i++) {
			arr[0] = 1;
			arr[arr.length - 1] = 1;

			for (int j = 0; j < arr.length; j++) {
				for (int k = 1; k < arr.length - 1; k++) {
					arr[k] = copy[k] + copy[k - 1];
				}
				System.out.print(arr[j]+" ");
			}
			
			copy = new int[i + 1];
			for (int j = 0; j < arr.length; j++) {
				copy[j] = arr[j];
			}

			arr = new int[i + 1];
			System.out.println("");
		}

	}
	}

}
