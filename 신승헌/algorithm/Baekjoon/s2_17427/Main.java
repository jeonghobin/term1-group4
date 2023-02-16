package algo.bj.s2_17427;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		long sum = 0L;

		for (int i = 1; i <= N; i++) {
			sum = sum + N / i * i;
		}

		System.out.println(sum);
	}
}
