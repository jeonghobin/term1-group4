package week04.s5_1312;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int remain = A;
		for (int i = 0; i < N; i++) {
//			System.out.println(remain);
			remain = 10 * (remain % B);
		}
		System.out.println(remain / B);
	}
}
