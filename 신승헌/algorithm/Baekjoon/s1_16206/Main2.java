package homework.Baekjoon.s1_16206;

import java.io.*;
import java.util.*;


public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 롤 케이크의 개수
		int M = Integer.parseInt(st.nextToken()); // 자르는 개수
		
		ArrayList<Integer> bestList = new ArrayList<>();
		ArrayList<Integer> bedList = new ArrayList<>();
		
		int answer = 0;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			if (now == 10) {
				answer += 1;
			} else if (now % 10 == 0) {
				bestList.add(now);
			} else if (now > 10) {
				bedList.add(now);
			}
		}
		
		Collections.sort(bestList);
		Collections.sort(bedList);
		
		for (int i = 0; i < bestList.size(); i++) {
			if (M <= 0) {
				break;
			}
			int now = bestList.get(i);
			while(true) {
				now -= 10;
				M -= 1;
				answer += 1;
				if (now == 10) {
					answer += 1;
					break;
				}
				if (M <= 0) {
					break;
				}
			}
		}
		
		for (int i = 0; i < bedList.size(); i++) {
			if (M <= 0) {
				break;
			}
			int now = bedList.get(i);
			while(true) {
				now -= 10;
				M -= 1;
				answer += 1;
				if (now < 10) {
					break;
				}
				if (M <= 0) {
					break;
				}
			}
		}
		
		System.out.println(answer);
		
	}
}