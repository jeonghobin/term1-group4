package week04.s2_9020;

import java.io.*;
import java.util.*;

// 가운데부터 1씩 증감을 통해 탐색을 하자
// (수리력을 기르자..!)

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[10000 + 1];
		prime[0] = true;
		prime[1] = true;
		
		LinkedList<Integer> p = new LinkedList<>();
		
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i] == false) {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
		
		for (int i = 0; i < prime.length; i++) {
			if(prime[i] == false) {
				p.add(i);
			}
		}
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
						
			int l = n / 2;
			int r = n / 2;
			
			while(true) {
				if (l + r == n) {
					if (p.contains(l) && p.contains(r)) {
						sb.append(l + " " + r + "\n");
						break;
					}
					l--;
					r++;
				}
				
			}
			
//			int answer1 = 0;
//			int answer2 = 10000;
//			for (int j = 0; j < p.size(); j++) {
//				for (int k = j; k < p.size(); k++) {
//					if (p.get(j) + p.get(k) == n) {
//						if ( answer2 - answer1 > p.get(k) - p.get(j) ) {
//							answer1 = p.get(j);
//							answer2 = p.get(k);
//						}
//					}
//				}
//			}
//			sb.append(answer1 + " " + answer2 + "\n");

		}
		System.out.println(sb);
	}
}
