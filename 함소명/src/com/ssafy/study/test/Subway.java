package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Subway {
	static int N, max;
	static int[] Subway;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			v = new boolean[N];
			Subway = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Subway[i] = Integer.parseInt(st.nextToken());
			}

			recursive(new int[4], 0);
			System.out.println("#" + testCase + " " + max);
		}

	}

	private static void recursive(int[] sel, int sidx) {
		if (sidx == sel.length) {
			
			//0-1, 2-3 연결
			 
			
			// 2개의 직통 노선은 서로 교차할 수 없다. -> 2,3은 0,1왼쪽, 오른쪽에 몰아 있어야한다.
			boolean isCross = false;
			if((sel[2]<sel[0]&&sel[2]>sel[1])&&(sel[3]<sel[0]&&sel[3]>sel[1]))
				isCross = true;
			if((sel[2]>sel[0]&&sel[2]<sel[1])&&(sel[3]>sel[0]&&sel[3]<sel[1]))
				isCross = true;

			if (!isCross)
				return;

		
			// 인접한 두 역을 연결하는 직통 노선은 건설할 수 없다.
			for (int i = 0; i < sel.length; i++) {
				int idx = sel[i];
				int l = idx-1;
				if(l<0) l = N-1;
				int r = idx+1;
				if(r>=N) r = 0;
				for (int j = 0; j < sel.length; j++) {
					if(sel[j]==l || sel[j]==r)
						return;
				}
			}
			
//			System.out.println(Arrays.toString(sel));
			
			// 2개의 직통 노선을 건설하고, 이 때 타당도가 가장 높은 값이 되도록 값을 구하라!
			int num = ((Subway[sel[0]]+Subway[sel[1]])*(Subway[sel[0]]+Subway[sel[1]])+(Subway[sel[2]]+Subway[sel[3]])*(Subway[sel[2]]+Subway[sel[3]]));
			max = Math.max(max, num);
			
			return;
		}

		for (int i = 0; i < Subway.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sidx] = i;
				recursive(sel, sidx + 1);
				v[i] = false;
			}
		}
	}

}
