package homework.Baekjoon.b2_2798;

import java.io.*;
import java.util.*;

// w3-txt-05

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken()); // 카드 개수
		int M = Integer.parseInt(st.nextToken()); // 최대 숫자
		
		int[] cardArray = new int[N];
		
		st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < N; i++) {
			cardArray[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxNum = 0;
		
		for (int i = 0; i < cardArray.length; i++) {
			for (int j = i + 1; j < cardArray.length; j++) {
				for (int k = j + 1; k < cardArray.length; k++) {
					int nowNum = cardArray[i] + cardArray[j] + cardArray[k];
					if (nowNum <= M && maxNum < nowNum) {
						maxNum = nowNum;
					}
				}
			}
		}
		
		System.out.println(maxNum);
		
		
	}
}
