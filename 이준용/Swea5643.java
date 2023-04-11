package FloydWarchall;

import java.io.*;
import java.util.*;

public class Swea5643 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			int M=Integer.parseInt(br.readLine());
			int[][]map=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i!=j)map[i][j]=1000000;
				}
			}
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken())-1;
				int e=Integer.parseInt(st.nextToken())-1;
				map[s][e]=1;
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
					if((map[i][j]!=1000000||map[j][i]!=1000000)) {
						subcnt++;
					}
				}
				if(subcnt==N) cnt++;
			}
			bw.write(("#"+t+" "+cnt+"\n"));
		}
		bw.close();
	}
}
