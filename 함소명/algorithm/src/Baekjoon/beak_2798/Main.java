package Baekjoon.beak_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 블랙잭
	// 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임
	// 3장의 카드를 고르고, 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cardList = new int[N];
		StringTokenizer card = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cardList[i] = Integer.parseInt(card.nextToken());
		}

		Arrays.sort(cardList);
		
		int Msum = 0;
		
		for (int i = 0; i < cardList.length-2; i++) {
			for (int j = 1+i; j < cardList.length-1; j++) {
				for (int k = 2+i; k < cardList.length; k++) {
					
					int sum = cardList[i] + cardList[j] + cardList[k];
					
					if(sum <= M) {
						Msum = Math.max(Msum, sum);
					}
						
				}
			}
		}
		
		
		System.out.println(Msum);
	}

}
