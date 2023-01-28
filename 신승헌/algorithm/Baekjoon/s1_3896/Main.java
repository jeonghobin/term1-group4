package week04.s1_3896;

import java.io.*;
import java.util.*;

// (p+n) - p 를 구하는 문제

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 실수가 아니면 true
		boolean[] prime = new boolean[1299709 + 1];
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i] == false) {
				for (int j = i*i; j < prime.length; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			if (prime[k] == false) {
				System.out.println(0);
			} else {
				int l = k-1;
				int r = k+1;
				while(true) {
					if(prime[l] == true) {
						l--;
						continue;
					}
					if(prime[r] == true) {
						r++;
						continue;
					}
					System.out.println(r - l);
					break;
				}
			}
		}
	}
}
