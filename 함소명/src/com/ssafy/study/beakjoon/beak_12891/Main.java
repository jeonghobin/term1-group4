package com.ssafy.study.beakjoon.beak_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//DNA 비밀번호
//{‘A’, ‘C’, ‘G’, ‘T’}가 들어가는 문자열만 DNA
// 
public class Main {

	static char[] arr = { 'A', 'C', 'G', 'T' };
	static int[] copylimit = new int[4];
	static 	int[] limit = new int[4];
	static int totalCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());// DNA 문자열 길이 |S|
		int P = Integer.parseInt(st.nextToken());// 사용할 부분문자열의 길이 |P|

		String DNA = br.readLine();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		//처음 문자열 문자 개수 저장
		for (int i = 0; i < P; i++) {
			add(DNA.charAt(i));
		}
		
		boolean check = true;
		for (int j = 0; j < 4; j++) {
			if (copylimit[j] < limit[j])
				check = false;
		}

		if (check())
			totalCnt++;
		

		for (int i = P; i< S; i++) { // 처음~새로 탐색되는 문자
			int start = i - P;
			remove(DNA.charAt(start));
			add(DNA.charAt(i));
			

			if (check())
				totalCnt++;
		}
		
		System.out.println(totalCnt);
	}

	public static Boolean check() {
		boolean check = true;
		for (int j = 0; j < 4; j++) {
			if (copylimit[j] < limit[j])
				check = false;
		}
		return check;
	}
	
	// 추가
	public static void add(char c) {
		switch (c) {
		case 'A':
			copylimit[0]++;
			break;
		case 'C':
			copylimit[1]++;
			break;
		case 'G':
			copylimit[2]++;
			break;
		case 'T':
			copylimit[3]++;
			break;
		}
	}

	// 제거
	public static void remove(char c) {
		switch (c) {
		case 'A':
			copylimit[0]--;
			break;
		case 'C':
			copylimit[1]--;
			break;
		case 'G':
			copylimit[2]--;
			break;
		case 'T':
			copylimit[3]--;
			break;
		}
	}

}
