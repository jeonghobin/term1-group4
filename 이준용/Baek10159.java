package FloydWarchall;

import java.io.*;
import java.util.*;

public class Baek10159 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[][]map;

	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		map=new int[N][N];
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
		
		for(int i=0;i<N;i++) {
			int cnt=0;
			for(int j=0;j<N;j++) {
				if(map[i][j]==1000000&&map[j][i]==1000000) cnt++;
			}
			bw.write(cnt+"\n");
		}
		bw.close();
	}
}
