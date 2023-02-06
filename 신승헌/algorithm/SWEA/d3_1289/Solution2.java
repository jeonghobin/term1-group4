package swea.d3_1289;

import java.io.*;
import java.util.*;

public class Solution2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			String[] original = st.nextToken().split("");
			int[] now = new int[original.length];
			int[] compare = new int[original.length];
			
			for (int i = 0; i < original.length; i++) {
				compare[i] = Integer.parseInt(original[i]);
				now[i] = 0;
			}
			
			int answer = 0;
			int change  = 0;
			
			for (int i = 0; i < compare.length; i++) {
//				if (now[i] == compare[i] && change == 0) {
//					continue;
//				}
				if ((now[i] != compare[i] && change == 0) || (now[i] == compare[i] && change != 0) ) {
					now[i] = (now[i] + 1) % 2;
					change = (change + 1) % 2;
					answer += 1;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}
