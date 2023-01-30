package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//7272. 안경이 없어!
public class D3_7272 {
	static char[] zero = { 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z' };
	static char[] one = { 'A', 'D', 'O', 'P', 'Q', 'R' };
	static char[] two = { 'B' };

	// 알파벳 대문자로 이루어진 두 문자열을 비교
	// 문자에 나 있는 구멍의 개수가 같으면 같은 문자,다르면 다른 문자
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());// int형으로 읽기

		for (int i = 1; i <= T; i++) {
			String str = br.readLine();// 한줄 쭉 읽기
			StringTokenizer st = new StringTokenizer(str);
			String str1 = st.nextToken();// nextInt()와 같이 한글자씩 읽기
			String str2 = st.nextToken();

			String Compar = "SAME";

			if (str1.length() != str2.length()) {
				Compar = "DIFF";
				
			} else {
				char[] strArr1 = new char[str1.length()];
				char[] strArr2 = new char[str2.length()];

				for (int j = 0; j < str1.length(); j++) {
					char char1 = str1.charAt(j);
					strArr1[j] = compare(Character.toUpperCase(char1));// 대문자로 변환
				}

				for (int j = 0; j < str2.length(); j++) {
					char char2 = str2.charAt(j);
					strArr2[j] = compare(Character.toUpperCase(char2));
				}

				if (!Arrays.equals(strArr1, strArr2))
					Compar = "DIFF";
			}

			System.out.println("#" + i + " " + Compar);

		}
	}

	public static Character compare(char str) {
		for (char ch : zero)
			if (str == ch)
				str = 'Z';
		for (char ch : one)
			if (str == ch)
				str = 'A';
		for (char ch : two)
			if (str == ch)
				str = 'B';

		return str;
	}
}
