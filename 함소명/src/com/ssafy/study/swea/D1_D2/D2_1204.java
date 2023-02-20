package com.ssafy.study.swea.D1_D2;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

//최빈수 구하기
public class D2_1204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 숫자, 빈도수
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < 1000; i++) {
				int a = sc.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
			}

			 int max = 0;
			 
			 //방법1
			 // int maxValueInMap = Collections.max(list.values());
			 // for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
			 //			        if (entry.getValue() == maxValueInMap) 
			 //			            max = entry.getKey();
			 //	}
			
			 //방법2
			int answer = 0;
			for (Entry<Integer, Integer> i : map.entrySet()) {
				int n = i.getValue();

				if (n >= max) {
					max = n;
					answer = i.getKey();
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}

}

