package homework.Baekjoon.b3_2991;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] PMN = new int[3];
		for (int i = 0; i < PMN.length; i++) {
			int answer = 0;
			PMN[i] = Integer.parseInt(st.nextToken());
			
//			System.out.println(PMN[i] % (A+B) + " : " + PMN[i] % (C+D));
			if (PMN[i] % (A+B) <= A && PMN[i] % (A+B) != 0) {
				answer += 1;
			}
			if (PMN[i] % (C+D) <= C && PMN[i] % (C+D) != 0) {
				answer += 1;
			}
			sb.append(answer + "\n");
		} 

		System.out.println(sb);

		
		
		
	}
}
