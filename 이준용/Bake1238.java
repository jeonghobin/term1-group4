package day0302;

import java.io.*;
import java.util.*;

public class Bake1238 {
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
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int V,E,X;
	static ArrayList<Point>[][]array;
	static int[][]dist;
	

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken())-1;
		array=new ArrayList[2][V];
		dist=new int[2][V];
		
		for(int i=0;i<V;i++) {
			array[0][i]=new ArrayList<>();
			array[1][i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			array[0][s].add(new Point(e, w));
			array[1][e].add(new Point(s, w));
		}
		
		int max=0;
		
		int[]sum=new int[V];
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		for(int i=0;i<V;i++) {
			for(int j=0;j<2;j++) {
				Arrays.fill(dist[j], Integer.MAX_VALUE);
				//Arrays.fill(dist[1], Integer.MAX_VALUE);
				
				dist[j][i]=0;
				q.add(new Point(i, 0));
				while(!q.isEmpty()) {
					Point p=q.poll();
					if(dist[j][p.e]<p.w) continue;
					
					for(Point np:array[j][p.e]) {
						int nw=dist[j][p.e]+np.w;
						if(nw<dist[j][np.e]) {
							dist[j][np.e]=nw;
							q.add(new Point(np.e, nw));
						}
					}
				}
				sum[i]+=dist[j][X];
			}
		}
		Arrays.sort(sum);
		System.out.println(sum[V-1]);
	}
}
