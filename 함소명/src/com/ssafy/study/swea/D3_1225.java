package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//암호 생성기
//n개의 수를 처리하면 8자리의 암호를 생성
//8개의 숫자를 입력 받는다.
public class D3_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			Queue<Integer> Q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				Q.offer(Integer.parseInt(st.nextToken()));
			}

			int cnt = 0;// 5 Q 돌기
		
			
			L: while (Q.peek() > 0) {
				cnt++;
				cnt = cnt % 6;
				if(cnt==0) cnt =1;
			
				int n = Q.poll() - cnt;
		
				if (n <= 0)
					break L;

				Q.offer(n);
			

			}
			
			Q.offer(0);

			System.out.print("#"+test_case+" ");
			for (int i = 0; i < 8; i++) {
				System.out.print(Q.poll()+" ");
			}
			System.out.println();
		}

	}

}
