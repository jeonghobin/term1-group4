package homework.Baekjoon.s1_16206;

//w3-txt-15
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); 
		
		
		
		int[] cake = new int[N];
		
		int answer = 0;
		
		// 값 input
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cake.length; i++) {
			cake[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cake);
		
		// 나누어 떨어지는 케이크만 탐색
		for (int i = 0; i < cake.length; i++) {
			while(true) {
				if (cake[i] % 10 == 0 && M != 0) { 
					cake[i] -= 10;
					answer += 1;
					if (cake[i] == 0) {
						break;
					}
					M -= 1;
				} else {
					break;
				}
			}
		}
	
		// M이 남아있는 경우 나누어 떨어지지 않는 케이크 탐색
		if (M != 0) {
			for (int i = 0; i < cake.length; i++) {
				if (cake[i] != 0) {
					if (M != 0) {
						while (cake[i] / 10 > 0 && M != 0) {
							cake[i] -= 10;
							M -= 1;
							answer += 1;
						}
					} else {
						break;
					}
				}
			}
		}

		System.out.println(answer);
		
		
	}
}
