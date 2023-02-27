package day0227;

import java.io.*;
import java.util.*;

public class Swea3289 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			parents=new int[N+1];
			rank=new int[N+1];
			
			for(int i=1;i<=N;i++) {
				parents[i]=i;
			}
			
			bw.write("#"+t+" ");
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int command=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				if(command==0) {
					union(a,b);
				}
				else {
					if(find(a)==find(b)) {
						bw.write(1+"");
					}
					else {
						bw.write(0+"");
					}
				}
			}
			bw.write("\n");
			bw.flush();
		}
	}

	private static int find(int b) {
		if(parents[b]==b) return b;
		else return parents[b]=find(parents[b]);
	}

	private static void union(int a, int b) {
		int na=find(a);
		int nb=find(b);
		
		if(na!=nb) {
			if(rank[na]>rank[nb]) {
				parents[nb]=na;
			}
			else{
				parents[na]=nb;
				if(rank[na]==rank[nb]) {
					rank[na]++;
				}
			}
		}
	}
}
