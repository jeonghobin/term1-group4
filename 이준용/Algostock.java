package day0304;

import java.io.*;
import java.util.*;

public class Algostock {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int start, monplus;
	static int N,M;
	static int[][]map;
	
	static ArrayList[]buy;
	static int maxsum;
	
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			start=Integer.parseInt(st.nextToken());
			maxsum=start;
			monplus=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken())+1;
			map=new int[N][M];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			buy=new ArrayList[N];
			for(int i=0;i<N;i++) {
				buy[i]=new ArrayList<>();
			}
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M-1;j++) {
					if(map[i][j]<map[i][j+1]) {
						buy[i].add(j);
					}
				}
			}
			
			for(int i=0;i<M-1;i++) {
				recursive(maxsum, 0, i, new int[N]);
				maxsum+=monplus;
			}
			System.out.println("#"+t+" "+(maxsum-start-monplus*(M-1)));
		}

	}

	private static void recursive(int cash, int item, int month, int[]buylist) {
		if(item==N||month==M-1) {
			int sum=cash;
			for(int i=0;i<N;i++) {
				sum+=map[i][month+1]*buylist[i];
			}
			maxsum=Math.max(maxsum, sum);
			return;
		}
		
		if(!buy[item].contains(month)) {
			recursive(cash, item+1, month, buylist);
		}
		else {
			int cnt=cash/map[item][month];
			for(int i=0;i<=cnt;i++) {
				buylist[item]=i;
				cash-=map[item][month]*buylist[item];
				recursive(cash, item+1, month, buylist);
				cash+=map[item][month]*buylist[item];
				buylist[item]=0;
			}
		}
	}
}
