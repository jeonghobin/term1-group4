import java.util.*;
import java.io.*;
public class Main {

  //백준 1749 점수따먹기
  //누적합으로 2차원 구간합을 모두구하고 완탐으로 풀어내는 형식의 문제
  
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		long[][] prefix = new long[N+1][M+1];
		long max = Long.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				prefix[i][j] = prefix[i][j-1]+prefix[i-1][j]
						-prefix[i-1][j-1]+arr[i][j];
				
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				for(int k=i;k<=N;k++) {
					for(int m=j;m<=M;m++) {
						max=max<prefix[k][m]-prefix[k][j-1]-prefix[i-1][m]+prefix[i-1][j-1]?
								prefix[k][m]-prefix[k][j-1]-prefix[i-1][m]+prefix[i-1][j-1]:max;
					}
				}
			}
		}
		
		
		
		System.out.println(max);
	}

}
