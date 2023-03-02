package day0302;

import java.io.*;
import java.util.*;

public class Baek16398 {
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
	
	static int V;
	static ArrayList<Point>[]array;
	static boolean[]v;

	public static void main(String[] args) throws IOException {
		V=Integer.parseInt(br.readLine());
		array=new ArrayList[V];
		v=new boolean[V];
		for(int i=0;i<V;i++) {
			array[i]=new ArrayList<>();
		}
		for(int i=0;i<V;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<V;j++) {
				int a=Integer.parseInt(st.nextToken());
				if(a!=0) {
					array[i].add(new Point(j, a));
				}
			}
		}
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		v[0]=true;
		q.addAll(array[0]);
		long sum=0;
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(v[p.e])continue;
			v[p.e]=true;
			sum+=p.w;
			q.addAll(array[p.e]);
		}
		bw.write(sum+"");
		bw.close();
	}
}
