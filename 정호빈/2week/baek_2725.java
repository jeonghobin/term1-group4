import java.util.*;
import java.io.*;

// 유클리드 호제법을 사용한 정수론 문제

public class Main {
	
	public static int gcd(int num1,int num2) {
		if(num2==0) return num1;
		return gcd(num2,num1%num2);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[] dp = new int[1001];
		dp[0]=0;
		dp[1]=3;
		int cnt=0;
    // 보이는 점의 개수는 해당 (0,0)에서 (x,y)의 기울기를 보면 됨
    // 이때 4,3 이면 8,6은 보이지 않는 점임 그래서 셀 수 있는 점들의 공통점들은 최대공약수가 1이라는 점
		for(int i=2;i<1001;i++) {
			for(int j =i;j>=0;j--) {
        // 최대공약수가 1이면 한쪽면만 계산하니까 곱하기 2를 해주어 카운트를 늘려줌
				if(gcd(i,j)==1) cnt+=2;
			}
      // 다이나믹 프로그래밍 dp를 사용해 값을 구함 시간초과를 없애기 위함
			dp[i] = dp[i-1]+cnt;
			cnt=0;
		}
		int C = Integer.parseInt(br.readLine());
		for(int i=0;i<C;i++) {
			int xy = Integer.parseInt(br.readLine());
			
			System.out.println(dp[xy]);
		}
		
		
 	}
	
	
	
}
