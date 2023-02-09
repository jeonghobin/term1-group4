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

	static String[] arr = { "A", "C", "G", "T" };
	static int totalCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());// DNA 문자열 길이 |S|
		int P = Integer.parseInt(st.nextToken());// 사용할 부분문자열의 길이 |P|

		String[] str = new String[S];
		String pw = br.readLine();
		for (int i = 0; i < S; i++) {
			str[i] = String.valueOf(pw.charAt(i));
		}

		int[] limit = new int[4];// 사용할 문자의 최소 개수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		while (start+P < S) {
			int[] copylimit = limit;
			
			for (int i = start; i < start+P; i++) {
				if("A".equals(str[i])) copylimit[0]--;
				if("C".equals(str[i])) copylimit[1]--;
				if("G".equals(str[i])) copylimit[2]--;
				if("T".equals(str[i])) copylimit[3]--;
			}
			
			int sum = Arrays.stream(copylimit).sum();
			
			if(sum==0) totalCnt++;
			
			start++;
		}
		
		System.out.println(totalCnt);
		
	}

}
