package com.ssafy.study.beakjoon.beak_11729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//하노이 탑 이동 순서
//이동 순서를 출력
public class Main {//https://hyunipad.tistory.com/89

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		check(N, 1, 0, 0);
	}
	public static void check(int n, int k, int start, int end) {
	
		
		if(n%2==0) {
			//position 2
			check(n, k+1, start, end);
		}else {
			//position 3
			check(n, k+2, start, end);
		}

	}
}
