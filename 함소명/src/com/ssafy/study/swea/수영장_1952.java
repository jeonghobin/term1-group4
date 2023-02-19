package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//1952. [모의 SW 역량테스트] 수영장 : 완탐
//1일 이용권 - 10원, 1달 이용권 - 40원 , 3달 이용권 - 100원, 1년 이용권 - 300원  
//3달 이용권은 11월, 12월, 1윌 이나 12월, 1월, 2월 동안 사용하도록 구매할 수는 없다
//각 이용권의 요금과 각 달의 이용 계획이 입력으로 주어질 때,가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 그 비용을 출력
public class 수영장_1952 {
	static int[] month = new int[12];
	static int min;
	static int[] fee = new int[4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());//요금
			}
			min = fee[3];//1년 요금
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			check(0, 0);
			System.out.println("#" + test + " " + min);
		}
	}

	static void check(int n, int cost) {
		if (n < 12) {
			if (month[n] != 0) {
				check(n + 1, cost + month[n] * fee[0]);//1일
				check(n + 1, cost + fee[1]);//1달
				check(n + 3, cost + fee[2]);//3달
			} else {
				check(n + 1, cost); // 그대로
			}
		} else {
			min = min > cost ? cost : min;
			return;
		}
	}

}
