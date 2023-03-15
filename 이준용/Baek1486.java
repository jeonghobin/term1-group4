package day0314;

import java.io.*;
import java.util.*;

public class Baek1486 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point implements Comparable<Point>{
		int e,w;

		public Point(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	static ArrayList<Point>[]array;
	static ArrayList<Point>[]array2;
	static int[]dist1;
	static int[]dist2;
	
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	static int N,M,T,D;
	
	static int[][]map;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		array=new ArrayList[N*M];
		array2=new ArrayList[N*M];
		for(int i=0;i<N*M;i++) {
			array[i]=new ArrayList<>();
			array2[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<M;j++) {
				int a=word.charAt(j);
				a=(a<=90)?a-65:a-71;
				map[i][j]=a;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int d=0;d<4;d++) {
					int nr=i+dr[d];
					int nc=j+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<M&&Math.abs(map[i][j]-map[nr][nc])<=T) {
						int w=(int) Math.pow(Math.abs(map[i][j]-map[nr][nc]), 2);
						if(map[i][j]<map[nr][nc]) {	
							array[i*M+j].add(new Point(nr*M+nc, w));
							array2[i*M+j].add(new Point(nr*M+nc, 1));
						}
						else if(map[i][j]>map[nr][nc]){
							array[i*M+j].add(new Point(nr*M+nc, 1));
							array2[i*M+j].add(new Point(nr*M+nc, w));
						}
						else if(map[i][j]==map[nr][nc]){
							array[i*M+j].add(new Point(nr*M+nc, 1));
							array2[i*M+j].add(new Point(nr*M+nc, 1));
						}
					}
				}
			}
		}
		//올라갈 때
		dist1=new int[N*M];
		Arrays.fill(dist1, Integer.MAX_VALUE);
		
		PriorityQueue<Point>q1=new PriorityQueue<>();
		dist1[0]=0;
		q1.add(new Point(0, 0));
		while(!q1.isEmpty()) {
			Point p=q1.poll();
			if(dist1[p.e]<p.w) continue;
			
			for(Point np:array[p.e]) {
				int nw=dist1[p.e]+np.w;
				if(nw<dist1[np.e]) {
					dist1[np.e]=nw;
					q1.add(new Point(np.e, nw));
				}
			}
		}
	
		//내려갈때
		dist2=new int[N*M];
		Arrays.fill(dist2, Integer.MAX_VALUE);
		dist2[0]=0;
		q1.add(new Point(0, 0));
		while(!q1.isEmpty()) {
			Point p=q1.poll();
			if(dist2[p.e]<p.w) continue;
			
			for(Point np:array2[p.e]) {
				int nw=dist2[p.e]+np.w;
				if(nw<dist2[np.e]) {
					dist2[np.e]=nw;
					q1.add(new Point(np.e, nw));
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dist1[i*M+j]=dist1[i*M+j]+dist2[i*M+j]<=D?dist1[i*M+j]+dist2[i*M+j]:-1;
			}
		}
		
		int max=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(dist1[i*M+j]>=0) {
					max=Math.max(max, map[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
