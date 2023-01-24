import java.util.*;
import java.io.*;


public class Main {
	
	// 직사각형을 몇개 만들 수 있는지 찾아내는 문제
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
 		int cnt,rs=0;
    // 주어진 N 까지 1,2,3,...,N까지에서 각각의 약수의 개수가 힌트가 된다.
    // 4 => 1 2 (2) 4 에서 1,4 조합과 2,2조합의 직사각형이 있기때문에 2개
    // 6 => 1 2 3 6 에서 1,6 2,3 2개
    // 3 => 1 3  1,3 조합 1개 모든 약수의 반절은 sqrt(N)을 넘지 않는다.
		for(int i=1;i<=N;i++) {
 			cnt=0;
 			for(int j=1;j*j<=i;j++) {
 				if(i%j==0) cnt++;
 			}
 			rs+=cnt;
 		}
		System.out.println(rs);
		
 	}

}
