package test.baekjoon.b2_2747;

import java.io.*;
import java.util.*;

public class Main {
	static long[] arr;
	
	static long fivo(int n) {
		if (arr[n] == -1) {
			arr[n] = fivo(n-1) + fivo(n-2); 
		}
		return arr[n];
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		arr = new long[n + 1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		arr[0] = 0;
		arr[1] = 1;
		
		
		System.out.println(fivo(n));
	}
}
