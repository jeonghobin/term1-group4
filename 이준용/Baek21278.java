package day0405;

import java.io.*;
import java.util.*;

public class Baek21278 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][]map=new int[N][N];
		int[][]time=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) map[i][j]=1000000;
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			map[s][e]=1;
			map[e][s]=1;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				time[i][j]=map[i][j]+map[j][i];
			}
		}
		
		int mini=0;
		int minj=0;
		int minsum=Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int sum=0;
				for(int k=0;k<N;k++) {
					sum+=Math.min(time[i][k], time[j][k]);
				}
				if(minsum>sum) {
					mini=i;
					minj=j;
					minsum=sum;
				}
			}
		}
		bw.write((mini+1)+" "+(minj+1)+" "+minsum);
		bw.close();
	}
}
