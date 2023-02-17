//package algo.bj.g5_2023;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		
//		int N = Integer.parseInt(st.nextToken());
//		
//		boolean[] prime = new boolean[(int) Math.pow(10, N)];
//
//		prime[0] = true;
//		prime[1] = true;
//		
//		for (int i = 2; i * i < prime.length; i++) {
//			if (prime[i] == false) {
//				for (int j = i*i; j < prime.length; j+=i) {
//					prime[j] = true;
//				}
//			}
//		}
//		
//		int lastNum = Integer.MAX_VALUE;
//		int nowNum;
//		
//		for (int i = (int)Math.pow(10, N-1); i < prime.length; i++) {
//			if (prime[i] == false) {
//				nowNum = i;
//				while(true) {
//					if(nowNum == 2 || nowNum == 3 || nowNum == 5 || nowNum == 7) {
//						sb.append(i + "\n");
//					}
//					if(prime[nowNum/10] == false) {
//						nowNum = nowNum/10;
//					} else {
//						break;
//					}
//				}
//			}
//		}
//		
//		System.out.println(sb);
//		
//	} // [E] main
//}

package algo.bj.g5_2023;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		if (N == 1) {
			sb.append(2+"\n"+3+"\n"+5+"\n"+7+"\n");
		} else {
			for (int i = (int)Math.pow(10, N-1); i < (int)Math.pow(10, N); i++) {
				if (!(i / (int)Math.pow(10, N-1) == 2
					|| i / (int)Math.pow(10, N-1) == 3
					|| i / (int)Math.pow(10, N-1) == 5
					|| i / (int)Math.pow(10, N-1) == 7)) {
					continue;
				}
				int number = i;
				L:while (true) {
					if (number == 0) {
						for(int j=3; j<=Math.sqrt(i); j ++) { 
					        if( i % j == 0 ) 
					            break L;
					    }
						sb.append(i+"\n");
						break;
					}
					if(!(number%10 == 1 || 
						number%10 == 2 || 
						number%10 == 3 || 
						number%10 == 5 ||
						number%10 == 9 ||
						number%10 == 7 )) {
						break;
					}
					number = number / 10;
				}
				
			}
			
		}
		System.out.println(sb);
	} // [E] main
}


