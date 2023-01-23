package homwork.SWEA.d3_1208;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_1208/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			Integer[] array = new Integer[100]; 
			
			st = new StringTokenizer(br.readLine());
			int dumpTimes = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}

			
			Arrays.sort(array, Collections.reverseOrder());
			
			for (int i = 0; i < dumpTimes; i++) {
				array[0] -= 1;
				array[array.length -1] += 1;
				int temp;
				int tempIndex = 0;
				
				for (int j = 0; j < array.length -1; j++) {
					if (array[0] < array[j + 1]) {
						tempIndex = j + 1;
					} else {
						break;
					}
				}
				
				if (tempIndex != 0) {
					temp = array[0];
					array[0] = array[tempIndex];
					array[tempIndex] = temp;
				}
				
				
				tempIndex = 99;
				for (int j = array.length -1; j > 0 ; j--) {
					if (array[99] > array[j - 1]) {
						tempIndex = j - 1;
					} else {
						break;
					}
				}
				
				if (tempIndex != 99) {
					temp = array[99];
					array[99] = array[tempIndex];
					array[tempIndex] = temp;
				}
				
				if (array[0] - array[99] == 0) {
					break;
				}
			}
			
			sb.append("#" + test_case + " " + (array[0] - array[99]) + "\n");
		}
		
		System.out.println(sb);

	}
}
