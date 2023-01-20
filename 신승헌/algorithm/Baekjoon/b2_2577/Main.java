package Baekjoon.b2_2577;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String[] result = Integer.toString(A * B * C).split("");
		
		int[] array = new int[10];
		
		for (int i = 0; i < result.length; i++) {
			int index = Integer.parseInt(result[i]);
			array[index]++;
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		
		
		
	}
}
