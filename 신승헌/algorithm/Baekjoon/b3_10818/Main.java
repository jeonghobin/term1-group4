package Baekjoon.b3_10818;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		String[] data = br.readLine().split(" ");
		
		int max = -1000000;
		int min = 1000000;
		
		for (int i = 0; i < data.length; i++) {
			int compare = Integer.parseInt(data[i]);
			if (compare > max) {
				max = compare;
			}
			
			if (compare < min) {
				min = compare;
			}
			
		}
		
		System.out.println(min + " " + max);
	}

}
