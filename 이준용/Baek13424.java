package day0304;

import java.io.*;
import java.util.*;

public class Baek13424 {
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
	static int[] dist;
	
	static int fnum;
	static ArrayList<Integer> friends=new ArrayList<>();
	

	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			array=new ArrayList[V];
			for(int i=0;i<V;i++) {
				array[i]=new ArrayList<>();
			}
			
			dist=new int[V];
			
			for(int i=0;i<E;i++) {
				st=new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken())-1;
				int e=Integer.parseInt(st.nextToken())-1;
				int w=Integer.parseInt(st.nextToken());
				array[s].add(new Point(e, w));
				array[e].add(new Point(s, w));
			}
			
			fnum=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<fnum;i++) {
				friends.add(Integer.parseInt(st.nextToken())-1);
			}
			
			int[] sum=new int[V];
			for(int i:friends) {
				PriorityQueue<Point>q=new PriorityQueue<>();
				Arrays.fill(dist, 1000000);
				dist[i]=0;
				
				q.offer(new Point(i, 0));
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
				for(int j=0;j<V;j++) {
					sum[j]+=dist[j];	
				}
			}
			int minsum=sum[0];
			int minidx=0;
			for(int i=0;i<V;i++) {
				if(minsum>sum[i]) {
					minsum=sum[i];
					minidx=i;
				}
			}
			//System.out.println(Arrays.toString(sum));
			System.out.println(minidx+1);
			friends.clear();
		}
	}
}