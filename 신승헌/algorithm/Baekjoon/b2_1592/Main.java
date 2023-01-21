package homework.Baekjoon.b2_1592;

import java.io.*;
import java.util.*;

// w3-txt-04

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]); // 사람 수
		int M = Integer.parseInt(s[1]); // 최대 공 받는 횟수
		int L = Integer.parseInt(s[2]); // 공 이동 거리
		
		int[] personArray = new int[N + 1];
		
		int nowIndex = 1;
		int nowThrow = 0;
		
		while (true) {
			personArray[nowIndex] += 1;
			
			// output
			if (personArray[nowIndex] == M) {
				System.out.println(nowThrow);
				break;
			}
			
			// 던지는 방향 계산
			if (personArray[nowIndex] % 2 == 0) { // 짝수면 반시계 (왼쪽)
				nowIndex -= L;
			} else { // 홀수면 시계 (오른쪽)
				nowIndex += L; 
			}
			
			// 인덱스 계산
			if (nowIndex > N) {
				nowIndex -= N;
			} else if (nowIndex < 1) {
				nowIndex += N;
			}
			
			nowThrow += 1;
			

		}
	}
}
