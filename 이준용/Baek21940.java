package day0406;

import java.io.*;
import java.util.*;

public class Baek21940 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][]map=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) {
					map[i][j]=10000000;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			map[s][e]=w;
		}
		
		int K=Integer.parseInt(br.readLine());
		ArrayList<Integer>man=new ArrayList<Integer>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			man.add(Integer.parseInt(st.nextToken())-1);
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		
		
		int[][] map2=new int[N][N];
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				map2[i][j]=map[i][j]+map[j][i];
				map2[j][i]=map[i][j]+map[j][i];
			}
		}
		
		int min=Integer.MAX_VALUE;
		Queue<Integer>q=new LinkedList<Integer>();

		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<N;j++) {
				if(!man.contains(j)) continue;
				sum=Math.max(sum, map2[i][j]);
			}
			if(sum<min) {
				min=sum;
				q.clear();
				q.add(i);
			}
			else if(sum==min) q.add(i);
		}

		for(int i:q) {
			bw.write((i+1)+" ");
		}
		bw.close();
	}
}
