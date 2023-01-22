package homwork.SWEA.d3_1234;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_1234/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] s = st.nextToken().split("");
			
			ArrayList<Integer> password = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				password.add(Integer.parseInt(s[i]));
			}
			
			int idx = 0;
			while(true) {
				if (idx == password.size() - 1) {
					break;
				}
				if (password.get(idx) == password.get(idx + 1)) {
					password.remove(idx);
					password.remove(idx);
					
					if (idx == 0) {
						continue;
					} else {
						idx -= 1;
					}
				} else {
					idx += 1;
				}
			}
			
			sb.append("#" + test_case + " ");
			for (Integer integer : password) {
				sb.append(integer);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	
	}
}
