package day09;

import java.util.*;
import java.io.*;


public class 순열 {
	
	static int[] arr = { 1, 3, 5, 7 };
	static int[] sel;
	static boolean[] v;
	
	public static void main(String[] args) {	
		sel = new int[2];
		v = new boolean[arr.length];
		
		recursive(0);
	}
	
	private static void recursive(int idx) {
		// basis
		if (idx == sel.length) {
			
			System.out.println(Arrays.toString(sel));
			
			return;
		}
		
		// inductive
		for (int i = 0; i < arr.length; i++) {
			if (v[i] == true) continue;
			
			v[i] = true;
			sel[idx] = arr[i];
			recursive(idx + 1);
			sel[idx] = 0;
			v[i] = false;
			
		}
		
	}


}
