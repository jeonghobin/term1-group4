package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D3_1234 {

	//비밀번호
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int N = Integer.parseInt(st.nextToken());
			str = st.nextToken();
			List<Character> arr = new ArrayList<>();
			
			for (Character ch : str.toCharArray()) {
				arr.add(ch);
			}
			
			
			while (true) {
				int idx = 0;
				for (int i = 0; i < arr.size(); i++) {
					if((i+1)<arr.size() && arr.get(i)==arr.get(i+1)) {
						arr.remove(i+1);
						arr.remove(i);
						break;
					}
					idx = i;
				}
				if(idx==arr.size()-1)
					break;
			}
		
			System.out.print("#" + test_case + " ");
			for (char ch : arr) {
				System.out.print(ch);
			}
			System.out.println();
			
		}
	}

}
