package day0302;

import java.io.*;
import java.util.*;

public class Baek14950 {
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
	
	static int V,E,T;
	static ArrayList<Point>[] array;
	static boolean[]v;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		array=new ArrayList[V];
		v=new boolean[V];
		for(int i=0;i<V;i++) {
			array[i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			array[s].add(new Point(e, w));
			array[e].add(new Point(s, w));
		}
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		v[0]=true;
		q.addAll(array[0]);
		long sum=0;
		int plus=0;
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(v[p.e])continue;
			v[p.e]=true;
			
			sum+=p.w+plus;
			q.addAll(array[p.e]);
			plus+=T;
			
		}
		bw.write(sum+"");
		bw.close();
	}
}
