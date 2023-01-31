package test.baekjoon.b1_11653;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());

		for (int i = 2; true; ) {
			if (N % i == 0) {
				N = N / i;
				System.out.println(i);
			} else {
				if (N == 1) {
					break;
				}
				i++;
			}
		}
		
	}
}
