package FloydWarchall;

import java.io.*;
import java.util.*;

public class 사람네트워크2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int[][]map=new int[N][N];	
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==0&&i!=j)map[i][j]=1000000;
				}
			}
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			int minsum=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				int subsum=0;
				for(int j=0;j<N;j++) {
					subsum+=map[i][j];
				}
				minsum=Math.min(minsum, subsum);
			}
			bw.write("#"+t+" "+minsum+"\n");
		}
		bw.close();
	}
}
