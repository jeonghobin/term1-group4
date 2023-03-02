package month3.day01.복습;

import java.util.Arrays;

public class new순열 {
	static int[] arr;
	static boolean[] v;
	static int[] sel;
	static int size;
	static int answer;
	
	public static void main(String[] args) {
		arr = new int[] { 1, 3, 5 };
		size = 2; // 
		v = new boolean[arr.length];
		sel = new int[size];
		answer = 0;
		
		recursive(0);
		System.out.println(answer);
	}

	private static void recursive(int count) {
		if (count == size) {
			answer ++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(v[i]) continue; // 방문 했으면
			v[i] = true;
			sel[count] = arr[i];
			recursive(count + 1);
			sel[count] = 0;
			v[i] = false;
 		}
	}
}