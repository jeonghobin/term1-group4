import java.util.*;
import java.io.*;

// 백준 11050 이항계수1
// 조합의 경우의 수 를 구함

public class Main {
	static boolean[] visited;
	static int rs=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		visited = new boolean[a];
		comb(b,a,0,0);
		System.out.println(rs);

	}
	
	public static void comb(int n,int a,int cnt, int start) {
		if(n==cnt) {
			rs++;
			return;
		}
		for(int i=start;i<a;i++) {
			visited[i] = true;
			comb(n,a,cnt+1,i+1);
			visited[i] = false;
		}
	}

}
