package com.ssafy.study.beakjoon.beak_2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//피보나치 수 //재귀
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Long> arr = new ArrayList<>();
		arr.add((long) 0);
		arr.add((long) 1);
		
		for (int i = 0; i < N; i++) {
			long sum = arr.get(i)+arr.get(i+1);
			arr.add(sum);
		}
			
		System.out.println(arr.get(N));
//		System.out.println(self(N));
//	}
//	public static Integer self(int n) {
//		if(n==0)
//			return 0;
//		
//		return n+self(n-1);
//	}
	}
}
