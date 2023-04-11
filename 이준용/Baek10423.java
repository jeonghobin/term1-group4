package day0406;

import java.io.*;
import java.util.*;

public class Baek10423 {

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
	
	static int N,M,K;
	static ArrayList<Point>[]array;
	static boolean[]v;
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		array=new ArrayList[N];
		v=new boolean[N];
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList<>();
		}
		
		int generator[]=new int[K];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			generator[i]=Integer.parseInt(st.nextToken())-1;
		}
		
		for(int i=0;i<K;i++) {
			for(int j=i+1;j<K;j++) {
				array[generator[i]].add(new Point(generator[j], 0));
				array[generator[j]].add(new Point(generator[i], 0));
			}
		}
		
		for(int i=0;i<M;i++) {
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
