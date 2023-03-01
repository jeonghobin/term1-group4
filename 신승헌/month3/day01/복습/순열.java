package month3.day01.복습;

import java.io.*;
import java.util.*;

public class 순열 {
	static int[] arr;
	static int[] sel;
	static boolean[] v;
	static int size;

	public static void main(String[] args) {
		arr = new int[] { 1, 3, 5 };
//		size = 2;
		v = new boolean[arr.length];
//		sel = new int[size];

		recursive(0);
	}

	private static void recursive(int count) {
		if (count == arr.length) {
			System.out.println(Arrays.toString(v));
			return;
		}

//		for (int i = 0; i < arr.length; i++) {
			v[count] = true;
			recursive(count + 1);
			v[count] = false;
			recursive(count + 1);
//		}	
				
	}

}
