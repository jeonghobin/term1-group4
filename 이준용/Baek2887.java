package day0407;

import java.io.*;
import java.util.*;

public class Baek2887 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point implements Comparable<Point>{
		int e,v;

		public Point(int e, int v) {
			super();
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.v-o.v;
		}
	}
	
	static int N;

	static ArrayList<Point>[]array;
	static boolean[]v=new boolean[100000];


	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());

		List<int[]>map=new ArrayList<int[]>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			map.add(new int[] {i,x,y,z});
		}
		
		array=new ArrayList[N+1];
		v=new boolean[N];
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList();
		}
		for(int i=1;i<=3;i++) {
			int idx=i;
			Collections.sort(map, (o1,o2)->(o1[idx]-o2[idx]));
			for(int j=1;j<N;j++) {
				int[]p1=map.get(j-1);
				int[]p2=map.get(j);
				int d=Math.abs(p1[i]-p2[i]);
				
				array[p1[0]].add(new Point(p2[0], d));
				array[p2[0]].add(new Point(p1[0], d));
			}
		}
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		q.add(new Point(0, 0));
		int sum=0;
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(v[p.e]) continue;
			
			sum+=p.v;
			v[p.e]=true;
			for(Point np:array[p.e]) {
				if(!v[np.e])q.add(np);
			}
		}
		
		bw.write(sum+"");
		bw.close();
	}
}
