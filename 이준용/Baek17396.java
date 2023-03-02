package day302;

import java.io.*;
import java.util.*;

public class Baek17396 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point implements Comparable<Point>{
		int e;
		long w;

		public Point(int e, long w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Long.compare(this.w, o.w);
		}
	}
	
	static int V,E;
	static ArrayList<Point>[]array;
	static long[]dist;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		array=new ArrayList[V];
		for(int i=0;i<V;i++) {
			array[i]=new ArrayList<>();
		}
		
		dist=new long[V];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		int[] see=new int[V];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<V-1;i++) {
			see[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			if(see[s]==0&&see[e]==0) {
				array[s].add(new Point(e, w));
				array[e].add(new Point(s, w));
			}
		}
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		dist[0]=0;
		q.add(new Point(0, 0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(dist[p.e]<p.w) continue;
			
			for(Point np:array[p.e]) {
				long nw=dist[p.e]+np.w;
				if(nw<dist[np.e]) {
					dist[np.e]=nw;
					q.add(new Point(np.e, nw));
				}
			}
		}
		System.out.println(Arrays.toString(dist));
		
		long answer=0;
		if(dist[V-1]==Long.MAX_VALUE) {
			answer=-1;
		}
		else {
			answer=dist[V-1];
		}
		bw.write(answer+"");
		bw.close();
	}
}
