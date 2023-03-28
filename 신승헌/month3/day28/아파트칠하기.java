package day28;

import java.io.*;
import java.util.*;

// 파란색과 노란색으로 페인트를 칠할 수 있음
// 노란색 위에는 노란색과 파란색을
// 파란색 위에는 파란색과 노란색을 둘다 칠할 수 있음
// n층을 칠할때 색칠할 수 있는 경우의 수는?

public class 아파트칠하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int b = 1;
		int y = 1;
		// f(n) = y * 2  

		
		for (int i = 2; i <= n; i++) {
			int nexty = y + b;
			int nextb = y;
			y = nexty;
			b = nextb;
			System.out.println(y + " " + b);
		}
		
		System.out.println(y + b);
		
	}
}
