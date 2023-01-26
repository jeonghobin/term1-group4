package homework.Baekjoon.b2_8320;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j * i <= N; j++) {
				if (i * j > N) {
					break;
				} else {
					count += 1;
				}
			}
		}
		System.out.println(count);
	}
}
