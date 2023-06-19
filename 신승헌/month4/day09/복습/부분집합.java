package day09.복습;

import java.util.*;
import java.io.*;


public class 부분집합 {
	
	static int[] arr = { 1, 3, 5, 7 };
//	static int[] sel;
	static boolean[] v;
	
	public static void main(String[] args) {	
//		sel = new int[2];
		v = new boolean[arr.length];
		
		recursive(0);
	}
	
	private static void recursive(int idx) {
		// basis
		if (idx == arr.length) {
			
			System.out.println(Arrays.toString(v));
			
			return;
		}
		
		// inductive
//		for (int i = 0; i < arr.length; i++) {
//			if (v[i] == true) continue;
			
			v[idx] = true;
			recursive(idx + 1);
			v[idx] = false;
			recursive(idx + 1);
			
//		}
		
	}


}
