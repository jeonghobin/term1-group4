package day09.복습;

import java.util.*;
import java.io.*;


public class 중복조합 {
	
	static int[] arr = { 1, 3, 5, 7 };
	static int[] sel;
//	static boolean[] v;
	
	public static void main(String[] args) {	
		sel = new int[2];
//		v = new boolean[arr.length];
		
		recursive(0, 0);
	}
	
	private static void recursive(int count, int start) {
		// basis
		if (count == sel.length) {
			
			System.out.println(Arrays.toString(sel));
			
			return;
		}
		
		// inductive
		for (int i = start; i < arr.length; i++) {
//			if (v[i] == true) continue;
			
//			v[i] = true;
			sel[count] = arr[i];
			recursive(count + 1, i);
			sel[count] = 0;
//			v[i] = false;
			
		}
		
	}


}
