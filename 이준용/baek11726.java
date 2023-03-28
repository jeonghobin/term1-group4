package dp;

import java.io.*;
import java.util.*;

public class baek11726 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		memo=new int[N+1];
		
		memo[0]=1;
		memo[1]=2;
		
		bw.write(dp(N-1)+"");
		bw.close();

	}

	private static int dp(int n) {
		
		if(n>=2&&memo[n]==0) {
			memo[n]=dp(n-1)+dp(n-2);
		}
		return memo[n]%10007;
	}
}
