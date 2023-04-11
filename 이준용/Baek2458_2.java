package FloydWarchall;

import java.io.*;
import java.util.*;

public class Baek2458_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[][]map;
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) {
					map[i][j]=0;
				}
				else {
					map[i][j]=1000000;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			map[s][e]=1;
			//map[e][s]=1;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			int subcnt=0;
			for(int j=0;j<N;j++) {
				if(map[i][j]>0&&map[i][j]<=N)subcnt++;
				if(map[j][i]>0&&map[j][i]<=N)subcnt++;
			}
			if(subcnt==N-1) cnt++;
		}
		System.out.println(cnt);
	}
}
