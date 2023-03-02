package month3.day01.복습;

import java.util.Arrays;

public class new부분집합 {
	static int[] arr;
	static boolean[] v;
//	static int[] sel;
	static int size;
	static int answer;

	public static void main(String[] args) {
		arr = new int[] { 1, 2, 3, 4, 5, 6 ,7 ,8, 9, 0 };
//		size = 2;
		v = new boolean[arr.length];
//		sel = new int[size];
		answer = 0;

		recursive(0);
		System.out.println(answer);
	}

	private static void recursive(int count) {
		if (count == arr.length) { // 모든 숫자에 대해서 선택해봤는가 여부 확인
			answer++;
			System.out.println(Arrays.toString(v));
			return;
		}

//		for (int i = 0; i < arr.length; i++) {
//			if(v[i]) continue; // 방문 했으면
			v[count] = true;
//			sel[count] = arr[i];
			recursive(count + 1); // 넣을 경우
//			sel[count] = 0;
			v[count] = false;
			recursive(count + 1); // 안넣을 경우

// 		}

	}
}