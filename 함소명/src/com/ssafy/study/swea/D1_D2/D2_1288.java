package com.ssafy.study.swea.D1_D2;

import java.util.*;

//새로운 불면증 치료법
public class D2_1288 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 1; i < t + 1; i++) {
			int n = sc.nextInt();
			System.out.printf("#" + i + " ");

			int[] arr = new int[10];
			boolean zero = false;
			int cnt = 0;
			for (int j = 1; j < 1000000; j++) {
				cnt++;
				
				//숫자 자르기
				ArrayList<Integer> temp = new ArrayList<>();
				int q = n * j;
				while (q > 0) {
					int a = q % 10;
					q /= 10;
					temp.add(a);
				}
//				System.out.println(temp);
				for (int k = 0; k < temp.size(); k++) {
					if (temp.get(k) == 0)
						zero = true;

					arr[temp.get(k)] = temp.get(k);
//					System.out.print(Arrays.toString(arr));

				}

				if (Arrays.equals(arr, result) && zero)
					break;
			}
			System.out.println(cnt*n);
		}

	}

}
