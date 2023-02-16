package algo.bj.s4_11047;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 동전 개수
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			answer += K / arr[i];
			K = K % arr[i];
		}
		
		System.out.println(answer);
	}
}
