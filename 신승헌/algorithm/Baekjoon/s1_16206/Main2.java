package homework.Baekjoon.s1_16206;

import java.io.*;
import java.util.*;


public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		
		ArrayList<Integer> bestList = new ArrayList<>();
		ArrayList<Integer> bedList = new ArrayList<>();
		
		// 입력
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			if (now % 10 == 0) {
				bestList.add(now);
			} else {
				bedList.add(now);
			}
		}
		
		
	}
}
