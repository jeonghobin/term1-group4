package com.ssafy.study.swea.D1_D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백만 장자 프로젝트
 * 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.하루에 최대 1만큼 구입할 수 있다.
 * 예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.
 * 계속 보다 큰 값이 나오면 계산 해야할땐, 뒤에서부터 비교!! 초기화 후 나와서 계산.
 */
public class D2_1859_Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= N; test_case++) {
			int total_day = Integer.parseInt(br.readLine());
			
			long[] price = new long[total_day];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < total_day; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
		
			int cnt = 0;
			long max = Long.MIN_VALUE;
			long sum = 0;
			long answer = 0;
			for (int day = total_day-1; day >= 0; day--) {
				long today = price[day];
				if(today > max) {
					answer += max*cnt-sum; 
					cnt =0;
					sum =0;
					max=today;
				}else {
					cnt++;
					sum += today;
				}
			}
			
			answer += max*cnt-sum;
			
			System.out.println("#"+test_case+" "+answer);
		}

	}

}
