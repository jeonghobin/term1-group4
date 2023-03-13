package day13;

import java.io.*;
import java.util.*;

public class 일이삼더하기 {
	static int N, M;
	static int now;
	static int[] sel;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 숫자 N
		M = Integer.parseInt(st.nextToken()); // 방법 M
		
		now = 0;
		sel = new int[11];
		recursive(0, 0);
		
		if (sb.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);			
		}
		
	}
	private static void recursive(int count, int idx) {
		if(count == N) {
			now++;
			if (M == now) {
				sb.append(sel[0]);
				for (int i = 1; i < sel.length; i++) {
					if (sel[i] == 0) return;
					sb.append("+"+sel[i]);
				}
			}
			return;
		}
		
		if(count > N) {
			return;
		}
		
		sel[idx] = 0;
		for (int i = 1; i < 4; i++) {
			sel[idx] = i;
			recursive(count + i, idx + 1);
			sel[idx] = 0;
		}
		
	}
	
}
