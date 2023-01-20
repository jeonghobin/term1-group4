package Baekjoon.b1_1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>();
		
		String[] data = new String[2];
		
		String[] check = br.readLine().split("");

		int count = 0;
		
		if (check.length == 1) {
			data[0] = "0";
			data[1] = check[0];
		} else {
			data = check;
		}
		
		for (int i = 0; i < data.length; i++) {
			list.add(data[i]);
		}
		
		boolean isTrue = true;
		
		while(isTrue) {
			if (list.size() == 1) {
				list.add(0, "0");
			}
			
			String[] second = Integer.toString(Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1))).split("");
			
			list.set(0, list.get(1));
			
			if(second.length == 1) {
				list.set(1, second[0]);
			} else {
				list.set(1, second[1]);
			}
			
			count++;
			if ( list.get(0).equals(data[0]) && list.get(1).equals(data[1]) ) {
				System.out.println(count);
				isTrue = false;
			}
			
		}

	}

}
