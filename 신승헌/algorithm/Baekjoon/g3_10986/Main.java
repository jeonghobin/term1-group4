package algo.bj.g3_10986;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 숫자 개수
		int M = Integer.parseInt(st.nextToken()); // 나누기 기준
		
		int[] arr = new int[N + 1];
		
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1] + st.nextToken();
		}
	}
}
