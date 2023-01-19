package baekjoon;

import java.util.*;
import java.io.*;

// 백준 15736번 문제
// 공식을 파악해나아가는 연습이 필요

public class Main {
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int i=1;
		// 백기가 위로 올라가는 경우는 약수가 홀수인 경우이다
		// 약수가 홀수이려면 제곱수여야한다.
		while(i*i<N) {
			i++;
		}
		if(i*i==N) {
			System.out.println(i);
		}
		else if(i*i>N) {
			System.out.println(i-1);
		}
 	}
	
	
	
}

	

