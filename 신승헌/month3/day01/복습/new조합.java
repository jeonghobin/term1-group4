package month3.day01.복습;

import java.util.Arrays;

public class new조합 {
	static int[] arr;
//	static boolean[] v;
	static int[] sel;
	static int size;
	static int answer;

	public static void main(String[] args) {
		arr = new int[] { 1, 3, 5 };
		size = 2; //
//		v = new boolean[arr.length];
		sel = new int[size];
		answer = 0;

		recursive(0, 0);
		System.out.println(answer);
	}

	private static void recursive(int count, int start) {
		if (count == size) {
			answer++;
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = start; i < arr.length; i++) { // 순열에서 for문이 바뀌면 조합!
//			v[i] = true;
			sel[count] = arr[i];
			recursive(count + 1, i + 1);
			sel[count] = 0;
//			v[i] = false;
		}

	}
}
