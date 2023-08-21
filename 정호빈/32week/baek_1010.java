import java.util.*;
import java.io.*;



public class Main {
	
	static int N,M;
	static int[][] d;
	
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			d = new int[N][M];
			for(int j=0;j<N;j++)
				Arrays.fill(d[j], -1);
			int cnt=0;
			for(int j=0;j<M;j++) {
				cnt+=recur(0,j);
			}
			System.out.println(cnt);
		}
		
	}
	
	
	public static int recur(int cur,int cur2) {
		if(cur2>=M)return 0;
		if(cur+1==N) return 1;
		if(d[cur][cur2]!=-1)return d[cur][cur2];
		d[cur][cur2] = 0;
		for(int i=cur2+1;i<=M;i++) {
			d[cur][cur2]+=recur(cur+1,i);
		}
		
		return d[cur][cur2];
	}

	

}
