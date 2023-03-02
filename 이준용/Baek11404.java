package day0302;

import java.io.*;
import java.util.*;

public class Baek11404 {
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
	
	static int V,E;
	static ArrayList<Point>[]array;
	static boolean[]v;

	public static void main(String[] args) throws IOException {
		V=Integer.parseInt(br.readLine());
		E=Integer.parseInt(br.readLine());
		array=new ArrayList[V+1];
		v=new boolean[V+1];
		for(int i=0;i<V+1;i++) {
			array[i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			array[s].add(new Point(e, w));
			array[e].add(new Point(s, w));
		}
		PriorityQueue<Point>q=new PriorityQueue<>();
		
		
		
		for(int i=1;i<V+1;i++) {
			v[i]=true;
			q.addAll(array[i]);
			int sum=0;
			while(!q.isEmpty()) {
				Point p=q.poll();
				if(p.e==i) break;
				if(v[p.e]) continue;
				
				sum+=p.w;
				v[p.e]=true;
				q.addAll(array[p.e]);
			}
			System.out.print(sum+" ");
			v=new boolean[V+1];
		}

	}

}
