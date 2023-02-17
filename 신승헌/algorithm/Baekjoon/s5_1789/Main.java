package algo.bj.s5_1789;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long T = Long.parseLong(st.nextToken());
		
		Long answer = 1L;
		Long now = 0L;
		
		while(true) {
			if (now + answer > T) {
				break;
			}
			
			now = now + answer;
			answer += 1;
		}
		
		System.out.println(answer - 1);
	}
	
}
