package day09;

import java.io.*;
import java.util.*;

public class OX {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			String s = sc.next();			
			int answer = 0;
			int count = 0;
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'O') {
					count++;
					answer += count;
				} else {
					count = 0;
				}
			}
			System.out.println(answer);
		}

	}
}
