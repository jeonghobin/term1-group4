package com.ssafy.study.swea.D1_D2;

import java.util.Arrays;
import java.util.Scanner;

//중간 평균값 구하기
public class D2_1984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=1; i<t+1; i++) {
			System.out.print("#"+i+" ");
			int[] arr = new int[10];
			for(int j=0; j<10; j++) {
				int n = sc.nextInt();
				arr[j] = n;
			}
			int max = Arrays.stream(arr).max().getAsInt();
			int min = Arrays.stream(arr).min().getAsInt();
			for(int j=0; j<arr.length; j++) {
				if(arr[j]==max || arr[j]==min)
					arr[j] = 0;
			}
			int sum = Arrays.stream(arr).sum();
			int avg = sum/(arr.length-2);
			int nam = sum%(arr.length-2);
			int nam2 = nam*10/(arr.length-2);
//			System.out.println(nam+", "+nam2);
			if(nam2>=5) 
				avg= avg+1;
		
			System.out.println(avg);
		}
	}

}
