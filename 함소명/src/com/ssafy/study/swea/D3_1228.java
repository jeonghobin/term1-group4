package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class D3_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			List<String> list = new ArrayList<String>();
			
			int N = Integer.parseInt(br.readLine());//원본 암호문의 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			 
			int M = Integer.parseInt(br.readLine());//명령어의 개수
			st = new StringTokenizer(br.readLine());//l x(위치 바로 다음) y(개 숫자 삽입) s(덧붙일 숫자들)
			for (int i = 0; i < M; i++) {//명령어
				String split = st.nextToken();//구분자
				int index = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					list.add(index+j, st.nextToken());
				}
			}
			
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
		
		
	}
}
