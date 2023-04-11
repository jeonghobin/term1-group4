package day0406;

import java.io.*;
import java.util.*;

public class Baek1368 {
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
	
	static int N;
	static int[]price;
	static ArrayList<Point>[]array;
	static boolean[]v;

	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		price=new int[N];
		for(int i=0;i<N;i++) {
			price[i]=Integer.parseInt(br.readLine());
		}
		array=new ArrayList[N];
		v=new boolean[N];
		
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList<>();
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				if(i==j)continue;
//				array[i].add(new Point(j, price[i]));
//			}
//		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int w=Integer.parseInt(st.nextToken());
				if(i==j)continue;
				array[i].add(new Point(j, w));
			}
		}
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		v[0]=true;
		q.addAll(array[0]);
		int sum=0;
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(v[p.e]) continue;
			
			sum+=p.w;
			v[p.e]=true;
			q.addAll(array[p.e]);
		}
		
		System.out.println(sum);
	}
}
