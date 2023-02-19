package com.ssafy.study.beakjoon.beak_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 스위치 켜고 끄기
 * 8개의 상태가 표시되어 있다. ‘1’은 스위치가 켜져 있음을, ‘0’은 꺼져 있음
 * 1 이상이고 스위치 개수 이하인 자연수를 하나씩 나누어주었다
 * 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다
 * 여학생은 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
 * 남학생은 1로, 여학생은 2로 표시
 */
public class Main {

	static int[] switchs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		switchs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			change(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(switchs[i]+" ");
			if(i%20==0)System.out.println();
		}
	}

	public static void change(int MW, int num) {
		switch (MW) {
		case 1: {
			for (int i = num; i < switchs.length; i += num) {
				switchs[i] = switchs[i] == 0 ? 1 : 0;
			}
			break;
		}
		case 2: {
			int cnt = 0;
			for (int i = 1; i < switchs.length; i++) {
				if (num - i > 0 && num + i < switchs.length) {
					if (switchs[num - i] == switchs[num + i]) {
						cnt++;
					}else {
						break;
					}

				}
			}
			for (int i = num - cnt; i <= num + cnt; i++) {
				switchs[i] = switchs[i] == 0 ? 1 : 0;
			}
			break;
		}
		}
	}
}
