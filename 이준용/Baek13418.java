package day0407;

import java.io.*;
import java.util.*;

public class Baek13418 {
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
	
	static int N,M;
	static ArrayList<Point>[]array;
	static ArrayList<Point>[]array2;
	static boolean[]v;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken())+1;
		M=Integer.parseInt(st.nextToken());
		array=new ArrayList[N];
		array2=new ArrayList[N];
		v=new boolean[N];
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList<>();
			array2[i]=new ArrayList<>();
		}
		for(int i=0;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int v=(w==1)?1:0;
			int v2=(w==0)?1:0;
			array[s].add(new Point(e, v));
			array2[s].add(new Point(e, v2));
			
		}
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		v[0]=true;
		q.addAll(array[0]);
		int sum=0;
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(v[p.e])continue;
			sum+=p.w;
			v[p.e]=true;
			q.addAll(array[p.e]);
		}
		
		v=new boolean[N];
		v[0]=true;
		q.addAll(array2[0]);
		int sum2=0;
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(v[p.e])continue;
			sum2+=p.w;
			v[p.e]=true;
			q.addAll(array2[p.e]);
		}
		System.out.println(sum2*sum2-sum*sum);
	}
}
