package baekjoon;

// import java.util.*;
// import java.io.*;

// 피보나치 수(재귀함수 방법 시간초과 n의범위 45까지)
// 1초에 약 1억번 연산이기 때문에 시간초과
// public class Main {
	
	
// 	public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		StringTokenizer st;
// 		int N = Integer.parseInt(br.readLine());
// 		System.out.println(pibo(N));
//  	}
// 	public static int pibo(int num) {
// 		if(num==0) return 0;
// 		if(num==1) return 1;
// 		return pibo(num-1)+pibo(num-2);
// 	}
	
	
// }

import java.util.*;
import java.io.*;

// 동적계획법 -> 다이나믹 프로그래밍 -> dp 사용
// 이전의 값을 변수에 저장해 두어 구했던 값을 다시 구하는 연산을 반복하지 않음
public class Main {
	static int[] dp =new int[46];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N]);
 	}

}
	

