package baek;

import java.io.*;
import java.util.*;

public class Baek22865 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
	static ArrayList<Integer> people=new ArrayList<Integer>();
	static ArrayList<Point>[]array;
	static int[] dist;
	
	static int[] sum;
	
	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++) {
			people.add(Integer.parseInt(st.nextToken())-1);
		}
		M=Integer.parseInt(br.readLine());
		
		array=new ArrayList[N];
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			array[s].add(new Point(e, w));
			array[e].add(new Point(s, w));
		}
		
		dist=new int[N];
		sum=new int[N];
		Arrays.fill(sum,Integer.MAX_VALUE);
		
		PriorityQueue<Point> q=new PriorityQueue<>();
		for(int man:people) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[man]=0;
			q.add(new Point(man,0));
			while(!q.isEmpty()) {
				Point p=q.poll();
				if(dist[p.e]<p.w) continue;
				
				for(Point np:array[p.e]) {
					int nw=dist[p.e]+np.w;
					if(nw<dist[np.e]) {
						dist[np.e]=nw;
						q.add(new Point(np.e, nw));
					}
				}
			}
			for(int i=0;i<N;i++) {
				sum[i]=Math.min(sum[i], dist[i]);
			}
		}
		
		int max=0;
		int idx=0;
		for(int i=0;i<N;i++) {
			if(people.contains(i)||sum[i]==Integer.MAX_VALUE) continue;
			
			if(max<sum[i]) {
				max=sum[i];
				idx=i;
			}
		}
		System.out.println(idx+1);
	}
}
