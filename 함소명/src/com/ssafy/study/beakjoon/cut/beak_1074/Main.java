package com.ssafy.study.beakjoon.cut.beak_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Z
 * 분할로 문제 풀기.
 * 다시
 */
public class Main {
	static int cnt = 0;// cnt -> 앞쪽 없애기. 없앤 숫자중 가장 큰 숫자
	static int dr;
	static int dc;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);// 제곱근//0~N-1행

		dr = Integer.parseInt(st.nextToken());
		dc = Integer.parseInt(st.nextToken());

//		Position(0,0,N);
		Zfind(N,dr,dc);

		// 0부터니까 -1을 해준다.
		System.out.println(cnt);
	}


	
	private static void Zfind(int half, int r, int c) {
		if(half == 1)
			return;
		
		if(r < half/2 && c < half/2) {//1사분면
			Zfind(half/2, r, c);
		}
		else if(r < half/2 && c >= half/2) {//2사분면
			cnt += half * half / 4;
			Zfind(half/2, r, c - half/2);
		}
		else if(r >= half/2 && c < half/2) {//3사분면
			cnt += (half * half / 4) * 2;
			Zfind(half/2, r - half/2, c);
		}
		else {//4사분면
			cnt += (half * half / 4) * 3;
			Zfind(half/2, r - half/2, c - half/2);
		}
	}
	
	//my code 테스트 코드는 되지만 안됨.
//	public static void Position(int r, int c, int half) {
//	// 쪼개 나눈게 1이되면 끝냄.
//	if (half == 1)
//		return;
//
//	half = half / 2;
//
//	// Z니까 행부터 날리고 열 날리기.
//	if (dr >= half) // 뒤에 있으면 앞쪽 숫자 더하기
//		cnt += half * (half * 2);
//
//	if (dc >= half) // 뒤에 있으면 앞쪽 숫자 더하기
//		cnt += half * half;
//
//	Position(r, c, half);
//}

}
