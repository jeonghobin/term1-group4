package homework.Baekjoon.s4_11399;

import java.io.*;
import java.util.*;

// w3-txt-06

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list.sort(Comparator.naturalOrder());
		
		for (int i = 0; i < N; i++) {
			answer = answer + list.get(i) * (N - i);
		}
		
		System.out.println(answer);
		
	}
}
