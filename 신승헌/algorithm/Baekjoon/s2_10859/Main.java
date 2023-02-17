package algo.bj.s2_10859;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		String N = st.nextToken();
//		ArrayList<String> answer = new ArrayList<>();
		String answer = "";
		
		if (isPrime(Long.parseLong(N))) {
			for (int i = N.length() - 1; i >= 0; i--) {
				int now = N.charAt(i) - '0';
				
				switch (now) {
				case 0:
				case 1:
				case 2:
				case 5:
				case 8:
					answer += now;
					break;					

				case 6:
					answer += "9";
					break;

				case 9:
					answer += "6";
					break;
					
				case 3:
				case 4:
				case 7:
					System.out.println("no");
					return;
				}
			}
		} else {
			System.out.println("no");
			return;
		}
		
//		System.out.println(answer);
		
		if (isPrime(Long.parseLong(answer))) {
			System.out.println("yes");
		} else {
			System.out.println("no");			
		}
		
		
	}

	private static boolean isPrime(long N) {
		if (N < 2) {
			return false;
		}
		
		if (N == 2) {
			return true;
		}
		
		if (N > 2) {
			for (int i = 2; i <= Math.sqrt(N); i++) {
				if (N % i == 0) {
					return false;
				}
			}
			return true;
		}
		return true;
	}
}
