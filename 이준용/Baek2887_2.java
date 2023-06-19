package day0407;

import java.io.*;
import java.util.*;

public class Baek2887_2 {
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
	static int[][]map;
	static ArrayList<Point>[]array;
	static boolean[]v;


	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][3];
		array=new ArrayList[N];
		v=new boolean[N];
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList();
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int min=Integer.MAX_VALUE;
				for(int d=0;d<3;d++) {
					min=Math.min(min, Math.abs(map[i][d]-map[j][d]));
				}
				array[i].add(new Point(j, min));
				array[j].add(new Point(i, min));
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
		
		bw.write(sum+"");
		bw.close();
	}
}
