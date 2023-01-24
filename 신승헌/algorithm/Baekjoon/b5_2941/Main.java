package homework.Baekjoon.b5_2941;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String s = st.nextToken();
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		int answer = 0;
		boolean croatiaOk = false;
				
		for (int i = 0; i < s.length(); i++) {
			croatiaOk = false;
			for (int j = 0; j < croatia.length; j++) {
				if (croatiaOk == true) {
					break;
				}
				// 첫 번째 문자가 같은 경우
				if (s.charAt(i) == croatia[j].charAt(0) && s.length() - i >= croatia[j].length()) {
					for (int k = 1; k < croatia[j].length(); k++) {
						if (s.charAt(i+k) == croatia[j].charAt(k)) {
							if (k == croatia[j].length() -1) {
								answer += 1;
								i = i + croatia[j].length() - 1;
								croatiaOk = true;
								break;
							}
							continue;
						} else {
							break;
						}
					}
				}

			}
			if (croatiaOk == false) {
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}
