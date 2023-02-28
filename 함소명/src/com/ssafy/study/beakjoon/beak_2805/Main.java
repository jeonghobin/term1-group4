package com.ssafy.study.beakjoon.beak_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 나무 자르기
	// N개의 수직선 위에 C개의 공유기설치 시, 공유기 사이의 거리는 가능한 크게 설치
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer number = new StringTokenizer(str);
		int N = Integer.parseInt(number.nextToken());
		int M = Integer.parseInt(number.nextToken());

		StringTokenizer Trees = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(Trees.nextToken());
		}


//		System.out.println(min - 1);

	}
}
